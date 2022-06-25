package pomPattern.pages;

import models.User;
import org.openqa.selenium.By;

public class LoginPage extends BasePage{
    private By email = By.xpath("//input[@placeholder = 'Email']");
    private By password = By.xpath("//input[@placeholder = 'Password']");
    private By loginBtn = By.xpath("//button[text() = ' Login']");
    private By registrationBtn = By.xpath("//button[text() = ' Registration']");


    public void login(User user){
        setText(email, user.getEmail());
        setText(password, user.getPassword());
    }

    public void registration(User user){
        login(user);
    }

    public void clickRegistration(){
        clickElement(registrationBtn);
    }

    public void clickLogin(){
        assert(driver.getPageSource().contains("product"));
        clickElement(loginBtn);
    }

}
