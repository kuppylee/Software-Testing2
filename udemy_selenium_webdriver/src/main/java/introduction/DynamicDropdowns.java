package introduction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicDropdowns {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver",
                "/Users/decagon/Desktop/AutomationTesting_WorkSpace/testautomationu/webdriver_java/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        //select bengaluru
        driver.findElement(By.xpath("//a[@value='BLR']")).click();
        Thread.sleep(2000);
        // select chennai
//        driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();
        // another way to handle it without using indexes
//        //div[@id="glsctl00_mainContent_ddl_destinationStation1_CTNR"] //a[@value="MAA"]
        driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();

        driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();



    }
}
