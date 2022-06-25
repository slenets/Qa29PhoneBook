package pomPattern.pages;

import org.openqa.selenium.By;

public class NavigationBar extends BasePage{
    private By home = By.xpath("//a[@href = '/home']");
    private By about = By.xpath("//a[@href = '/about']");
    private By login = By.xpath("//a[@href = '/login']");


    public HomePage goToHomePage(){
        clickElement(home);
        return new HomePage();
    }

    public AboutPage goToAboutPage(){
        clickElement(about);
        return new AboutPage();
    }

    public LoginPage goToLoginPage(){
        clickElement(login);
        return new LoginPage();
    }
}
