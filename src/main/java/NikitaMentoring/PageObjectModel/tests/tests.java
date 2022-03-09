package NikitaMentoring.PageObjectModel.tests;

import NikitaMentoring.PageObjectModel.pages.HomePage;
import NikitaMentoring.PageObjectModel.pages.OptionsHeader.CollectionPage;
import NikitaMentoring.PageObjectModel.pages.OptionsHeader.VisitPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class tests {
    public void scrollToElement(WebDriver driver, WebElement element) {

        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();

    }
    @Test
    public  void test1() throws InterruptedException{
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.nga.gov/");
        HomePage homePage= new HomePage(driver);
        homePage.choseOptionMenu("collection");
        Thread.sleep(5000);
        CollectionPage collectionPage= new CollectionPage(driver);
        scrollToElement(driver, collectionPage.highlights.get(0));
        homePage.choseOptionMenu("visit");
        VisitPage visitPage = new VisitPage(driver);
        scrollToElement(driver, visitPage.promoContent.get(0));
    }


}
