package selectClass;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MultiSelect {
    @Test
    public void multipleSelectAndFirstSelectPractice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.navigate().to("file:///Users/aizhanabdraiymova/Desktop/projectday/Techtorial%20(2).html");
        driver.manage().window().maximize();
        WebElement header= driver.findElement(By.id("techtorial1"));
        BrowserUtils.getText(header);

        WebElement multiSelectBox= driver.findElement(By.xpath("//select[@class='select']"));
        BrowserUtils.selectBy(multiSelectBox, "Two", "text");
        BrowserUtils.selectBy(multiSelectBox, "3", "index");
        BrowserUtils.selectBy(multiSelectBox, "1", "value");

        Select select = new Select(multiSelectBox);
        Thread.sleep(2000);
        select.deselectByIndex(1);

        WebElement countryList = driver.findElement(By.name("country"));
        Select country= new Select(countryList);
        String actualFirstSlectedOption = BrowserUtils.getText(country.getFirstSelectedOption());
        String expectedFirstSelectedOption = "UNITED STATES";
        Assert.assertEquals(actualFirstSlectedOption, expectedFirstSelectedOption);


    }
}
