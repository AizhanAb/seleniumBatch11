package alert;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class alertInfo {
    @Test
    public static void JSBasicAlertTest(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.manage().window().maximize();
        WebElement buttonJs=driver.findElement(By.xpath("//button[.='Click for JS Alert']"));
        buttonJs.click();
        Alert alert = driver.switchTo().alert();

        String alertText= alert.getText();
        String expText ="I am a JS Alert";
        Assert.assertEquals(alertText, expText);
        alert.accept();
        WebElement message = driver.findElement(By.xpath("//p[@id='result']"));
        String actMessage= message.getText();
        String expecmessage = "You successfully clicked an alert";
        Assert.assertEquals(actMessage, expecmessage);



//        WebElement header= driver.findElement(By.tagName("h3"));
//        System.out.println(header.getText());

    }

    @Test
    public static void JSAllertDismiss() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.manage().window().maximize();
        WebElement buttonJs = driver.findElement(By.xpath("//button[.='Click for JS Confirm']"));
        buttonJs.click();
        Alert alert = driver.switchTo().alert();

//        String alertText= alert.getText();
//        String expText ="I am a JS Alert";
//        Assert.assertEquals(alertText, expText);
        alert.dismiss();
        WebElement message = driver.findElement(By.xpath("//p[@id='result']"));
        String actMessage= message.getText();
        String expecmessage = "You clicked: Cancel";
        Assert.assertEquals(actMessage, expecmessage);

    }
    @Test
    public static void JSSendKeys() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.manage().window().maximize();
        WebElement buttonJs = driver.findElement(By.xpath("//button[.='Click for JS Prompt']"));
        buttonJs.click();
        Alert alert = driver.switchTo().alert();

//        String alertText= alert.getText();
//        String expText ="I am a JS Alert";
//        Assert.assertEquals(alertText, expText);
        alert.sendKeys("Techtorial");
        alert.accept();
        WebElement message = driver.findElement(By.xpath("//p[@id='result']"));
        String actMessage= message.getText();
        String expecmessage = "You entered: Techtorial";
        Assert.assertEquals(actMessage, expecmessage);

    }
}
