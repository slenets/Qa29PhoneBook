package application;

import models.Contact;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

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
        List<WebElement> els = wd.findElements(By.className("contact-item_card__2SOIM"));

        return els.size() > 0;
    }

    public void removeContact() {
        if (containsContact()) {
            click(By.className("contact-item_card__2SOIM"));
        }
        try {
            click(By.xpath("//button[text()='Remove']"));

        } catch (StaleElementReferenceException e) {
            System.out.println("Stale element reference exception");
            click(By.className("contact-item_card__2SOIM"));
            click(By.xpath("//button[text()='Remove']"));
        }catch (NoSuchElementException e){
            System.out.println("No such element exception");
            click(By.className("contact-item_card__2SOIM"));
            click(By.xpath("//button[text()='Remove']"));
        }

    }
//        JavascriptExecutor js = (JavascriptExecutor) wd;
//        js.executeScript("document.querySelector('.contact-item_card__2SOIM').click();")

    public void deleteAllContacts() {
        while (true) {
            if (!wd.findElement(By.xpath("//div[@class='contact-page_leftdiv__yhyke']/div/div[1]")).isDisplayed()) {
                System.out.println("Loop done!");
                break;
            } else {
                System.out.println(wd.findElement(By.xpath("//div[@class='contact-page_leftdiv__yhyke']/div/div[1]")).isDisplayed());
                removeContact();
            }

            //pause(2000);
        }

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
