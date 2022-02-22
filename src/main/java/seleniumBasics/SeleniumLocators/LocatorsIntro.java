package seleniumBasics.SeleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsIntro {
    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();
        //Locator ID
        driver.get("file:///Users/aizhanabdraiymova/Desktop/projectday/Techtorial%20(2).html");
        WebElement header= driver.findElement(By.id("techtorial1"));
        String actualText= header.getText();//from the DOM
        String expectedText = "Techtorial Academy";
        if(actualText.equals(expectedText)){
            System.out.println("pass");
        }else{
            System.out.println("failed");
        }
        WebElement text= driver.findElement(By.id("details2"));
        System.out.println(text.getText());

        WebElement tools=driver.findElement(By.className("group_checkbox"));
        System.out.println(tools.getText());
        //Locator Name
        WebElement firstName= driver.findElement(By.name("firstName"));
        firstName.sendKeys("Aizhan");
        WebElement lastName= driver.findElement(By.name("lastName"));
        lastName.sendKeys("Abdraiymova");
        WebElement email= driver.findElement(By.name("userName"));
        email.sendKeys("agajg");
        WebElement phone = driver.findElement(By.name("phone"));
        phone.sendKeys("5465446465");
        WebElement address = driver.findElement(By.name("address1"));
        address.sendKeys("2200 east devon ave ");
        WebElement city = driver.findElement(By.name("city"));
        city.sendKeys("Chicago ");
        WebElement state = driver.findElement(By.name("state"));
        address.sendKeys("Illinois");
        WebElement checkbox=driver.findElement(By.id("cond3"));
        checkbox.click();
        System.out.println(checkbox.isDisplayed());
        System.out.println(checkbox.isSelected());

        WebElement checkbox4=driver.findElement(By.id("cond4"));
        checkbox4.click();

        System.out.println(checkbox4.isDisplayed());
        System.out.println(checkbox4.isSelected());

    }
    }

