package tests;

import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase {

    //Positive registration
    @Test
    public void registrationSuccess() {
        int i = (int) System.currentTimeMillis() / 100000000;

        User user = User.builder().email("a1@b1" + i + ".ru").password("AAbb3" + i + "'$'").build();
        app.helper().openLoginForm();
        app.helper().fillSubmitRegistrationForm(user);
        Assert.assertTrue(app.helper().isRegistered(By.xpath("//*[text()=' No Contacts here!']")));
    }

    //Negative email
    @Test
    public void registrationWithWrongEmail(){
        User user = User.builder().email("a1b1.ru").password("AAbb3'$'").build();
        app.helper().openLoginForm();
        app.helper().fillSubmitRegistrationForm(user);
        app.helper().pause(2000);
        app.helper().alertHandle();

        Assert.assertTrue(app.helper().isElementPresent(By.xpath("//*[text()='Registration failed with code 400']"),
                "Registration failed with code 400"));
    }

    //Negative password
    @Test
    public void registrationWithWrongPassword(){
        User user = User.builder().email("a1@b1.ru").password("AAbb'$'").build();
        app.helper().openLoginForm();
        app.helper().fillSubmitRegistrationForm(user);
        app.helper().pause(2000);
        app.helper().alertHandle();

        Assert.assertTrue(app.helper().isElementPresent(By.xpath("//*[text()='Registration failed with code 400']"),
                "Registration failed with code 400"));
    }

    @AfterMethod
    public void postCondition(){
        if(app.helper().isElementPresent(By.xpath("//*[text()='Sign Out']"), "Sign Out")) {
            app.helper().signOut();
        }
    }
}
