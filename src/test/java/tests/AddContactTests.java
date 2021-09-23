package tests;

import models.Contact;
import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactTests extends TestBase{
//================================= Last Homework ==================================//
    @BeforeMethod
    public void precondition(){
        User user = User.builder().email("a1@b1.ru").password("AAbb3'$'").build();
        if(app.helper().isElementPresent(By.xpath("//*[@href='/login']"), "LOGIN")){
            app.helper().openLoginForm();
            app.helper().fillSubmitLoginForm(user);
        }
    }

    @Test
    public void addContact(){
        app.helper().click(By.xpath("//a[text()='ADD']"));
        int i = (int)System.currentTimeMillis()/100000000;

        Contact contact = Contact.builder()
                .name("James" + i)
                .lastName("Frei"+i)
                .phone("0"+ i)
                .email("frei"+i+"@gmail.com")
                .address("Rehovot")
                .description("Some text to write")
                .build();
        app.contactHelper().addNewContact(contact);

        Assert.assertTrue(app.contactHelper().isContactAdded(contact.getPhone()));
    }
}
