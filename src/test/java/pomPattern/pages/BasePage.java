package pomPattern.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BasePage {
    public static WebDriver driver;
    public String browser;
    public String baseUrl;
    public Properties properties;

    // load properties and assign them to field variables
    public void loadProperties(){
        FileInputStream fis = null;
        try{
            properties = new Properties();
            fis = new FileInputStream(new File("config.properties"));
            properties.load(fis);

            browser = properties.getProperty("browser", "chrome");
            //browser = System.getProperty("browser", properties.getProperty("browser"));
            baseUrl = properties.getProperty("baseUrl");
        }catch(IOException e){
            e.printStackTrace();
        }finally {
            try{
                if(fis != null)
                fis.close();
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }

    public void openBrowser(){
        if(browser.equals("chrome")){
            driver = new ChromeDriver();
        }
        if(browser.equals("firefox")){
            driver = new FirefoxDriver();
        }
        driver.navigate().to(baseUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void closeBrowser(){
        driver.quit();
    }

    public void clickElement(By locator){
        driver.findElement(locator).click();
    }

    public void setText(By selector, String text){
        WebElement element = driver.findElement(selector);
        if(text != null){
            element.click();
            element.clear();
            element.sendKeys(text);
        }
    }





}
