package tests;

import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @BeforeMethod
    public void precondition(){
        if(app.helper().isLogged()){
            app.helper().signOut();
        }
    }

    //Positive login
    @Test
    public void loginSuccess() {
        //Lombok uses
        User user = User.builder().email("a1@b1.ru").password("AAbb3'$'").build();
        app.helper().openLoginForm();
        app.helper().fillSubmitLoginForm(user);
        Assert.assertTrue(app.helper().isElementPresent(By.xpath("//*[text()='Sign Out']"),"Sign Out"));
    }

    //Negative email login
    @Test
    public void loginWithWrongEmail(){
        //Lombok uses
        User user = User.builder().email("a1b1.ru").password("AAbb3'$'").build();
        app.helper().openLoginForm();
        app.helper().fillSubmitLoginForm(user);
        app.helper().pause(2000);
        app.helper().alertHandle();

        Assert.assertTrue(app.helper().isElementPresent(By.xpath("//*[text()='Login Failed with code 400']"),
                "Login Failed with code 400"));
    }

    //Negative password login
    @Test
    public void loginWithWrongPassword(){
        //Lombok uses
        User user = User.builder().email("a1@b1.ru").password("AAbb'$'").build();
        app.helper().openLoginForm();
        app.helper().fillSubmitLoginForm(user);
        app.helper().pause(2000);
        //Alert
        app.helper().alertHandle();

        Assert.assertTrue(app.helper().isElementPresent(By.xpath("//*[text()='Login Failed with code 400']"),
                "Login Failed with code 400"));
    }

//    @AfterMethod
//    public void postCondition(){
//        if(app.helper().isElementPresent(By.xpath("//*[text()='Sign Out']"), "Sign Out")) {
//            app.helper().signOut();
//        }
//    }


}
