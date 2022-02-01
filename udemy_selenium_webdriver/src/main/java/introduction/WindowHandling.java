package introduction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class WindowHandling {

    public static void main(String args[]){
        System.setProperty("webdriver.chrome.driver",
                "/Users/decagon/Desktop/AutomationTesting_WorkSpace/testautomationu/webdriver_java/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/loginpagePractise/#");
        driver.findElement(By.cssSelector(".blinkingText")).click();
        //getting window handles
        Set<String> windows= driver.getWindowHandles();
        Iterator<String> windowIterator = windows.iterator();
        String parentId = windowIterator.next();
        String childId = windowIterator.next();
        // switching from parent to child window
        driver.switchTo().window(childId);
       String childWindowText =  driver.findElement(By.cssSelector(".im-para.red")).getText();
        System.out.println(childWindowText);
        String emailExtracted = childWindowText.split("at")[1].split("with")[0].trim();
        // switch back to parent window
        driver.switchTo().window(parentId);
        driver.findElement(By.cssSelector("#username")).sendKeys(emailExtracted);

    }
}
