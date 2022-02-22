package seleniumBasics.SeleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practice1 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/horizontal_slider");
        driver.manage().window().maximize();
        WebElement Link= driver.findElement(By.xpath("//h3"));
        System.out.println(Link.getText());
        WebElement parag= driver.findElement(By.xpath("//h4"));
        System.out.println(parag.getText());
        WebElement aTag= driver.findElement(By.xpath("//a[@href='http://elementalselenium.com/']"));
        //aTag.click();
        WebElement containText= driver.findElement(By.xpath("//h3[contains(text(), 'Horizontal')]"));
        System.out.println(containText.getText());
        WebElement dotText = driver.findElement(By.xpath("//h3[.='Horizontal Slider']"));
        System.out.println(dotText.getText());
    }
}
