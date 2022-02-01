package introduction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Calendar {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",
                "/Users/decagon/Desktop/AutomationTesting_WorkSpace/testautomationu/webdriver_java/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.path2usa.com/travel-companions");

        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@id='travel_date']")).click();
        //choose month of april
        while(!driver.findElement(By.cssSelector("[class='datepicker-days'] " +
                "[class='datepicker-switch']")).getText().contains("April")){
            driver.findElement(By.cssSelector("[class='datepicker-days'] [class='next']")).click();
        }

        // choose date
        List<WebElement> dates = driver.findElements(By.className("day"));
        int dateCount = dates.size();
        for (int i=0;i<dateCount;i++){
            String text = dates.get(i).getText();
            if(text.equalsIgnoreCase("27")){
                dates.get(i).click();
                break;
            }
        }


    }
}
