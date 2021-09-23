package application;

import models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactHelper extends HelperBase {
    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void addNewContact(Contact contact) {
        typeTextbox(By.xpath("//*[@placeholder='Name']"), contact.getName());
        typeTextbox(By.xpath("//*[@placeholder='Last Name']"), contact.getLastName());
        typeTextbox(By.xpath("//*[@placeholder='Phone']"), contact.getPhone());
        typeTextbox(By.xpath("//*[@placeholder='email']"), contact.getEmail());
        typeTextbox(By.xpath("//*[@placeholder='Address']"), contact.getAddress());
        typeTextbox(By.xpath("//*[@placeholder='description']"), contact.getDescription());
        click(By.xpath("//b[text()='Save']"));
    }

    public boolean isContactAdded(String text) {
        click(By.xpath("//a[text()='CONTACTS']"));
        return wd.findElement(By.xpath("//h3[text()='" + text + "']")).isDisplayed();
    }
}
