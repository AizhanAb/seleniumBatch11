package WindowHandle;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class SwitchWindow {
    @Test
    public void practice1(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/windows");
        WebElement copyRight = driver.findElement(By.xpath("//a[@href='/windows/new']"));
        copyRight.click();


        String str="New Window";
        //System.out.println(text.getText());

        System.out.println(driver.getWindowHandle());
        System.out.println(driver.getWindowHandles());
        String nameId= driver.getWindowHandle();
        Set<String> allPagesId= driver.getWindowHandles();
        for(String id: allPagesId){
            if(!id.equals(nameId)){
                driver.switchTo().window(id);
            }
        }
        WebElement text = driver.findElement(By.tagName("h3"));
        Assert.assertEquals(text.getText(),str);
    }
    @Test
    public void prcatice2(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
        driver.manage().window().maximize();
        WebElement button=driver.findElement(By.xpath("//button[@id='newTabBtn']"));
        button.click();
        String nameId= driver.getWindowHandle();
        BrowserUtils.switchOnlyforTwoTabs(driver, nameId);
//        Set<String> allPagesId= driver.getWindowHandles();
//        for(String id: allPagesId){
//            if(!id.equals(nameId)){
//                driver.switchTo().window(id);
//            }
//        }
        WebElement htag=driver.findElement(By.xpath("//h1[@itemprop='name']"));
        String val="AlertsDemo";
        Assert.assertEquals(htag.getText(), val);
        WebElement button2= driver.findElement(By.id("alertBox"));
        button2.click();

    }


    @Test
    public static void practiceWindow(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/windows");
        WebElement click= driver.findElement(By.xpath("//a[.='Click Here']"));
        click.click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open('https://www.techtorialacademy.com/')");
        js.executeScript("window.open('https://www.techtorialacademy.com/about-us')");
        js.executeScript("window.open('https://www.techtorialacademy.com/programs')");
//        Set <String> lists=driver.getWindowHandles();
//        for(String page:lists){
//            driver.switchTo().window(page);
//            if(driver.getTitle().contains("Home")){
//                break;
//            }
//        }
        BrowserUtils.switchByTitle(driver, "Home");
    }

}
