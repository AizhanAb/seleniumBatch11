package Utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.Set;

public class BrowserUtils {
    public static void selectBy(WebElement element, String value, String methodName) {
        Select select = new Select(element);
        switch (methodName) {
            case "text":
                select.selectByVisibleText(value);
                break;
            case "index":
                select.selectByIndex(Integer.parseInt(value));
                break;
            case "value":
                select.selectByValue(value);
                break;
            default:
                System.out.println("Method name is not available, Use text, value");

        }
    }

    public static String getText(WebElement element) {

        return element.getText().trim();
    }


    public static  String getTitleJS(WebDriver driver) {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        String title = javascriptExecutor.executeScript("return document.title")
                .toString();
return title;

    }
    public  static void clickWithJs(WebDriver driver, WebElement element){
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].click()", element);
    }
    public  static void scrollWithJS(WebDriver driver, WebElement element){
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true)", element);
    }
    public static void scrollWithXandY(WebDriver driver, WebElement element){
        JavascriptExecutor js= (JavascriptExecutor) driver;
        Point location = element.getLocation();

        int xCord= location.getX();
        int yCord= location.getY();
        js.executeScript("window.scrollTo("+xCord+","+yCord+")");
    }
public static void switchOnlyforTwoTabs(WebDriver driver, String mainPageId){

    Set<String> allPagesId= driver.getWindowHandles();
    for(String id: allPagesId){
        if(!id.equals(mainPageId)){
            driver.switchTo().window(id);
        }
    }
}


    public static void switchByTitle(WebDriver driver, String title){
        Set <String> lists=driver.getWindowHandles();
        for(String page:lists){
            driver.switchTo().window(page);
            if(driver.getTitle().contains(title)){
                break;
            }
        }
    }
}

