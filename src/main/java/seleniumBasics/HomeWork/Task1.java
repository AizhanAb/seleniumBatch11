package seleniumBasics.HomeWork;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Task1 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","chromedriver");
        WebDriver driver= new ChromeDriver();
        driver.get("https://demoqa.com/text-box");
        driver.manage().window().maximize();
        WebElement first= driver.findElement(By.id("userName"));
        first.sendKeys("Aizhan Abd");
        WebElement email= driver.findElement(By.id("userEmail"));
        email.sendKeys("abdrayimova@gmail.com");
        WebElement currentAddress= driver.findElement(By.id("currentAddress"));
        currentAddress.sendKeys("2200 East Devon ave ");
        WebElement permanentAddress= driver.findElement(By.id("permanentAddress"));
        permanentAddress.sendKeys("5824 N northwest HWY");
        //WebElement button= driver.findElement(By.xpath("//button[@id='submit']"));
       // driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        WebElement button= driver.findElement(By.xpath("//button[@id='submit']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", button);
        Thread.sleep(500);

        button.click();

        Thread.sleep(2000);
        button.click();
        button.click();
        Thread.sleep(2000);
        WebElement name=driver.findElement(By.id("name"));
        if(name.equals("Aizhan Abd")){
            System.out.println("Full name is correct");
        }else{
            System.out.println("something went wrong with name");
        }
        WebElement emailAddress=driver.findElement(By.id("email"));
        if(emailAddress.equals("abdrayimova@gmail.com")){
            System.out.println("Email  is correct");
        }else{
            System.out.println("something went wrong with email");
        }
        WebElement addressNow=driver.findElement(By.xpath("//p[@id='currentAddress']"));
        if(addressNow.equals(currentAddress)){
            System.out.println("2200 East Devon ave ");
        }else{
            System.out.println("something went wrong with address");
        }
        WebElement addressAllTime=driver.findElement(By.xpath("//p[@id='permanentAddress']"));
        if(addressAllTime.equals("5824 N northwest HWY")){
            System.out.println("Permanent address  is correct");
        }else{
            System.out.println("something went wrong with permanent address");
        }

    }
}
