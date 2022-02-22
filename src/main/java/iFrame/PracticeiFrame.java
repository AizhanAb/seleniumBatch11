package iFrame;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PracticeiFrame {
    @Test
    public static void p1(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/iframe");
        driver.manage().window().maximize();
        driver.switchTo().frame("mce_0_ifr");
        WebElement parag= driver.findElement(By.tagName("p"));
        System.out.println(parag.getText());
        parag.clear();
        parag.sendKeys("I love Selenium");
        System.out.println(parag.getText());
        driver.switchTo().parentFrame();
        WebElement h3= driver.findElement(By.tagName("h3"));
                String header=h3.getText();
        String expected = "An iFrame containing the TinyMCE WYSIWYG Editor";
        Assert.assertEquals(header, expected);

    }
}
