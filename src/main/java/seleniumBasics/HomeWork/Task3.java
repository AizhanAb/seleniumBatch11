package seleniumBasics.HomeWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task3 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        WebElement name= driver.findElement(By.id("user-name"));
        name.sendKeys("Java");
        WebElement password= driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("Selenium");
        WebElement press= driver.findElement(By.xpath(" //input[@id='login-button']"));
        press.click();
        Thread.sleep(1000);
        WebElement error= driver.findElement(By.xpath("//h3[@data-test='error']"));
        System.out.println(error.getText());
        if(error.getText().equals("Epic sadface: Username and password do not match any user in this service")){
            System.out.println("Error is there");
        }


    }
}
