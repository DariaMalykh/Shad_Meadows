package manager;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HelperBase {
    WebDriver wd;

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }
    public void type(By locator, String text){
        WebElement element = wd.findElement(locator);
        element.click();
        element.clear();
        clearNew(element);
        if(text != null) {
            element.sendKeys(text);
        }
    }
    public void clearNew(WebElement element) {
        element.sendKeys(" ");
        element.sendKeys(Keys.BACK_SPACE);
    }
    public void pause(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void click(By locator){
        WebElement element = wd.findElement(locator);
        element.click();
    }
    public boolean isElementInViewport(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return (Boolean) js.executeScript(
                "const rect = arguments[0].getBoundingClientRect();" +
                        "return (" +
                        "  rect.top >= 0 &&" +
                        "  rect.left >= 0 &&" +
                        "  rect.bottom <= (window.innerHeight || document.documentElement.clientHeight) &&" +
                        "  rect.right <= (window.innerWidth || document.documentElement.clientWidth)" +
                        ");", element);
    }
    public void waitForElementInViewport(WebDriver driver, WebElement element, int timeoutSeconds) {
        new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds)).until(d -> {
            JavascriptExecutor js = (JavascriptExecutor) d;
            return (Boolean) js.executeScript(
                    "const rect = arguments[0].getBoundingClientRect();" +
                            "return (rect.top >= 0 && rect.bottom <= window.innerHeight);",
                    element
            );
        });
    }
    public boolean isElementPresent (By locator){
        WebElement element = wd.findElement(locator);
        return isElementInViewport(wd,element);
    }
    public void scrollToElement(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);

    }
    public void scrollUntilVisible(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) wd;

        for (int i = 0; i < 20; i++) {
            js.executeScript("window.scrollBy(0, 300);");
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (isElementInViewport(wd,element)) {
                break;
            }
        }
    }
    public String getElementText(By locator) {
        WebElement element = wd.findElement(locator);
        return element.getText();
    }


}
