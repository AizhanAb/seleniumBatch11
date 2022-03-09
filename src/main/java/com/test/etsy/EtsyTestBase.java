package com.test.etsy;

import Utils.DriverHelper;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class EtsyTestBase {
        public WebDriver driver;
        @BeforeMethod
        public void setup(){
//            WebDriverManager.chromedriver().setup();
//            driver = new ChromeDriver();
           driver= DriverHelper.getDriver();
            driver.get("https://www.etsy.com/");
        }
        @AfterMethod
        public void tearDown(){

            System.out.println("After Method");
//             driver.quit();
            DriverHelper.tearDown();

        }
    }


