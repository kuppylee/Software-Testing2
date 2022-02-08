package introduction;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class MultipleWindows {

    public static void main(String[] args) throws InterruptedException, IOException {
        System.setProperty("webdriver.chrome.driver",
                "/Users/decagon/Desktop/SoftwareTesting_2/Software-Testing2/udemy_selenium_webdriver/src/chromeResources/chromedriver2");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        driver.switchTo().newWindow(WindowType.TAB);
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> windowIterator =windows.iterator();
        String parentId = windowIterator.next();
        String childId = windowIterator.next();
        driver.switchTo().window(childId).get("https://rahulshettyacademy.com/");
        Thread.sleep(3000);
        List <WebElement> courses = driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']"));
        String firstCourse = "";
        for(int i = 0 ; i < courses.size(); i++){
            if (i == 1) {
                firstCourse =courses.get(i).getText();
            }
        }
        System.out.println(firstCourse);
        driver.switchTo().window(parentId);
        WebElement nameInput = driver.findElement(By.cssSelector("[name='name']"));
        nameInput.sendKeys(firstCourse);
        File fileName = nameInput.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(fileName, new File("logo.png"));
//        driver.quit();
    }

}
