package com.test.orangeHRM.tests;

import actionClass.Action;
import com.test.orangeHRM.TestBase;
import com.test.orangeHRM.pages.LoginPage;
import com.test.orangeHRM.pages.MainPage;
import com.test.orangeHRM.pages.PimPage;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PimPageTest extends TestBase {
    LoginPage loginPage;
    PimPage pimPage;
    MainPage mainpage;
    @BeforeMethod
    public void initPages(){
        loginPage = new LoginPage(driver);
        mainpage = new MainPage(driver);
         pimPage= new PimPage(driver);
    }
    @Test
    public  void validatePimPage() throws InterruptedException {
        loginPage.loginMethod("Admin", "admin123");
        mainpage.clickPimPage();
        pimPage.clickAddBTN();
        Thread.sleep(2000);
        pimPage.sendAllInfo("ASASA4", "dadada4", "453","/Users/aizhanabdraiymova/Desktop/USA.png");
        Assert.assertEquals(pimPage.validationName(), "ASASA4");
        Assert.assertEquals(pimPage.validationlastName(), "dadada4");
        Assert.assertTrue(pimPage.validationID("453") );

    }
    @Test
    public void personalDetailsVal() throws InterruptedException {
        loginPage.loginMethod("Admin", "admin123");
        mainpage.clickPimPage();
        pimPage.clickAddBTN();
        Thread.sleep(2000);
        pimPage.sendAllInfo("ASASA11", "dadada5", "453","/Users/aizhanabdraiymova/Desktop/USA.png");
        pimPage.clickEditButton();
        pimPage.addNationality("Kyrgyz");
        Assert.assertEquals(pimPage.validNationality(), "Kyrgyz");
    }
}
