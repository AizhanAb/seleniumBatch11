package iFrame;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NestedFrame {
    @Test
    public static void t1(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        driver.manage().window().maximize();
        driver.switchTo().frame(0);

        WebElement frameRight = driver.findElement(By.name("frame-right"));
        WebElement middleFrame = driver.findElement(By.name("frame-middle"));
        driver.switchTo().frame(middleFrame);
        WebElement content = driver.findElement(By.id("content"));
        String actual= content.getText();
        String expected = "MIDDLE";
        Assert.assertEquals(actual, expected);
      // frameRight = driver.findElement(By.name("frame-right"));
        driver.switchTo().parentFrame();
        driver.switchTo().frame(frameRight);
        WebElement right = driver.findElement(By.xpath("//body[contains(text(),'RIGHT')]"));
        System.out.println(right.getText());
        driver.switchTo().defaultContent();
//
//driver.switchTo().parentFrame();
//driver.switchTo().parentFrame();
        //WebElement frameBottom = driver.findElement(By.name("frame-bottom"));
        driver.switchTo().frame("frame-bottom");
        WebElement bottom = driver.findElement(By.xpath("//body[contains(text(),'BOTTOM')]"));
        System.out.println(bottom.getText());

    }
}
