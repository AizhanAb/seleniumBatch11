package com.test.sentrifugo.pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageSentrifugo {
    // We are going to store our element locations and methods here.
    public LoginPageSentrifugo(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//input[@id='username']")
    WebElement username;
    @FindBy(xpath = "//input[@id='password']")
    WebElement password;
    @FindBy(xpath = "//input[@id='loginsubmit']")
    WebElement loginButton;
   public  void loginMethod(){
       username.sendKeys("EM01");
       password.sendKeys("sentrifugo");
       loginButton.submit();
   }
    public  void DynamicLogin(String userName, String password){
        this.username.sendKeys(userName);
        this.password.sendKeys(password);
        loginButton.submit();
    }

}
