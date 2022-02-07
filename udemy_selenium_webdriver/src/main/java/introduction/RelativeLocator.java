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

        WebElement nameEditBox = driver.findElement(By.cssSelector("[name='name']"));

        String text = driver.findElement(with(By.tagName("label")).above(nameEditBox)).getText();
        System.out.println(text);
        WebElement dateOfBirth = driver.findElement(By.cssSelector("[for='dateofBirth']"));
        driver.findElement(with(By.tagName("input")).below(dateOfBirth)).click();

        WebElement iceCreamLabel = driver.findElement(By.xpath("//label[contains(text(),'Check me out if you Love IceCreams!')]"));
        driver.findElement(with(By.tagName("input")).toLeftOf(iceCreamLabel)).click();

        WebElement radioButtonRightSide = driver.findElement(By.id("inlineRadio1"));
        String studentText = driver.findElement(with(By.tagName("label")).toRightOf(radioButtonRightSide)).getText();
        System.out.println(studentText);






    }
}
// /Users/decagon/Desktop/SoftwareTesting_1/Software-Testing1/webdriver_java/resources/chromedriver