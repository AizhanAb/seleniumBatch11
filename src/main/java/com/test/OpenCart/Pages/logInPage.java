package com.test.OpenCart.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class logInPage {
    public logInPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    @FindBy(id="//button[@type='submit']")
    WebElement button;
    public void clickButton(){
        button.click();
    }
}
