package application;

import models.User;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserHelper extends HelperBase{
    public UserHelper(WebDriver wd) {
        super(wd);
    }

    public void login(User user){
        openLoginForm();
        fillSubmitLoginForm(user);
    }

    public void openLoginForm(){
        click(By.xpath("//a[text()='LOGIN']"));
    }

    public void fillSubmitLoginForm(User user){
        typeTextbox(By.xpath("//*[@placeholder='Email']"), user.getEmail());
        typeTextbox(By.xpath("//*[@placeholder='Password']"), user.getPassword());
        click(By.xpath("//button[text()=' Login']"));
    }

    public void fillSubmitRegistrationForm(User user){
        typeTextbox(By.xpath("//*[@placeholder='Email']"), user.getEmail());
        typeTextbox(By.xpath("//*[@placeholder='Password']"), user.getPassword());
        click(By.xpath("//button[text()=' Registration']"));
    }

    public boolean isElementPresent(By selector, String text){
        String res = wd.findElement(selector).getText();
        System.out.println(res);
        return res.equals(text);
    }

    public boolean isRegistered(By selector){
        String res = wd.findElement(selector).getText();
        System.out.println(res);
        return res.equals("No Contacts here!");
    }

    public void signOut(){
        click(By.xpath("//*[text()='Sign Out']"));
    }


    public void alertHandle(){
        pause(1000);
        Alert alert = wd.switchTo().alert();
        alert.accept();
    }

    public boolean isAlertPresent() {
        Alert alert = (Alert) new WebDriverWait(wd, 10).until(ExpectedConditions.alertIsPresent());// if it \is false returns null
        if(alert==null){

            return false;
        }else{
            wd.switchTo().alert();
            alert.accept();
            return true;
        }
    }

    public boolean isLogged() {
        return wd.findElements(By.xpath("//button[text()='Sign Out']")).size() > 0;

                //wd.findElement(By.xpath("//button[text()='Sign Out']")).isDisplayed();
    }
}
