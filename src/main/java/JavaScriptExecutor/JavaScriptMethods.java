package JavaScriptExecutor;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JavaScriptMethods {
    //Whenever normal methods of testing are not working,
    // you should use JavaScript executor.

    @Test
    public void TitleMethod(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.Techtorialacademy.com/");
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());
//        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
//        String title=javascriptExecutor.executeScript("return document.title")
//                .toString();
//        System.out.println(title + " from javascript");
        String titleFromMethod = BrowserUtils.getTitleJS(driver);
        String check = "Home Page - Techtorial";
        Assert.assertEquals(titleFromMethod, check);
        System.out.println(titleFromMethod);
    }

    @Test
     public void clickWithJS(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.Techtorialacademy.com/");
        driver.manage().window().maximize();
      WebElement browseCourse = driver.findElement(By.xpath("//a[.='Browse Course']"));
//      JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
//      javascriptExecutor.executeScript("arguments[0].click()", browseCourse);

   BrowserUtils.clickWithJs(driver, browseCourse);

    }

    @Test
    public void clickPracticeJS(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.Techtorialacademy.com/");
        driver.manage().window().maximize();
        WebElement browseCourse = driver.findElement(By.xpath("//div[@class='sidenav']//div[@class='aplybtn']//a[@data-target='#exampleModal2']"));
//      JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
//      javascriptExecutor.executeScript("arguments[0].click()", browseCourse);

        BrowserUtils.clickWithJs(driver, browseCourse);

    }

    @Test
    public void ScrollIntoView(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.Techtorialacademy.com/");
        WebElement copyRight = driver.findElement(By.xpath("//p[contains(text(), 'Copyrights')]"));

        JavascriptExecutor js=(JavascriptExecutor) driver;
       // js.executeScript("arguments[0].scrollIntoView(true)", copyRight);

        //task1
        WebElement button= driver.findElement(By.xpath("//a[@href='https://www.techtorialacademy.com/programs']"));
        BrowserUtils.clickWithJs(driver, button);

        WebElement buttonGet= driver.findElement(By.xpath("//h4[.='On-Campus Course']//..//a"));
//        js.executeScript("arguments[0].scrollIntoView(true)", buttonGet);
        BrowserUtils.scrollWithJS(driver, buttonGet);
        BrowserUtils.clickWithJs(driver, buttonGet);
    }

    @Test
    public void ScrollWithXandYCoordinantTest(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.Techtorialacademy.com/");
        WebElement copyRight = driver.findElement(By.xpath("//p[contains(text(), 'Copyrights')]"));
//        JavascriptExecutor js= (JavascriptExecutor) driver;
//        Point location = copyRight.getLocation();
//        System.out.println(location.getX());
//        System.out.println(location.getY());
//        int xCord= location.getX();
//        int yCord= location.getY();
//        js.executeScript("window.scrollTo("+xCord+","+yCord+")");
        BrowserUtils.scrollWithXandY(driver, copyRight);

    }
}
