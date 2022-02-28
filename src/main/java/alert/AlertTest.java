package alert;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertTest {
    @Test
    public static void alertT1(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://sweetalert.js.org/");

        WebElement button = driver.findElement(By.xpath("//h5[contains(text(),'Normal alert')]//following-sibling::button"));
        button.click();
        Alert alert = driver.switchTo().alert();
       String actText=  alert.getText();
       String expText = "Oops, something went wrong!";
        Assert.assertEquals(actText, expText);
        alert.accept();

        WebElement button2 = driver.findElement(By.xpath("//h5[contains(text(),'SweetAlert')]//following-sibling::button"));
        button.click();
       String valText2="Oops, something went wrong!";
        WebElement alertText2 = driver.findElement(By.xpath("//div[.='Something went wrong!']"));
        Assert.assertEquals(alert.getText(),valText2 );
        WebElement okBut = driver.findElement(By.xpath("//button[@class='swal-button swal-button--confirm']"));

    }
    @Test
    public static void alertT2() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://sweetalert.js.org/");

        //Alert alert = driver.switchTo().alert();

        WebElement button2 = driver.findElement(By.xpath("//h5[contains(text(),'SweetAlert')]//following-sibling::button"));
        button2.click();
        Thread.sleep(1000);
        String valText2="Something went wrong!";
        WebElement alertText2 = driver.findElement(By.xpath("//div[.='Something went wrong!']"));
        Assert.assertEquals(alertText2.getText(),valText2 );
        WebElement okBut = driver.findElement(By.xpath("//button[@class='swal-button swal-button--confirm']"));
        okBut.click();
    }
}
