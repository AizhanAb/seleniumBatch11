package seleniumBasics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumBasics {
    public static void main(String[] args) {
        //STEP1:We need to define the chrome driver into the project as a
        //property.
        System.setProperty("webdriver.chrome.driver","chromedriver");
        //Windows:
        //System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        //STEP2: We need to instantiate(declare) our driver.
        WebDriver driver = new ChromeDriver();
        //NOTE:driver is a reference name.WebDriver-->Interface
        //new ChromeDriver() -->new Object.
        //INTERVIEW QUESTION:
        //Where do you use polymorphism in your testing framework?
        //I use it to instantiate my driver.example
        // WebDriver driver = new ChromeDriver();
        //ChromeDriver driver = new ChromeDriver;
        //
        //second interview question:
        //can you instantiateyour driver like
        //Webdriver driver1=new WebDriver();
        //first method
        //get()- method navigates to the given URL
        //getTitle()--> method gets the title of the page.

        driver.get("https://www.techtorialacademy.com/");
        String title= driver.getTitle();
        System.out.println(title);
        if(title.equals("Home Page - Techtorial")){
            System.out.println("your test passed");
        }else{
            System.out.println("your test failed");
        }
        String actual = driver.getCurrentUrl();
        String expected = "https://www.techtorialacademy.com/";
if(actual.equals(expected)){
    System.out.println("yaay");
}else {
    System.out.println("booo");
}
    }
}
