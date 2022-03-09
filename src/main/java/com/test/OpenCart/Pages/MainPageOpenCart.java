package com.test.OpenCart.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPageOpenCart {
    public MainPageOpenCart(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath="//h2[.='12K']")
    WebElement k12;
    @FindBy(xpath="//h2[.='11.8M']")
    WebElement m11;
    @FindBy(xpath="//h2[.='144.8K']")
    WebElement k144;
    @FindBy(xpath="//a[.=' Customers']")
    WebElement customerPage;
    @FindBy(xpath="//ul[@id='collapse33']//a")
    WebElement customerLink;
    public void goToCustomerPage(){
        customerPage.click();
        customerLink.click();
    }

    public String val12k(){
        return k12.getText();
    }
    public String valk144(){
        return k144.getText();
    }
    public String valm11(){
        return m11.getText();
    }
}
