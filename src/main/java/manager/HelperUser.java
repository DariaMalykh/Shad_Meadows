package manager;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HelperUser extends HelperBase{
    public HelperUser(WebDriver wd) {
        super(wd);
    }
    public void scrollToMessageField(){
        WebElement footer = wd.findElement(By.xpath("//textarea[@data-testid='ContactDescription']"));
        scrollUntilVisible(footer);
    }
    public void fillSendAsMessageForm(User user){
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
        return isElementInViewport(wd,element);
    }
}
