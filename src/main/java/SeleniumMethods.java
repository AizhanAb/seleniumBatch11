import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumMethods {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        System.setProperty("wedriver.chrome.driver", "chromedriver");
        //navigate to method navigates to the page.
        driver.navigate().to("https://www.amazon.com/");
        //Thread.sleep(3000);
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getPageSource());
        driver.navigate().to("http://www.techtorialacademy.com/");
        driver.navigate().back();
        //Thread.sleep(3000);
        driver.navigate().forward();
        //Thread.sleep(3000);
        driver.navigate().refresh();

        //driver.quit();
        driver.close();
    }

}
