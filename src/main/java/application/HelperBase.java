package application;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.lang.model.element.Element;

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
        wd.findElement(selector).click();
//        WebElement element = new WebDriverWait(wd, 5).until(ExpectedConditions.visibilityOf(wd.findElement(selector)));
//        element.click();
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
