package introduction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class CheckBoxPractise {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",
                "/Users/decagon/Desktop/AutomationTesting_WorkSpace/testautomationu/webdriver_java/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        Thread.sleep(3000);
//        check box assertion
        driver.findElement(By.xpath("//*[@name='checkBoxOption1']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@name='checkBoxOption1']")).isSelected(),"NOT TRUE");
        driver.findElement(By.xpath("//*[@name='checkBoxOption1']")).click();
        Assert.assertFalse(driver.findElement(By.xpath("//*[@name='checkBoxOption1']")).isSelected(),"Still selected");

        // number of check boxes
        List<WebElement> numberOfCheckBox = driver.findElements(By.xpath("//*[@id='checkbox-example'] //*[@type='checkbox']"));
        System.out.println(numberOfCheckBox.size());

    }
}
