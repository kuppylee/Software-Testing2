package introduction;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class ScopeE2E {
    public static void main(String args[]) throws InterruptedException {
//        Get the count of the link on the page.
        System.setProperty("webdriver.chrome.driver",
                "/Users/decagon/Desktop/AutomationTesting_WorkSpace/testautomationu/webdriver_java/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.rahulshettyacademy.com/AutomationPractice");
//        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
//        driver.findElement(By.cssSelector("a[href='https://www.rahulshettyacademy.com/AutomationPractice']")).click();

        int linkCount = driver.findElements(By.tagName("a")).size();
        System.out.println(linkCount);

//        get all the links in the footer section
        WebElement footerDriver = driver.findElement(By.id("gf-BIG"));// limiting webdriver scope
        int footerLinkCount = footerDriver.findElements(By.tagName("a")).size();
        System.out.println(footerLinkCount);

//        get all the link in the first column of the footer
        WebElement firstColumnFooterDriver = footerDriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
        int firstColumnLinkCount = firstColumnFooterDriver.findElements(By.tagName("a")).size();
        System.out.println(firstColumnLinkCount);

//        click on each link in the column and check if the pages are opening
        for (int i = 1; i < firstColumnLinkCount;i++) {
//           open all the links in different tabs
            String clickOnLinkTab = Keys.chord(Keys.COMMAND, Keys.ENTER);
            firstColumnFooterDriver.findElements(By.tagName("a")).get(i).sendKeys(clickOnLinkTab);
            Thread.sleep(5000l);

        }
        // switch to all the windows and get the window title
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> windowIterator = windows.iterator();

            while (windowIterator.hasNext()){
                driver.switchTo().window(windowIterator.next());
                String windowTitle = driver.getTitle();
                System.out.println(windowTitle);
            }

        }
    }


