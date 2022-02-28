package com.test.orangeHRM.tests;

import com.test.orangeHRM.TestBase;
import com.test.orangeHRM.pages.AdminPage;
import com.test.orangeHRM.pages.LoginPage;
import com.test.orangeHRM.pages.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminTest extends TestBase {
    @Test
    public  void validateCreateEmpMessage() throws InterruptedException {
        LoginPage loginPage= new LoginPage(driver);
        loginPage.loginMethod("Admin","admin123");
        MainPage mainpage = new MainPage(driver);
        mainpage.clickAdminButton();
        AdminPage adminPage= new AdminPage(driver);
        adminPage.sendingAllInfo();
        adminPage.validationCreation("Guta5");
        Thread.sleep(2000);
        Assert.assertTrue(adminPage.validationCreation("Guta5"));
    }
}
