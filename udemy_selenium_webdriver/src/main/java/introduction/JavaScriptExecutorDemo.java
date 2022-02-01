package introduction;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class JavaScriptExecutorDemo {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",
                "/Users/decagon/Desktop/AutomationTesting_WorkSpace/testautomationu/webdriver_java/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor)driver;
        driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
        //to scroll in the window
        js.executeScript("window.scrollBy(0,500)");
        Thread.sleep(3000);
        // to scroll in a table inside the window
        js.executeScript("document.querySelector('.tableFixHead').scrollTop = 5000");

        // sum the table
        List<WebElement> values =driver.findElements(By.xpath("//div[@class='tableFixHead'] //td[4]"));
        int sum = 0;
        for (int i = 0; i < values.size(); i++){
             int intValues = Integer.parseInt(values.get(i).getText());
            sum = sum + intValues;
        }
        System.out.println(sum);
        // compare the result
        String total = driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim();
        // to compare the total with the sum we have to change the total to an integer
        int totalInt = Integer.parseInt(total);
        if(sum == totalInt){
            System.out.println("The result is correct");
        }
        else{
            System.out.println("Incorrect result");
        }

    }
}
