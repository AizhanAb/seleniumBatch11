package seleniumBasics.HomeWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase4 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        WebElement name= driver.findElement(By.id("user-name"));
        name.sendKeys("standard_user");
        WebElement password= driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("secret_user");
        WebElement press= driver.findElement(By.xpath(" //input[@id='login-button']"));
        press.click();
        Thread.sleep(1000);

        if(driver.getCurrentUrl().equals("https://www.saucedemo.com/")){
            System.out.println("Url is matching");
        }
    }
}
