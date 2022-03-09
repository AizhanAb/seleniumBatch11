package com.test.OpenCart.Tests;

import com.test.OpenCart.Pages.MainPageOpenCart;
import com.test.OpenCart.Pages.logInPage;
import com.test.OpenCart.TestBaseOpencart;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MainPageTest extends TestBaseOpencart {
    @Test
    public void validation(){
        logInPage loginpageOpencart= new logInPage(driver);
        loginpageOpencart.clickButton();
        MainPageOpenCart mainpage= new MainPageOpenCart(driver);
        Assert.assertEquals(mainpage.val12k(), "12K");
        Assert.assertEquals(mainpage.valm11(), "11.8M");
        Assert.assertEquals(mainpage.valk144(), "144.8K");
        mainpage.goToCustomerPage();

    }
}
