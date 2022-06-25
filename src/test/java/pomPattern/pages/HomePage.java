package pomPattern.pages;

import org.openqa.selenium.By;

public class HomePage extends BasePage{
    private By heading = By.xpath("//h1[text()='Home Component']");

    public String getHeading(){
        return driver.findElement(heading).getText();
    }

}
