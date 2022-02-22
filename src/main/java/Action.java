import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class Action {
    @Test
    public void ContextClick(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        WebElement contextMenu = driver.findElement(By.partialLinkText("Context"));
        contextMenu.click();
        WebElement box= driver.findElement(By.id("hot-spot"));
        Actions action=new Actions(driver);

        action.contextClick(box).perform();

    }

    @Test
    public void HoverOver() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        WebElement hover = driver.findElement(By.linkText("Hovers"));
        hover.click();
        Thread.sleep(1000);

        List<WebElement> picture=driver.findElements(By.xpath("//div[@class='figure']//img"));
        List<WebElement> names=driver.findElements(By.tagName("h5"));
        List<String> expectedNAme = Arrays.asList("name: user1","name: user2","name: user3");

        Actions actions= new Actions(driver);

        for(int i=0; i<names.size(); i++){
            Thread.sleep(1000);
            actions.moveToElement(picture.get(i)).perform();
            System.out.println(BrowserUtils.getText(names.get(i)));
            Assert.assertEquals(BrowserUtils.getText(names.get(i)), expectedNAme.get(i));
            //Assert.assertEquals(BrowserUtils.getText(names.get(i)), expectedNAme.get(i));
        }

    }

    @Test
    public void moveByOffset() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.Techtorialacademy.com/");
        WebElement contuctUs = driver.findElement(By.xpath("//h2[.='information']//..//a[.='Contact Us']"));
        Point location= contuctUs.getLocation();
       //BrowserUtils.scrollWithXandY(driver, contuctUs);

        System.out.println(location.getX());
        System.out.println(location.getY());
       Actions actions=new Actions(driver);
actions.click(contuctUs).perform();
      // actions.moveByOffset(location.getX(), location.getY()).click().perform();

       //Thread.sleep(2000);
             // BrowserUtils.clickWithJs(driver, contuctUs);
    }
}
