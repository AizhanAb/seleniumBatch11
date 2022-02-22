import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PracticeSelBasics {
    public static void main(String[] args) {
        System.setProperty("wedriver.chrome.driver", "chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        System.out.println(driver.getTitle());
        System.out.println(driver.getPageSource());
        System.out.println(driver.getCurrentUrl());
        driver.navigate().to("https://en.wikipedia.org/wiki/Main_Page");
        System.out.println(driver.getTitle());
        System.out.println(driver.getPageSource());
        System.out.println(driver.getCurrentUrl());
        driver.navigate().to("https://akipress.org/");
        System.out.println(driver.getTitle());
        System.out.println(driver.getPageSource());
        System.out.println(driver.getCurrentUrl());
        driver.navigate().back();
        driver.navigate().back();
        driver.navigate().forward();
        driver.quit();
    }
}
