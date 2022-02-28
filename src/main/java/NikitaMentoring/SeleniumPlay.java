package NikitaMentoring;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class SeleniumPlay {
    public static void playNotes(String[] notes, HashMap<String, WebElement> instrument) throws InterruptedException {
        for (String note: notes){
            instrument.get(note).click();
            Thread.sleep(500);
        }
    }
    @Test
    public static void piano() throws InterruptedException {
       WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.musicca.com/piano");
        driver.manage().window().maximize();
        List <WebElement> whitekeys= driver.findElements(By.xpath("//span[@class='white-key']"));
        List<WebElement> blackkeys= driver.findElements(By.xpath("//span[@class='black-key']"));
        Map<WebElement, String> whitekeysMap = new LinkedHashMap<>();
        Map<WebElement, String> blackkeysMap = new LinkedHashMap<>();
        List<WebElement> allKeys = driver.findElements(By.xpath("//span[@data-key]"));
        HashMap<String, WebElement> keyBoard = new HashMap<>();
        for(WebElement key:  allKeys){
            keyBoard.put(key.getAttribute("data-note"), key);
        }
//        for (WebElement note: keyBoard.values()) {
//
//          note.click();
//        }
        String [] notes = {"1cis", "2dis", "2d", "2e"};
        playNotes(notes, keyBoard);


        String [] surprise = {"2g","2g","2g","2d","2e","2e","2d","3b","3b","3a","3a","2g"};
        playNotes(surprise, keyBoard);
    }
}
