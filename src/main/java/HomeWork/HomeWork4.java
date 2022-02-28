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

import java.util.ArrayList;
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
        for(int i=0; i<options.size(); i++){
            select.selectByIndex(i);
        }
        WebElement all4= driver.findElement(By.xpath("//div[@id='result']"));
        String all$expect="India United states of America China England";
        Assert.assertEquals(all4.getText(), all$expect);
//        select.selectByIndex(0);
//        select.selectByIndex(1);
//        select.selectByIndex(2);
//        select.selectByIndex(3);
//        for(WebElement vis: options){
//            if(vis.isSelected()){
//                Assert.assertTrue(vis.isDisplayed());
//                System.out.println("test is passed");
//            }
//
//        }
        Thread.sleep(1000);
        select.deselectByIndex(2);
        select.deselectByValue("england");

    }
    @Test
    public static void t3() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get( "https://www.cars.com/");
        WebElement make= driver.findElement(By.xpath("//select[@id='makes']"));
//        Select select = new Select(make);
        BrowserUtils.selectBy(make, "Toyota", "text");
        WebElement models= driver.findElement(By.xpath("//select[@id='models']"));
        BrowserUtils.selectBy(models, "Corolla", "text");
        WebElement used= driver.findElement(By.xpath("//select[@id='make-model-search-stocktype']"));
        BrowserUtils.selectBy(used,"cpo", "value");
        WebElement price= driver.findElement(By.xpath("//select[@id='make-model-max-price']"));
        BrowserUtils.selectBy(price, "30000", "value");
        WebElement distance = driver.findElement(By.xpath("//select[@id='make-model-maximum-distance']"));
        BrowserUtils.selectBy(distance, "40", "value");
        Thread.sleep(1000);
        WebElement zipCode = driver.findElement(By.xpath("//input[@id='make-model-zip']"));
        Actions actions= new Actions(driver);
        zipCode.clear();
       zipCode.sendKeys("60018");

        WebElement searchButton = driver.findElement(By.xpath("//button[@class='sds-button'and .='Search']"));
      searchButton.click();
      WebElement header3 = driver.findElement(By.xpath("//div[@class='heading-container']//h1"));
      String actHeader = "Certified used Toyota Corolla for sale";
      Assert.assertEquals(header3.getText(), actHeader);
     Assert.assertTrue(header3.isDisplayed());
     List<WebElement> miles40 = driver.findElements(By.xpath("//select[@id='location-distance']//option"));
        String check1 = "40 miles";
        for(WebElement vis: miles40){
            if(vis.isSelected()){
                Assert.assertEquals(vis.getText(), check1);
                System.out.println("test is passed");
            }
        }

        List<WebElement> cert = driver.findElements(By.xpath("//select[@id='stock-type-select']//option"));
        System.out.println(cert.size());
        String check2 = "Certified";
        for(WebElement vis: cert){
            if(vis.isSelected()){
                Assert.assertEquals(vis.getText(), check2);
                System.out.println("test is passed2");
            }
        }
    }

    @Test
    public void test4(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.cars.com/");
        WebElement selectType= driver.findElement(By.xpath("//select[@id='make-model-search-stocktype']"));
        BrowserUtils.selectBy(selectType,"New cars","text");
        WebElement makes= driver.findElement(By.xpath("//select[@id='makes']"));
        BrowserUtils.selectBy(makes,"Lexus","text");
        WebElement model= driver.findElement(By.xpath("//select[@id='models']"));
        BrowserUtils.selectBy(model,"ES 350","text");
        WebElement price= driver.findElement(By.xpath("//select[@id='make-model-max-price']"));
        BrowserUtils.selectBy(price,"$50,000","text");
        WebElement distance= driver.findElement(By.xpath("//select[@id='make-model-maximum-distance']"));
        BrowserUtils.selectBy(distance,"50 miles","text");
        WebElement zipCode= driver.findElement(By.xpath("//input[@id='make-model-zip']"));
        zipCode.clear();
        zipCode.sendKeys("60016");
        WebElement search= driver.findElement(By.xpath("//button[@data-searchtype='make']"));
        search.click();

        List<WebElement> cars=driver.findElements(By.xpath("//div[@class='vehicle-card-main js-gallery-click-card']"));
        int count=0;
        for(WebElement car:cars){
            if(car.isDisplayed()){
                count++;
            }
        }
        Assert.assertTrue(count<20);

        List<WebElement> names=driver.findElements(By.xpath("//h2[@class='title']"));
        for(WebElement name:names){
            String actual= name.getText();
            String expected="Lexus ES 350";
            Assert.assertTrue(actual.contains(expected));
            System.out.println(name.getText());
        }
        List<WebElement> distS=driver.findElements(By.xpath("//div[@class='vehicle-dealer']//following-sibling::div[@class='miles-from ']"));


        for (WebElement dis:distS){
            if(dis.isDisplayed()){
                String num = dis.getText().substring(0,2).trim();
                int numCheck=Integer.parseInt(num);
                Assert.assertTrue(50>numCheck);

            }
            }
    }

    }


