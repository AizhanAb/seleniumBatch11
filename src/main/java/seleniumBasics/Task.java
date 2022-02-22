package seleniumBasics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task {

        public static void main(String[] args) {
            System.setProperty("wedriver.chrome.driver", "chromedriver");
            WebDriver driver = new ChromeDriver();
            driver.get("https://www.google.com/");
            System.out.println(driver.getTitle());
            //System.out.println(driver.getPageSource());
            System.out.println(driver.getCurrentUrl());
            driver.navigate().to("https://www.godaddy.com/");
            driver.manage().window().maximize();
            System.out.println(driver.getTitle());
           if(driver.getTitle().equals("Domain Names, Websites, Hosting & Online Marketing Tools - GoDaddy")){
               System.out.println(driver.getCurrentUrl());
               if(driver.getCurrentUrl().equals("https://www.godaddy.com/")){
                   System.out.println("everythins is working perfectly");
               }
           }
            driver.quit();



//            driver.navigate().back();
//            driver.navigate().back();
//            driver.navigate().forward();

        }


}
