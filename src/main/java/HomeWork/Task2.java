package HomeWork;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task2 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","chromedriver");
        WebDriver driver= new ChromeDriver();
        driver.get("https://demoqa.com/radio-button");
        driver.manage().window().maximize();
        WebElement yes= driver.findElement(By.id("yesRadio"));
        System.out.println(yes.isSelected());
        System.out.println(yes.isDisplayed());
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()",yes);
        Thread.sleep(500);
        yes.click();
    }
}