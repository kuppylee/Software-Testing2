package introduction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitAssignment {
    public static void main(String arg[]){
        System.setProperty("webdriver.chrome.driver",
                "/Users/decagon/Desktop/AutomationTesting_WorkSpace/testautomationu/webdriver_java/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        WebDriverWait w = new WebDriverWait(driver,5);
        driver.get("https://www.itgeared.com/demo/1506-ajax-loading.html/");

//        driver.findElement(By.xpath("")).click();
//        w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector()));
    }
}
