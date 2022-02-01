package introduction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class UpdatedDropdown {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver",
                "/Users/decagon/Desktop/AutomationTesting_WorkSpace/testautomationu/webdriver_java/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        Assert.assertFalse(driver.findElement(By.cssSelector("*[name*='friendsandfamily']")).isSelected());
        driver.findElement(By.cssSelector("*[name*='friendsandfamily']")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("*[name*='friendsandfamily']")).isSelected());


//         How to validate a disabled UI component . you get the attribute by style
//        System.out.println(driver.findElement(By.name("ctl00$mainContent$view_date2")).isEnabled());
        System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
        driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
        System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
        if (driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5")){
            System.out.println("it's enabled ");
            Assert.assertTrue(true);
        }else{
            System.out.println("it is disabled");
            Assert.assertFalse(false);
        }




        List<WebElement> numberOfCheckBox = driver.findElements(By.cssSelector("*[type='checkbox']"));
        System.out.println(numberOfCheckBox.size());
        WebElement updatedDropdownBy = driver.findElement(By.id("divpaxinfo"));
        updatedDropdownBy.click();
        Thread.sleep(2000l);
        clickAddDropdown(3, driver);
        driver.findElement(By.id("btnclosepaxoption")).click();
        System.out.println(updatedDropdownBy.getText());
        Assert.assertEquals(updatedDropdownBy.getText(), "3 Adult", "incorrect number of entrance");




    }

    public static void  clickAddDropdown(int numberOfTimes, WebDriver driver){
        int count = 1;
        while(count < numberOfTimes){
            WebElement clickDropdown = driver.findElement(By.id("hrefIncAdt"));
            clickDropdown.click();
            count ++;
        }
    }
}
