package introduction;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class JavascriptScrollAssignment {

    public static void main (String[] args){
        System.setProperty("webdriver.chrome.driver",
                "/Users/decagon/Desktop/AutomationTesting_WorkSpace/testautomationu/webdriver_java/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor)driver;
        driver.get("http://www.qaclickacademy.com/");
        driver.findElement(By.cssSelector("a[href='https://www.rahulshettyacademy.com/AutomationPractice']")).click();
        js.executeScript("window.scrollBy(0,500)");
        WebElement tableDriver = driver.findElement(By.xpath("//table[@class='table-display']"));
        List<WebElement> tableRows = tableDriver.findElements(By.tagName("tr"));
        System.out.println(tableRows.size());
        // counting of the number of columns
        System.out.println(tableDriver.findElements(By.tagName("tr")).get(0).findElements(By.tagName("th")).size());
        List<WebElement> secondRow = tableDriver.findElements(By.tagName("tr")).get(2).findElements(By.tagName("td"));
        System.out.println(secondRow.get(0).getText());
        System.out.println(secondRow.get(1).getText());
        System.out.println(secondRow.get(2).getText());

    }
}
