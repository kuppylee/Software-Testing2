package introduction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.Set;

public class WindowAssignment {

    public static void main(String args[]){
        System.setProperty("webdriver.chrome.driver",
                "/Users/decagon/Desktop/AutomationTesting_WorkSpace/testautomationu/webdriver_java/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        driver.findElement(By.xpath("//a[contains(text(),'Multiple Windows')]")).click();
        driver.findElement(By.xpath("//div[@class='example'] //a[@target='_blank']")).click();

        Set<String> windowHandles = driver.getWindowHandles();
        Iterator<String> windowIterator = windowHandles.iterator();
        String parentId = windowIterator.next();
        String childId = windowIterator.next();
        // switching to child
        driver.switchTo().window(childId);
        String childText = driver.findElement(By.cssSelector("div[class='example'] h3")).getText();
        System.out.println(childText);
        // switch back to parent
        driver.switchTo().window(parentId);
        String parentText = driver.findElement(By.xpath("//h3[contains(text(),'Opening a new window')]")).getText();
        System.out.println(parentText);


    }
}
