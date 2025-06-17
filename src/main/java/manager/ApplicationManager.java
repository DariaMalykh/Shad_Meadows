package manager;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    WebDriver wd;
    @Getter
    HelperNavigate helperNavigate;
    @Getter
    HelperUser helperUser;
    @Getter
    HelperBooking helperBooking;

    public void init() {
        wd = new ChromeDriver();
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wd.navigate().to("https://automationintesting.online/");
        helperNavigate = new HelperNavigate(wd);
        helperUser = new HelperUser(wd);
        helperBooking = new HelperBooking(wd);
    }

    public void stop() {
        wd.quit();
    }
}

