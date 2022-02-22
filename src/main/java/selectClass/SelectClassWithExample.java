package selectClass;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SelectClassWithExample {
    @Test
    public void one(){
        WebDriverManager.chromedriver();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.guru99.com/test/newtours/reservation.php");
        WebElement oneWayButton = driver.findElement(By.xpath("//input[@value='oneway']"));
        oneWayButton.click();
        Assert.assertTrue(oneWayButton.isDisplayed());
        Assert.assertTrue(oneWayButton.isSelected());
        WebElement roundTripButton = driver.findElement(By.xpath("//input[@value='roundtrip']"));
        Assert.assertFalse(roundTripButton.isSelected());

    }
    @Test
    public void SelectMethods(){
        WebDriverManager.chromedriver();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.guru99.com/test/newtours/reservation.php");
        WebElement oneWayButton = driver.findElement(By.xpath("//input[@value='oneway']"));
        oneWayButton.click();
        WebElement passengerCount= driver.findElement(By.name("passCount"));
        Select passenger= new Select(passengerCount);
        passenger.selectByIndex(1);
        WebElement departFrom= driver.findElement(By.name("fromPort"));
        Select depart= new Select(departFrom);
        depart.selectByIndex(3);
        depart.selectByValue("Sydney");
        WebElement month= driver.findElement(By.name("fromMonth"));
        Select months= new Select(month);
        months.selectByVisibleText("July");
        WebElement days= driver.findElement(By.name("fromDay"));
        Select day= new Select(days);
        day.selectByVisibleText("3");
        WebElement destination= driver.findElement(By.name("toPort"));
        Select destinations= new Select(destination);
        destinations.selectByVisibleText("Acapulco");
        WebElement returnDate= driver.findElement(By.name("toMonth"));
        Select returnOptions= new Select(returnDate);
        returnOptions.selectByVisibleText("September");
        WebElement returnDay= driver.findElement(By.name("toDay"));
        Select returnOptionsDay= new Select(returnDay);
        returnOptionsDay.selectByVisibleText("9");
        WebElement classOfFlight= driver.findElement(By.xpath("//input[@value='First']"));
     classOfFlight.click();
        WebElement airline= driver.findElement(By.name("airline"));
        Select airlines= new Select(airline);
        airlines.selectByVisibleText("Pangea Airlines");

        WebElement buttonContinue = driver.findElement(By.name("findFlights"));
        buttonContinue.click();
        WebElement text = driver.findElement(By.xpath("//font[@face='Arial, Helvetica, sans-serif']//font[@size='4']"));
        String val ="After flight finder - No Seats Avaialble  ";
        System.out.println(text.getText());
//        Assert.assertEquals(val, text);
    }

    public void secondWay(){
        WebDriverManager.chromedriver();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.guru99.com/test/newtours/reservation.php");
        WebElement oneWayButton = driver.findElement(By.xpath("//input[@value='oneway']"));
        oneWayButton.click();
        WebElement passengerCount= driver.findElement(By.name("passCount"));
        BrowserUtils.selectBy(passengerCount, "2", "value");


//        Select passenger= new Select(passengerCount);
//        passenger.selectByIndex(1);
        WebElement departFrom= driver.findElement(By.name("fromPort"));
        BrowserUtils.selectBy(departFrom, "Paris", "text");
//
//        Select depart= new Select(departFrom);
//        depart.selectByIndex(3);
//        depart.selectByValue("Sydney");
        WebElement month= driver.findElement(By.name("fromMonth"));
        BrowserUtils.selectBy(month, "July", "text");
//        Select months= new Select(month);
//        months.selectByVisibleText("July");
        WebElement days= driver.findElement(By.name("fromDay"));
        BrowserUtils.selectBy(days, "3", "text");
//        Select day= new Select(days);
//        day.selectByVisibleText("3");
        WebElement destination= driver.findElement(By.name("toPort"));
        BrowserUtils.selectBy(destination, "Acapulco", "text");
//        Select destinations= new Select(destination);
//        destinations.selectByVisibleText("Acapulco");
        WebElement returnDate= driver.findElement(By.name("toMonth"));
        BrowserUtils.selectBy(returnDate, "September", "text");
//        Select returnOptions= new Select(returnDate);
//        returnOptions.selectByVisibleText("September");
        WebElement returnDay= driver.findElement(By.name("toDay"));
        Select returnOptionsDay= new Select(returnDay);
        returnOptionsDay.selectByVisibleText("9");
        WebElement classOfFlight= driver.findElement(By.xpath("//input[@value='First']"));
        classOfFlight.click();
        WebElement airline= driver.findElement(By.name("airline"));
        Select airlines= new Select(airline);
        airlines.selectByVisibleText("Pangea Airlines");

        WebElement buttonContinue = driver.findElement(By.name("findFlights"));
        buttonContinue.click();
        WebElement text = driver.findElement(By.xpath("//font[@face='Arial, Helvetica, sans-serif']//font[@size='4']"));
        String val ="After flight finder - No Seats Avaialble";
        System.out.println(text.getText());
        Assert.assertEquals(val, text);
    }








}
