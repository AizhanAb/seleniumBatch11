package fileUpload;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FileUploadPractice {
    @Test
    public static void validateFileUpload(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/upload");
        driver.manage().window().maximize();
        WebElement element= driver.findElement(By.id("file-upload"));
        element.sendKeys("/Users/aizhanabdraiymova/Desktop/USA.png");
        WebElement uploadButton= driver.findElement(By.id("file-submit"));
        uploadButton.submit();
        WebElement textval = driver.findElement(By.tagName("h3"));
        String actualMessage= textval.getText();
        String expecMessage= "File Uploaded!";
        WebElement imgtval = driver.findElement(By.id("uploaded-files"));
        String actMessage2 = imgtval.getText();
        String expecMessage2 = "USA.png";
        Assert.assertEquals(actualMessage, expecMessage2);
    }

}
