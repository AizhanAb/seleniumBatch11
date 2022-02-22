package seleniumBasics.SeleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class LinkAndTags {
    public static void main(String[] args) {
        WebDriver driver= new ChromeDriver();
        driver.get("file:///Users/aizhanabdraiymova/Desktop/projectday/Techtorial%20(2).html");
        driver.manage().window().maximize();
        WebElement javalink= driver.findElement(By.linkText("Java"));
        javalink.click();
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        driver.navigate().back();
        WebElement Selenium= driver.findElement(By.linkText("Selenium"));
        Selenium.click();
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        driver.navigate().back();
        WebElement Cucumber = driver.findElement(By.linkText("Cucumber"));
        Cucumber.click();
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        driver.navigate().back();
        WebElement javaLink2= driver.findElement(By.linkText("Java"));

        javaLink2.click();
        driver.navigate().back();
        WebElement restApi= driver.findElement(By.partialLinkText("Rest"));
        restApi.click();

        WebElement version = driver.findElement(By.tagName("u"));
        System.out.println(version.getText());


    }
}
