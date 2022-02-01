package introduction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class frameTest {
    public static void main(String args[]){
        System.setProperty("webdriver.chrome.driver",
                "/Users/decagon/Desktop/AutomationTesting_WorkSpace/testautomationu/webdriver_java/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://jqueryui.com/droppable/");
        int numberOfFrame = driver.findElements(By.tagName("iframe")).size();
        System.out.println(numberOfFrame);
        driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.demo-frame")));
        driver.findElement(By.id("draggable")).click();


        // to drag and drop
        Actions drag = new Actions(driver);
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));
        drag.dragAndDrop(source, target).build().perform();
        // to switch back to default
        driver.switchTo().defaultContent();

    }
}
