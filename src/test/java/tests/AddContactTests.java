package tests;

import models.Contact;
import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactTests extends TestBase{
    @BeforeMethod
    public void precondition(){
        User user = User.builder().email("a1@b1.ru").password("AAbb3'$'").build();
        if(!app.helper().isLogged()){
            app.helper().login(user);
        }
    }

    @Test(invocationCount = 5)
    public void addContact(){
        int i = (int)((System.currentTimeMillis()) / 1000) % 3600;

        Contact contact = Contact.builder()
                .name("James" + i)
                .lastName("Frei"+i)
                .phone("0" + i)
                .email("frei"+i+"@gmail.com")
                .address("Rehovot")
                .description("Some text to write")
                .build();
        app.contactHelper().openContactForm();
        app.contactHelper().addNewContact(contact);
        app.contactHelper().pause(500);
        Assert.assertTrue(app.contactHelper().isContactAdded(contact.getPhone()));
    }


}
