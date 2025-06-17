package manager;

import com.sun.source.tree.BreakTree;
import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        List<WebElement> alertMessages = wd.findElements(
                By.xpath("//div[contains(@class, 'alert') and contains(@class, 'alert-danger')]//p")
        );
        StringBuilder fullText = new StringBuilder();
        for (WebElement el : alertMessages) {
            fullText.append(el.getText());
        }
        String result = fullText.toString();
        String[] resultSplit = result.split("(?=[A-Z])");
        //Set<String> expectedWords = new HashSet<>(Arrays.asList(message.split("\\s+")));
        // Set<String> actualWords = new HashSet<>(Arrays.asList(result.split("\\s+")));
        // return actualWords.containsAll(expectedWords);
        for (String rs : resultSplit) {
            if (rs.isEmpty()) continue;
            if (!message.contains(rs)) {
                return false;
            }
        }
return true;
    }
}


