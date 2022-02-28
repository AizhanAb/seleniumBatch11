package com.test.OpenCart.Tests;

import com.test.OpenCart.Pages.logInPage;
import com.test.OpenCart.TestBaseOpencart;
import org.testng.annotations.Test;

public class logInPageTest extends TestBaseOpencart {
    /*
    * Techtorial Academy  5:36 PM
TASK:
Loginpage-->login to the website
1-Navigate to the website(it is already in your testbase)
2-Login to the openchartwebsite
MainPage-->do these validations
3-Validate totalorders is "12K"
4-Validate totalsales is "11.8M"
5)Validate Customers is "144.8K"
CustomerPage-->fill these boxes and validate the message and color
6)Click Customers on the side tab
7)Click Customers on the open tab from Customers
8)Click + button to add customers
9)Fill the all boxes
10)Click Save button
11)validate the message and color */
 @Test
public void work(){
    logInPage loginpageOpencart= new logInPage(driver);
    loginpageOpencart.clickButton();
}
}
