package selectClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class SelectBasics {
    @Test
    public void practice1(){

        WebDriverManager.chromedriver();
        WebDriver driver=new ChromeDriver();
       driver.get("https://the-internet.herokuapp.com/");
        WebElement dropDown= driver.findElement(By.linkText("Dropdown"));
        dropDown.click();
        WebElement optionBox= driver.findElement(By.id("dropdown"));
        //optionBox.sendKeys("Option 1 ");
        Select option= new Select(optionBox);//provide webelement location
        option.selectByIndex(1);
        option.selectByValue("2");
        option.selectByVisibleText("Option 1");
        List<WebElement> options= option.getOptions();
        for(WebElement optn:options){
            System.out.println(optn.getText());
        }

    }
}
