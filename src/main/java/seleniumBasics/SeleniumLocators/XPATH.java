package seleniumBasics.SeleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XPATH {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("file:///Users/aizhanabdraiymova/Desktop/projectday/Techtorial%20(2).html");
        driver.manage().window().maximize();
      WebElement javaLink= driver.findElement(By.xpath("//a[@href='https://www.oracle.com/java/']"));
        System.out.println(javaLink.getText());
        javaLink.click();
        driver.navigate().to("");
    }
}
