package introduction;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumIntroduction {

    public static void main(String[] args){
        // for chrome driver
        System.setProperty("webdriver.chrome.driver",
                "/Users/decagon/Desktop/AutomationTesting_WorkSpace/testautomationu/webdriver_java/resources/chromedriver");
        WebDriver driver = new ChromeDriver();


        // for firefox driver
        System.setProperty("webdriver.gecko.driver", "/Users/decagon/Documents/geckodriver");
        WebDriver driver1 = new FirefoxDriver();

        //for microsoft edge
        System.setProperty("webdriver.edge.driver", "/Users/decagon/Documents/msedgedriver");
        WebDriver driver2 = new EdgeDriver();



        driver.get("https://www.google.com");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        driver.close();

    }
}
