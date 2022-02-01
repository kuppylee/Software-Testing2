package introduction;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class AutoSuggestiveAssignment {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",
                "/Users/decagon/Desktop/AutomationTesting_WorkSpace/testautomationu/webdriver_java/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor)driver;
        driver.get("http://www.qaclickacademy.com/");
        driver.findElement(By.cssSelector("a[href='https://www.rahulshettyacademy.com/AutomationPractice']")).click();
        selectCountry("Nigeria", driver);


    }

    static void selectCountry(String country, WebDriver driver) throws InterruptedException {
        String text = "";
            text = country.substring(0,3);
        driver.findElement(By.cssSelector("input[id='autocomplete']")).sendKeys(text);
        Thread.sleep(2000);

        List<WebElement> countriesList = driver.findElements(By.cssSelector("[class='ui-menu-item-wrapper']"));
        for (WebElement option:countriesList){
            if(option.getText().equalsIgnoreCase(country)){
                option.click();
                break;
            }
        }
    }


}
