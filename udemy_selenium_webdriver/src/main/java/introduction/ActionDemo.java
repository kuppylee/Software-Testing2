package introduction;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class ActionDemo {
    public static void main(String args[]){
        System.setProperty("webdriver.chrome.driver",
                "/Users/decagon/Desktop/AutomationTesting_WorkSpace/testautomationu/webdriver_java/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com/");
        Actions a = new Actions(driver);
        WebElement element1 = driver.findElement(By.xpath("//a[@id='nav-link-accountList']"));
        WebElement element2 = driver.findElement(By.cssSelector("*[id='twotabsearchtextbox']"));
        // moves to specific element and right click
        a.moveToElement(element1).contextClick().build().perform();
        // enter a word in capital letter and double click
        a.moveToElement(element2).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();

        // Drag and drop 

    }

}
