package TESTNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class TestNGPractice2 {
    @Test
    public void validationOfAscendingOrder() throws InterruptedException {
        WebDriver driver= new ChromeDriver();
        driver.navigate().to("https://demo.opencart.com/admin/");
        driver.manage().window().maximize();
        WebElement loginButton=driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();
        WebElement catalogBar=driver.findElement(By.id("menu-catalog"));
        catalogBar.click();
        WebElement options= driver.findElement(By.xpath("//a[.='Options']"));
        Thread.sleep(1000);
        options.click();
        List<WebElement> allOPtions=driver.findElements(By.xpath("//tbody/tr/td[2]"));
        Set<String> expectedOrder= new TreeSet<>();
        Set<String>  actualOrder = new LinkedHashSet<>();
        for(WebElement option: allOPtions){
            actualOrder.add(option.getText().trim());
            expectedOrder.add(option.getText().trim());
            Assert.assertEquals(actualOrder, expectedOrder);
        }


        //Assert.assertEquals(actualOrder, expectedOrder);
        //a[.='Process']
    }
    @Test
    public void validationDescending() throws InterruptedException {
        WebDriver driver= new ChromeDriver();
        driver.navigate().to("https://demo.opencart.com/admin/");
        driver.manage().window().maximize();
        WebElement loginButton=driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();
        WebElement catalogBar=driver.findElement(By.id("menu-catalog"));
        catalogBar.click();
        WebElement options= driver.findElement(By.xpath("//a[.='Options']"));
        Thread.sleep(1000);
        options.click();
        WebElement button= driver.findElement(By.xpath("//a[.='Option Name']"));
        button.click();

        List<WebElement> allOPtions=driver.findElements(By.xpath("//tbody/tr/td[2]"));
        List<String> expectedOrder= new ArrayList<>();
        List<String>  actualOrder = new LinkedList<>();
        for(int i=0; i<allOPtions.size(); i++){
            actualOrder.add(allOPtions.get(i).getText().trim());
            expectedOrder.add(allOPtions.get(i).getText().trim());
            Collections.sort(expectedOrder);
            Collections.reverse(expectedOrder);

        }
        Assert.assertEquals(actualOrder,expectedOrder);
    }

    @Test
    public void validationNumbers() throws InterruptedException {
        WebDriver driver= new ChromeDriver();
        driver.navigate().to("https://demo.opencart.com/admin/");
        driver.manage().window().maximize();
        WebElement loginButton=driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();
        WebElement catalogBar=driver.findElement(By.id("menu-catalog"));
        catalogBar.click();
        WebElement options= driver.findElement(By.xpath("//a[.='Options']"));
        Thread.sleep(1000);
        options.click();
        WebElement button= driver.findElement(By.xpath("//a[.='Sort Order']"));
        button.click();

        List<WebElement> allOPtions=driver.findElements(By.xpath("//tbody/tr/td[3]"));
        List<Integer> expectedOrder= new ArrayList<>();
        List<Integer>  actualOrder = new LinkedList<>();
        for(int i=0; i<allOPtions.size(); i++){
            actualOrder.add(Integer.parseInt(allOPtions.get(i).getText().trim()));
            expectedOrder.add(Integer.parseInt(allOPtions.get(i).getText().trim()));
            Collections.sort(expectedOrder);
            Collections.reverse(expectedOrder);

        }
        Assert.assertEquals(actualOrder,expectedOrder);
    }
}
