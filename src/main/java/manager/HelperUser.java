package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HelperUser extends HelperBase {

    public HelperUser(WebDriver wd) {
        super(wd);
    }

    public void contactBtnClick()  {
        click(By.cssSelector("a.nav-link[href='/#contact']"));

    }
    public boolean sendUsAMassageFormIsHere(){
        WebElement sendUsAMassageForm = wd.findElement(By.xpath("//h3[text()='Send Us a Message']"));
        waitForElementInViewport(wd,sendUsAMassageForm,10);
       return isElementInViewport(wd,sendUsAMassageForm);
    }
    public void locationBtnClick(){
       click(By.xpath("//a[text()='Location']"));
    }
    public boolean ourLocationInformationIsHere(){
        WebElement ourLocHeader = wd.findElement(By.xpath("//h2[text()='Our Location']"));
        waitForElementInViewport(wd,ourLocHeader,10);
        return isElementInViewport(wd,ourLocHeader);
    }
    public void roomsBtnClick(){
        click(By.xpath("//a[text()='Rooms']"));
    }
    public boolean ourRoomsFieldIsHere(){
        WebElement ourRoomsField = wd.findElement(By.xpath("//h2[text()='Our Rooms']"));
        waitForElementInViewport(wd,ourRoomsField,10);
        return isElementInViewport(wd,ourRoomsField);
    }
    public void bookingBtnClick(){
        WebElement locationTab = wd.findElement(By.xpath("//a[text()='Booking']"));
        locationTab.click();
    }
    public boolean availabilityBtnIsHere(){
        WebElement availability = wd.findElement(By.xpath("//button[text()='Check Availability']"));
        waitForElementInViewport(wd,availability,10);
        return isElementInViewport(wd,availability);
    }
    public void scrollToTheEnd(){
        WebElement contactUs = wd.findElement(By.xpath("//div[@class='text-center']"));
        scrollToElement(wd,contactUs);
    }
    public boolean thisIsFooter(){
        WebElement footer = wd.findElement(By.xpath("//div[@class='text-center']"));
        return isElementInViewport(wd,footer);
    }
}
