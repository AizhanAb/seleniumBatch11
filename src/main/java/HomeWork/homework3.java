package HomeWork;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class homework3 {



    @Test
    public void demos1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demos.telerik.com/kendo-ui/websushi#");
        driver.manage().window().maximize();
        WebElement shiromi=driver.findElement(By.xpath("//img[@title='Shiromi']"));
        Actions actions= new Actions(driver);
        actions.click(shiromi).perform();
        WebElement next = driver.findElement(By.id("navigate-next"));
        next.click();
        WebElement tekkamaki=driver.findElement(By.xpath("//h1[.='Tekka maki']"));
        String validate="Tekka maki";
        System.out.println(tekkamaki.getText());
        Thread.sleep(1000);
        Assert.assertEquals(tekkamaki.getText(), validate);
        WebElement previous = driver.findElement(By.xpath("//a[@id='navigate-prev']"));
        previous.click();
        WebElement Shiromi=driver.findElement(By.xpath("//h1[.='Shiromi']"));
        String validateSh="Shiromi";
        Thread.sleep(500);
        Assert.assertEquals(Shiromi.getText(), validateSh);
        WebElement cart = driver.findElement(By.xpath("//span[@data-bind='text: cart.contentsCount']"));
        String validateCart ="0";
        Assert.assertEquals(cart.getText(), validateCart);
    }


    @Test
    public void demos2(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demos.telerik.com/kendo-ui/websushi#");
        WebElement edamame=driver.findElement(By.xpath("//img[@title='Edamame']"));

    }
}
