package application;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.lang.model.element.Element;
import java.util.concurrent.TimeUnit;

public class HelperBase {
    WebDriver wd;

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }

    public void pause(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void click(By selector) {
//        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//        wd.findElement(selector).click();
        WebElement element = wd.findElement(selector);

       wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            element.click();

    }

    public void typeTextbox(By selector, String input) {
        if (input != null) {
            WebElement element = wd.findElement(selector);
            element.click();
            element.clear();
            element.sendKeys(input);
        }
    }
}
