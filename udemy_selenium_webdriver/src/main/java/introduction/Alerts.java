package introduction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Alerts {

    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver",
                "/Users/decagon/Desktop/AutomationTesting_WorkSpace/testautomationu/webdriver_java/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.findElement(By.xpath("//input[@id='name']")).sendKeys("mobolaji");
        driver.findElement(By.xpath("//input[@id='alertbtn']")).click();
        String alertText = driver.switchTo().alert().getText();
        Assert.assertEquals(alertText,"Hello mobolaji, share this practice page and share your knowledge","Incorrect alert entry");
        driver.switchTo().alert().accept();
        driver.findElement(By.id("confirmbtn")).click();
        driver.switchTo().alert().dismiss();


    }
}
