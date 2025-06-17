package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HelperBooking extends HelperBase{
    public HelperBooking(WebDriver wd) {
        super(wd);
    }
    public void scrollToBookingForm() {
        WebElement checkBtn= wd.findElement(By.xpath("//button[text()='Check Availability']"));
        scrollUntilVisible(checkBtn);
    }
}
