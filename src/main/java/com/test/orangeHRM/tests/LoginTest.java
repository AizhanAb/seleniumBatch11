package com.test.orangeHRM.tests;

import com.test.orangeHRM.TestBase;
import com.test.orangeHRM.pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {


@Test
    public void validateLoginPositive(){

    LoginPage loginPage=new LoginPage(driver);
    loginPage.loginMethod("Admin", "admin123");

    String actualUrl = driver.getCurrentUrl();

    String expUrl="https://opensource-demo.orangehrmlive.com/index.php/dashboard";
    Assert.assertEquals(actualUrl, expUrl);
}




    @Test
    public void validateLoginNegative(){

        LoginPage loginPage=new LoginPage(driver);
        loginPage.loginMethod("Admin", "Aizhan");
        String actErrorTest = loginPage.getErrorMessage();
        String experrorText= "Invalid credentials";
        Assert.assertEquals(actErrorTest, experrorText);
        String colorText = loginPage.getColorOfErrorMassage();
        String expColorText = "rgba(221, 119, 0, 1)";
        Assert.assertEquals(colorText, expColorText);

}


}
