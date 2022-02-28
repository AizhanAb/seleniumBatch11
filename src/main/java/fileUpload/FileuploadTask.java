package fileUpload;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FileuploadTask {
    @Test
    public static void t1(){
        /*
1)Navigate to the "https://demo.guru99.com/test/upload/'
2)Upload the usa.png file on the website
3)Click the box (I accept terms of service)
4)validate box is selected
5)Click submit button
6)Validate the message "1 file has been successfully uploaded."
 */
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.guru99.com/test/upload/");
        WebElement chooseFile= driver.findElement(By.xpath("//input[@name='uploadfile_0']"));
        chooseFile.sendKeys("/Users/aizhanabdraiymova/Desktop/USA.png");
        WebElement accept= driver.findElement(By.xpath("//input[@type='checkbox']"));

        accept.click();
        Assert.assertTrue(accept.isSelected());
        WebElement button= driver.findElement(By.xpath("//button[@id='submitbutton']"));
        button.click();
        WebElement text= driver.findElement(By.tagName("h3"));
       String act=text.getText();
        System.out.println(text.getText());
       String exp="1 file\n" +
               "has been successfully uploaded.";
        Assert.assertEquals(act, exp);

    }
}
