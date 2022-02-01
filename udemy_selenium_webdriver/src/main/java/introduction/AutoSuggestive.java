package introduction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class AutoSuggestive {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver",
                "/Users/decagon/Desktop/AutomationTesting_WorkSpace/testautomationu/webdriver_java/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        Thread.sleep(2000);
        driver.findElement(By.id("autosuggest")).sendKeys("ind");
//        List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
//
//        for (WebElement option : options) {
//            if (option.getText().equalsIgnoreCase("india")) {
//                option.click();
//                break;
//            }

            selectCountryFromAutoSuggestion("india", driver);
    }
    public static void selectCountryFromAutoSuggestion(String country, WebDriver driver) throws InterruptedException {

        Thread.sleep(2000);
        List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));

        for (WebElement option:options){
            if(option.getText().equalsIgnoreCase(country)){
                option.click();
                break;
            }
        }
    }
}
