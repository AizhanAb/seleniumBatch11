package iFrame;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;

public class iFrameTask {
    @Test
    public static void t1() throws InterruptedException {
        /*
TASK:
    1)Navigate to the website "https://skpatro.github.io/demo/iframes/"
    2)Click Pavilion and click selenium-java and validate the header
    3)Go back to mainPage and click category1
    4)from new webpage validate the title is ending with "qavalidation"
    5)Go back to mainppage and click Category3
    6)validate the new url is equal to "https://qavalidation.com/category/softwaretesting/"
 */
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://skpatro.github.io/demo/iframes/");
        WebElement pavilion=driver.findElement(By.xpath("//a[.='Pavilion']"));
        pavilion.click();
        Set<String> listId=driver.getWindowHandles();
        BrowserUtils.switchByTitle(driver, "Home - qavalidation");
        List<WebElement> selen=driver.findElements(By.xpath("//span[@class='menu-item-text']//span[.='Selenium']"));
        Actions actions=new Actions(driver);
        for(WebElement a : selen){
            if(a.isDisplayed())
                actions.moveToElement(a).perform();
        }
        WebElement selenJava=driver.findElement(By.xpath("//span[@class='menu-item-text']//span[.='Selenium-Java']"));
        actions.moveToElement(selenJava).click().perform();
        WebElement header= driver.findElement(By.xpath("//div//h1"));
        String expHeader = "Selenium-Java Tutorial – Basic to Advance";
        Assert.assertEquals(header.getText(), expHeader);

        BrowserUtils.switchByTitle(driver, "iframes");
        driver.switchTo().frame("Frame1");
        Thread.sleep(1000);
        WebElement category1=driver.findElement(By.xpath("//a[.='Category1']"));
        category1.click();
        BrowserUtils.switchByTitle(driver, "SeleniumTesting Archives - qavalidation");
        String actualTitle=driver.getTitle();
        Assert.assertTrue(actualTitle.contains("qavalidation"));
        WebElement head2=driver.findElement(By.tagName("h1"));
        String actHeader2= head2.getText();
        String expHeader2="Category Archives: SeleniumTesting";
        Assert.assertEquals(actHeader2, expHeader2);
        BrowserUtils.switchByTitle(driver, "iframes");
        driver.switchTo().frame("Frame2");

    }
}
