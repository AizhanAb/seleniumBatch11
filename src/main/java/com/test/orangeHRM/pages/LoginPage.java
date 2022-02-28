package com.test.orangeHRM.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage(WebDriver driver){
      PageFactory.initElements(driver, this);
    }
    @FindBy(id="txtUsername")
    WebElement userName;

    @FindBy(xpath ="//input[@id='txtPassword']")
    WebElement passWord;

    @FindBy(id="btnLogin")
    WebElement logInButton;

    @FindBy(id="spanMessage")
    WebElement errorText;

    public void loginMethod(String username, String password){
        this.userName.sendKeys(username);
        this.passWord.sendKeys(password);
        this.logInButton.click();
    }


public  String getErrorMessage(){
        return BrowserUtils.getText(errorText);
}


public String getColorOfErrorMassage(){
        return errorText.getCssValue("color");
}
}
