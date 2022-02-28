package com.test.orangeHRM.pages;

import Utils.BrowserUtils;
import com.test.orangeHRM.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class PimPage {
    public PimPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    @FindBy(id="btnAdd")
    WebElement addBTN;
    @FindBy(id="firstName")
    WebElement firstName;
    @FindBy(id="lastName")
    WebElement lastName;
    @FindBy(id="employeeId")
    WebElement employeeId;
    @FindBy(id="photofile")
    WebElement photofile;
    @FindBy(id="btnSave")
    WebElement btnSave;
    @FindBy(id="personal_txtEmpFirstName")
    WebElement personalName;
    @FindBy(id="personal_txtEmpLastName")
    WebElement personallastName;
    @FindBy(id="personal_txtEmployeeId")
    WebElement personalID;
    @FindBy(xpath="//input[@id='btnSave' and @value='Edit']")
    WebElement editButton;
    //
    @FindBy(id="personal_optGender_2")
    WebElement femaleRButton;
    @FindBy(id="personal_cmbNation")
    WebElement nationality;
    @FindBy(id="personal_DOB")
    WebElement dob;
    @FindBy(xpath="//input[@id='btnSave' and @value='Save']")
    WebElement saveButton;


    public String validNationality(){
     Select select = new Select(nationality);

      return  select.getFirstSelectedOption().getText().trim();


    }
    public  void addNationality(String nation){
        femaleRButton.click();
      BrowserUtils.selectBy(nationality,nation,"text");
      dob.clear();
    dob.sendKeys("1990-09-21");
    saveButton.click();

    }


    public void clickEditButton(){
        editButton.click();
    }

//    public boolean validationName(String Name ){
//        if(this.personalName.getAttribute("value").equals(Name)){
//            System.out.println("Fname is correct");
//            return true;
//        }
//        return false;
//    }
    public boolean validationID(String ID){
        return personalID.getAttribute("value").endsWith(ID);
    }
    public String validationlastName(){
        return personallastName.getAttribute("value");
    }
    public String validationName(){
        return personalName.getAttribute("value");
    }






    public void sendAllInfo(String Name, String lName,String  ID, String photo ){
        firstName.sendKeys(Name);
        this.lastName.sendKeys(lName);
        employeeId.sendKeys(ID);
        photofile.sendKeys(photo);
        btnSave.click();
    }

    public void clickAddBTN(){
        addBTN.click();
    }

}
