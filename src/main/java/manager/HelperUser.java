package manager;

import com.sun.source.tree.BreakTree;
import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.*;
import java.util.stream.Collectors;

public class HelperUser extends HelperBase {
    public HelperUser(WebDriver wd) {
        super(wd);
    }

    public void scrollToMessageField() {
        WebElement footer = wd.findElement(By.xpath("//textarea[@data-testid='ContactDescription']"));
        scrollUntilVisible(footer);
    }

    public void scrollToAlertField() {
        WebElement alertField = wd.findElement(By.xpath("//div[@class='alert alert-danger']"));
        scrollUntilVisible(alertField);
    }

    public void fillSendAsMessageForm(User user) {
        type(By.xpath("//input[@data-testid='ContactName']"), user.getName());
        type(By.xpath("//input[@data-testid='ContactEmail']"), user.getEmail());
        type(By.xpath("//input[@data-testid='ContactPhone']"), user.getPhone());
        type(By.xpath("//input[@data-testid='ContactSubject']"), user.getSubject());
        type(By.xpath("//textarea[@data-testid='ContactDescription']"), user.getMessage());

    }

    public void clickSubmitBtn() {
        click(By.xpath("//button[text()='Submit']"));
    }

    public boolean contactFormSuccessfullySubmitted() {
        WebElement element = wd.findElement(By.xpath("//h3[contains(text(),'Thanks for getting in touch')]"));
        return isElementInViewport(wd, element);
    }

    public boolean isMessagePresent(String message) {
        return getElementText(By.xpath("//h3[contains(text(),'Thanks for getting in touch')]")).contains(message);
    }

    public boolean isAlertPresent(String message) {
        return getElementText((By.xpath("//div[@class='alert alert-danger']"))).contains(message);
    }

    public boolean allMessageIsHere(String message) {
        if (message == null || message.trim().isEmpty()) {
            return false;
        }
        List<WebElement> alertMessages = wd.findElements(
                By.xpath("//div[contains(@class, 'alert') and contains(@class, 'alert-danger')]//p")
        );
        StringBuilder fullText = new StringBuilder();
        for (WebElement el : alertMessages) {
            fullText.append(el.getText()).append(" ");
        }
        String result = fullText.toString();
        if (result.isEmpty()) {
            return false;
        }
        List<String> resultList = Arrays.stream(result.split("(?=[A-Z])"))
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .map(String::toLowerCase)
                .collect(Collectors.toList());

        List<String> messageList = Arrays.stream(message.split("(?=[A-Z])"))
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .map(String::toLowerCase)
                .collect(Collectors.toList());

        Collections.sort(resultList);
        Collections.sort(messageList);

        return resultList.equals(messageList);
    }
}


