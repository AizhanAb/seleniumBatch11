package com.test.sentrifugo.tests;

import com.test.sentrifugo.pages.LoginPageSentrifugo;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTestSentrifugo {
   // @Test
//    public static void t1(){
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver();
//        driver.get("http://demo.sentrifugo.com/index.php/");
//        driver.manage().window().maximize();
//        WebElement userName = driver.findElement(By.xpath("//input[@id='username']"));
//        userName.sendKeys("EM01");
//        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
//        password.sendKeys("sentrifugo");
//
//        WebElement logInButton = driver.findElement(By.xpath("//input[@id='loginsubmit']"));
//        logInButton.submit();
//
//    }
    @Test
    public void ValidateSuperAdmin(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.navigate().to("http://demo.sentrifugo.com/index.php/");
        driver.manage().window().maximize();
        LoginPageSentrifugo loginPage = new LoginPageSentrifugo(driver);
        //loginPage.loginMethod();
        loginPage.DynamicLogin("EM05", "sentrifugo");
        String actualUrl = driver.getCurrentUrl();
        String expURL="http://demo.sentrifugo.com/index.php/index/welcome";
        Assert.assertEquals(actualUrl, expURL);

    }
    @Test
    public void ValidateManagement(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.navigate().to("http://demo.sentrifugo.com/index.php/");
        driver.manage().window().maximize();
        LoginPageSentrifugo loginPage = new LoginPageSentrifugo(driver);
        //loginPage.loginMethod();
        loginPage.DynamicLogin("EM02", "sentrifugo");
        String actualTitle = driver.getTitle();
        String expTitle="Sentrifugo - Open Source HRMS";
        Assert.assertEquals(actualTitle, expTitle);

    }
}
