package application;

import models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

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
        return wd.findElement(By.xpath("//h3[text()='" + text + "']")).isDisplayed();
    }

    public boolean containsContact() {
        return wd.findElements(By.className("contact-item_card__2SOIM")).size() > 0;
    }

    public void removeContact() {
        if (containsContact()) {
            click(By.className("contact-item_card__2SOIM"));
            click(By.xpath("//button[text()='Remove']"));
        }
//        JavascriptExecutor js = (JavascriptExecutor) wd;
//        js.executeScript("document.querySelector('.contact-item_card__2SOIM').click();")
    }

    public void deleteAllContacts(){

        while (containsContact()){
            removeContact();
            pause(1000);
        }


//        while(wd.findElement(By.className("contact-item_card__2SOIM")).isDisplayed()){
//            removeContact();
//            pause(2000);
        //}

    }

    public int getAllContactsNumber() {
        return wd.findElements(By.className("contact-item_card__2SOIM")).size();
    }

    public List<WebElement> getContactsList() {
        return wd.findElements(By.className("contact-item_card__2SOIM"));
    }

    public void openContactForm() {
        wd.findElement(By.cssSelector("[href='/add']")).click();
    }
}
