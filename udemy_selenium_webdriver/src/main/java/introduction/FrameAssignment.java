package introduction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameAssignment {

    public static void main (String args[]){
        // Dealing with nested fraames
        System.setProperty("webdriver.chrome.driver",
                "/Users/decagon/Desktop/AutomationTesting_WorkSpace/testautomationu/webdriver_java/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        driver.findElement(By.xpath("//a[contains(text(),'Nested Frames')]")).click();

        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-middle");
        String frameText = driver.findElement(By.id("content")).getText();
        System.out.println(frameText);


    }
}
