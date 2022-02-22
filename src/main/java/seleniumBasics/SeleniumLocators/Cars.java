package seleniumBasics.SeleniumLocators;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Cars {
    @Test
    public void carSearch(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.get("https://www.cars.com/");
        WebElement used = driver.findElement(By.xpath("//select[@name='stock_type']"));
        BrowserUtils.selectBy(used, "New cars", "text");

        WebElement price = driver.findElement(By.xpath("//select[@name='list_price_max']"));
        BrowserUtils.selectBy(price, "$100,000", "text");

        WebElement make = driver.findElement(By.xpath("//select[@name='makes[]']"));
        BrowserUtils.selectBy(make, "land_rover", "value");
        WebElement dinstance = driver.findElement(By.xpath("//select[@name='maximum_distance']"));
        BrowserUtils.selectBy(dinstance, "All miles from", "text");
        WebElement button = driver.findElement(By.xpath("//button[@class='sds-button']"));
        button.click();
        WebElement header= driver.findElement(By.tagName("h1"));
        String expectedHeader = "New Land Rover for sale";
        Assert.assertEquals(header.getText(), expectedHeader);
        List<WebElement> landRovers= driver.findElements(By.xpath("//h2[@class='title']"));
        for(WebElement landRover: landRovers){
            System.out.println(landRover.getText());
            Assert.assertTrue(landRover.getText().contains("Land Rover"));
        }



//pkill Chrome
    }
}
