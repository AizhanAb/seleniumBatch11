package NikitaMentoring.PageObjectModel.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public class HomePage {
    public HomePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//ul[@class='menu']/li")
    public List<WebElement> menuOptions;

    public void choseOptionMenu(String option){
        String OptionUpd = option.toLowerCase().trim();
        HashMap<String, WebElement> opts=new HashMap<>();
        for(WebElement opt:menuOptions){
            opts.put(opt.getText().toLowerCase(), opt);
        }
        if(opts.containsKey(OptionUpd)){
            opts.get(OptionUpd).click();
        }else{
            System.out.println("No such option");
        }

    }
}
