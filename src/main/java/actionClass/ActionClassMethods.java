package actionClass;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ActionClassMethods {
    @Test
    public void one(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.navigate().to("https://demo.guru99.com/test/simple_context_menu.html");
        driver.manage().window().maximize();
    }
    @Test
    public void doubleClickPractice(){
        //TASK FOR STUDENTS
        /*
        Scenario to Automate:
1. Launch the Chrome web browser.
2. Open a URL "https://selenium08.blogspot.com/2019/11/double-click.html".
3. Locate the element "Double-click".
4.  click on the current location (i.e. on Double-click element).
5. Close the web browser.
         */
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.navigate().to("https://selenium08.blogspot.com/2019/11/double-click.html");
        WebElement button = driver.findElement(By.xpath("//button[.='Double-Click me to see Alert message']"));
        Actions actions= new Actions(driver);
        actions.doubleClick(button).perform();
    }

@Test
    public  void dragAndDrop() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
      driver.manage().window().maximize();
      driver.navigate().to("https://demos.telerik.com/kendo-ui/dragdrop/area");
        WebElement draggable= driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement blueBox= driver.findElement(By.xpath("//div[@class='test1']"));
        WebElement orangeBox= driver.findElement(By.xpath("//div[@class='test2']"));

    String orangeText = orangeBox.getText();
    String expecOrangeText = "... Or here.";
    Assert.assertEquals(orangeText, expecOrangeText);
    Thread.sleep(2000);
    WebElement acceptCookies = driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']"));
    acceptCookies.click();
    Thread.sleep(3000);
    Actions actions = new Actions(driver);
//    actions.click().sendKeys(Keys.ARROW_DOWN).perform();
//    actions.click().sendKeys(Keys.ARROW_DOWN).perform();
    actions.dragAndDrop(draggable, orangeBox).perform();
   Thread.sleep(3000);
   orangeBox=driver.findElement(By.xpath("//div[@class='test2']"));
   String newOrangeBoxText= orangeBox.getText();
   String expectedOrangeText= "You did great!";
   Assert.assertEquals(newOrangeBoxText, expectedOrangeText);

    String actualCssValue = orangeBox.getCssValue("background-color");
    String expectedColor="rgba(238, 111, 11, 1)";
    Assert.assertEquals(actualCssValue, expectedColor);
    }

    @Test
    public void clickAndHold() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.navigate().to("https://demos.telerik.com/kendo-ui/dragdrop/area");
        driver.manage().window().maximize();
        WebElement draggable= driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement blueBox= driver.findElement(By.xpath("//div[@class='test1']"));
        String textBlueBox= BrowserUtils.getText(blueBox);
        String expectedText="Drag the small circle here ...";
        Assert.assertEquals(textBlueBox, expectedText);
        Thread.sleep(2000);
        WebElement acceptCookies = driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']"));
        acceptCookies.click();
       // System.out.println(textBlueBox);
        Thread.sleep(2000);
        Actions actions= new Actions(driver);
        actions.clickAndHold(draggable).moveToElement(blueBox).release().perform();



    }
    @Test
    public void dragDrop2(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.navigate().to("https://demoqa.com/droppable");
        driver.manage().window().maximize();
        WebElement draggable= driver.findElement(By.id("draggable"));
        WebElement droppable= driver.findElement(By.xpath("//div[@class='simple-drop-container']//div[@id='droppable']"));
        Actions actions= new Actions(driver);
        actions.dragAndDrop(draggable,droppable).perform();

    }
    @Test
    public void clickAndHold2() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.navigate().to("https://demoqa.com/droppable");
        driver.manage().window().maximize();
        WebElement link= driver.findElement(By.id("droppableExample-tab-accept"));
        link.click();

        WebElement notAcceptable= driver.findElement(By.id("notAcceptable"));
        WebElement droppable= driver.findElement(By.xpath("//div[@class='accept-drop-container']//div[@id='droppable']"));
        WebElement acceptable= driver.findElement(By.id("acceptable"));
        Actions actions=new Actions(driver);
        actions.clickAndHold(notAcceptable).moveToElement(droppable).release().perform();
        Thread.sleep(1000);
        String whiteColor=droppable.getCssValue("background-color");
        String expecColor="rgba(0, 0, 0, 0)";
        Assert.assertEquals(whiteColor, expecColor);
        Thread.sleep(1000);
        String droppableBefore = droppable.getText();
        actions.clickAndHold(acceptable).moveToElement(droppable).release().perform();
        Thread.sleep(1000);
        String blueColor=droppable.getCssValue("background-color");
        System.out.println(droppable.getCssValue("background-color"));
        String expecColorBlue="rgba(70, 130, 180, 1)";
        Assert.assertEquals(blueColor, expecColorBlue);
        String droppableAfter = droppable.getText();
        Assert.assertEquals( droppableAfter, "Dropped!" );

    }

    @Test
    public void act(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.navigate().to("https://google.com/");
        driver.manage().window().maximize();
        Actions actions = new Actions(driver);
        WebElement search = driver.findElement(By.name("q"));
        actions.moveToElement(search).click().keyDown(Keys.SHIFT)
                .sendKeys("s").keyUp(Keys.SHIFT).sendKeys("elenium").doubleClick()
                .keyDown(Keys.COMMAND).sendKeys("c").keyUp(Keys.COMMAND)
                .sendKeys(Keys.ARROW_RIGHT).keyDown(Keys.COMMAND).sendKeys("v")
                .keyUp(Keys.COMMAND).sendKeys(Keys.ENTER).perform();
    }

    @Test
    public void ActionPracctice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://text-compare.com/");
        WebElement textarea= driver.findElement(By.id("inputText1"));
        WebElement textarea2= driver.findElement(By.id("inputText2"));
        Actions actions= new Actions(driver);
        actions.click(textarea).keyDown(Keys.SHIFT).sendKeys("G")
                .keyUp(Keys.SHIFT).sendKeys("ood bye Keys").keyDown(Keys.COMMAND)
                .sendKeys("a").sendKeys("c").keyUp(Keys.COMMAND).perform();
        Thread.sleep(1000);
        actions.click(textarea2).keyDown(Keys.COMMAND).sendKeys("v").perform();
        WebElement button = driver.findElement(By.className("compareButton"));
        button.click();
    }
}
