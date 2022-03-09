package Utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class DriverHelper {
    private static WebDriver driver;

    private DriverHelper(){}

    public static WebDriver getDriver(){
        if(driver==null){// I am checking if the driver is null
            // if it is we create the new one.
            //if it is not we create new driver.

            switch (ConfigReader.readProperty("browser")){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    driver.manage().deleteAllCookies();//for fresh start testing
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    //this implicit will wait for elements around 10 sec to be loaded.
                    break;
                case  "firefox" :
                        WebDriverManager.firefoxdriver().setup();
                        driver = new FirefoxDriver();
                        driver.manage().window().maximize();
                        driver.manage().deleteAllCookies();//for fresh start testing
                        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                        //this implicit will wait for elements around 10 sec to be loaded.
                default:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    driver.manage().deleteAllCookies();//for fresh start testing
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    //this implicit will wait for elements around 10 sec to be loaded.
            }
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();//for fresh start testing
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            //this implicit will wait for elements around 10 sec to be loaded.
        }
        return driver;

    }

    public static void tearDown(){
        driver.quit();
        driver=null;
    }
}
