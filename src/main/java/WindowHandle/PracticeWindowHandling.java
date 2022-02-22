package WindowHandle;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class PracticeWindowHandling {
    /*

     */
    @Test
    public static void t1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
        WebElement click= driver.findElement(By.id("newTabsBtn"));
        click.click();
        String main="Window Handles Practice";
       String basic= "Basic Controls";
        Set<String> listAll=driver.getWindowHandles();
        BrowserUtils.switchByTitle(driver, basic);
        WebElement fname= driver.findElement(By.id("firstName"));
        fname.sendKeys("Aizhan");

        WebElement lastName= driver.findElement(By.id("lastName"));
        lastName.sendKeys("Abd");
        WebElement englishchbx= driver.findElement(By.id("englishchbx"));
        englishchbx.click();
        WebElement femalerb= driver.findElement(By.id("femalerb"));
        femalerb.click();
        WebElement email= driver.findElement(By.id("email"));
        email.sendKeys("ajhd@gmail.com");
        WebElement password= driver.findElement(By.id("password"));
        password.sendKeys("password");
        WebElement registerbtn= driver.findElement(By.id("registerbtn"));
        registerbtn.click();
        WebElement message = driver.findElement(By.xpath("//label[@id='msg']"));
        String messageValidate= "Registration is Successful";
        Assert.assertEquals(message.getText(), messageValidate);
        String lastTab="AlertsDemo";
        BrowserUtils.switchByTitle(driver, lastTab);
        WebElement alertBox= driver.findElement(By.id("alertBox"));
        alertBox.click();
        Thread.sleep(3000);
        driver.quit();
    }
}
