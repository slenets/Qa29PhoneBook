package application;

import models.User;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserHelper extends HelperBase{
    public UserHelper(WebDriver wd) {
        super(wd);
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
        Alert alert = wd.switchTo().alert();
        alert.accept();
    }

}
