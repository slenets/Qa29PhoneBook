package application;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    WebDriver wd;
    UserHelper userHelper;
    ContactHelper contactHelper;
    String browser;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public void init(){
        if(browser.equals(BrowserType.CHROME)){
            wd = new ChromeDriver();
        }else if(browser.equals(BrowserType.FIREFOX)){
            wd = new FirefoxDriver();
        }else if (browser.equals(BrowserType.EDGE)){
            wd = new EdgeDriver();
        }




        wd.manage().window().maximize();
        wd.navigate().to("https://contacts-app.tobbymarshall815.vercel.app/home");
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        userHelper = new UserHelper(wd);
        contactHelper = new ContactHelper(wd);
    }

    public void stop(){
        wd.quit();
    }

    //----------------- Getters ----------------------

    public UserHelper helper() {
        return userHelper;
    }

    public ContactHelper contactHelper() {
        return contactHelper;
    }
}
