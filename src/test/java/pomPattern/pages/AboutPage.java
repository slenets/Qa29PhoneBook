package pomPattern.pages;

import org.openqa.selenium.By;

public class AboutPage extends BasePage{

    private By aboutHeading = By.xpath("//h1[text()=' Contacts Web Application']");

    public String getHeading(){
        return driver.findElement(aboutHeading).getText();
    }

}
