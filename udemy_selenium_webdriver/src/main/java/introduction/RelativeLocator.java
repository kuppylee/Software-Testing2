package introduction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class RelativeLocator {

    public static void main(String[] args){
        // for chrome driver
        System.setProperty("webdriver.chrome.driver",
                "/Users/decagon/Desktop/SoftwareTesting_2/Software-Testing2/udemy_selenium_webdriver/src/chromeResources/chromedriver2");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/angularpractice/");

        WebElement nameEditBox = driver.findElement(By.cssSelector(".form-control.ng-pristine.ng-invalid.ng-touched"));

//        String text = driver.findElement(By.tagName("label")).above(nameEditBox)).getText();
//        System.out.println(text);


    }
}
// /Users/decagon/Desktop/SoftwareTesting_1/Software-Testing1/webdriver_java/resources/chromedriver