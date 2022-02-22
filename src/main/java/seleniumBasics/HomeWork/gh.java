package seleniumBasics.HomeWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class gh {
    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();
        //Locator ID
        driver.get("file:///Users/aizhanabdraiymova/Desktop/projectday/Techtorial%20(2).html");
        WebElement checkbox=driver.findElement(By.id("cond3"));
        checkbox.click();
        System.out.println(checkbox.isDisplayed());
        System.out.println(checkbox.isSelected());

        WebElement checkbox4=driver.findElement(By.id("cond4"));
        checkbox4.click();
    }
}
