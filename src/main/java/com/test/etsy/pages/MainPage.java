package com.test.etsy.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Locale;

public class MainPage {
    public MainPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
@FindBy(id="global-enhancements-search-query")
    WebElement search;
    @FindBy(xpath="//button[@value='Search']")
    WebElement icon;
    @FindBy(xpath = "//li//h3")
    List<WebElement> alltheItems;

    public boolean allItems(){
        alltheItems.size();
        for(WebElement a:alltheItems){
            if(a.getText().trim().toLowerCase().contains("white glove")){
                System.out.println("it is working");
                return true;
            }
        }
        return false;

    }
        public void searchThing(String param){
            search.sendKeys(param);
            icon.click();
        }
}
