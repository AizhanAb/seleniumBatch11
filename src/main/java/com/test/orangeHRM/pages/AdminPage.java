package com.test.orangeHRM.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AdminPage {
    public AdminPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    @FindBy(id="btnAdd")
    WebElement AddButton;
    @FindBy(id="systemUser_userType")
    WebElement userRole;
    @FindBy(id="systemUser_employeeName_empName") WebElement employeeName;
    @FindBy(id="systemUser_userName") WebElement userName;
    @FindBy(name="systemUser[status]") WebElement status;
    @FindBy(id="systemUser_password") WebElement password;
    @FindBy(id="systemUser_confirmPassword") WebElement confirmPassword;
    @FindBy(id="btnSave") WebElement btnSave;
    @FindBy(xpath="//tr//a[contains(@href,'saveSystemUser')]")
    List<WebElement> allNames;

    public boolean validationCreation(String Username){
        for(WebElement name: allNames){
            if(name.getText().trim().equals(Username)){
                System.out.println(" it is working");
                return true;

            }
        }
        return false;
    }

    public void sendingAllInfo() throws InterruptedException {
        AddButton.click();
        BrowserUtils.selectBy(userRole, "Admin", "text");
        employeeName.sendKeys("Alice Duval");
        userName.sendKeys("Guta5");
        BrowserUtils.selectBy(status, "0", "value");
        password.sendKeys("ahmaet12345");
        confirmPassword.sendKeys("ahmaet12345");
        Thread.sleep(1000);
        btnSave.click();
    }

}
