package com.test.etsy.tests;

import com.test.etsy.EtsyTestBase;
import com.test.etsy.pages.MainPage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MainPageTest extends EtsyTestBase {
    @Parameters("param")
    @Test
    public void searchbox(String param){
        MainPage mainpage= new MainPage(driver);
        mainpage.searchThing(param);
    Assert.assertTrue(mainpage.allItems());

    }

}
