package HomeWork;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class HomeWork4 {
    @Test
    public static void t1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://uitestpractice.com/Students/Select#");
        WebElement drop= driver.findElement(By.xpath("//select[@id='countriesSingle']"));
        List<WebElement> options=driver.findElements(By.xpath("//select[@id='countriesSingle']//option"));
        String expectDrop="India";

        for(WebElement vis: options){
            if(vis.isSelected()){
                Assert.assertEquals(vis.getText(), expectDrop);
                System.out.println("test is passed");
            }
        }

        Assert.assertEquals(options.size(), 4);
        System.out.println(drop.getText());
         String expecList="        India\n" +
        "        United states of America\n" +
        "        China\n" +
        "        England" +
        "";
        Assert.assertEquals(drop.getText().trim(), expecList.trim());
       Select select= new Select(drop);
       Thread.sleep(1000);
       select.selectByValue("england");
        Thread.sleep(1000);
       select.selectByIndex(2);
        Thread.sleep(1000);
       select.selectByVisibleText("United states of America");


    }
    @Test
    public static void t2() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://uitestpractice.com/Students/Select#");
        WebElement multip= driver.findElement(By.xpath("//select[@id='countriesMultiple']"));
        Select select= new Select(multip);
        String multipOp="        India\n" +
                "United states of America\n" +
                "China\n" +
                "England";
        Assert.assertEquals(multip.getText().trim(), multipOp.trim());
        select.selectByVisibleText("China");
        BrowserUtils.selectBy(multip, "england", "value");
        List<WebElement> options=driver.findElements(By.xpath("//select[@id='countriesMultiple']//option"));


        for(WebElement vis: options){
            if(vis.isSelected()){
                Assert.assertTrue(vis.isDisplayed());
                System.out.println("test is passed");
            }

        }
        select.deselectAll();
        Thread.sleep(1000);
        select.selectByIndex(0);
        select.selectByIndex(1);
        select.selectByIndex(2);
        select.selectByIndex(3);
        for(WebElement vis: options){
            if(vis.isSelected()){
                Assert.assertTrue(vis.isDisplayed());
                System.out.println("test is passed");
            }

        }
        Thread.sleep(1000);
        select.deselectByIndex(2);
        select.deselectByValue("england");

    }
    @Test
    public static void t3(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get( "https://www.cars.com/");
        WebElement make= driver.findElement(By.xpath("//select[@id='makes']"));
//        Select select = new Select(make);
        BrowserUtils.selectBy(make, "Toyota", "text");
        WebElement models= driver.findElement(By.xpath("//select[@id='models']"));
        BrowserUtils.selectBy(models, "Corolla", "text");
        WebElement price= driver.findElement(By.xpath("//select[@id='make-model-max-price']"));
        BrowserUtils.selectBy(price, "30000", "value");
        WebElement distance = driver.findElement(By.xpath("//select[@id='make-model-maximum-distance']"));
        BrowserUtils.selectBy(distance, "40", "value");
        WebElement zipCode = driver.findElement(By.xpath("//select[@id='make-model-maximum-distance']"));
       zipCode.sendKeys("600018");


    }
}
