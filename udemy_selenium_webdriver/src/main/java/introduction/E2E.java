package introduction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class E2E {

    public static void main(String[] arg) throws InterruptedException {


        System.setProperty("webdriver.chrome.driver",
                "/Users/decagon/Desktop/AutomationTesting_WorkSpace/testautomationu/webdriver_java/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        //select bengaluru
        driver.findElement(By.xpath("//a[@value='BLR']")).click();
        Thread.sleep(2000);
        // select chennia
        driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();

        driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();
        System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
        if (driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5")){
            System.out.println("it's disabled ");
            Assert.assertTrue(true);
        }else{
            System.out.println("it is enabled");
            Assert.assertFalse(true);
        }
        driver.findElement(By.cssSelector("#ctl00_mainContent_chk_SeniorCitizenDiscount")).click();

        WebElement updatedDropdownBy = driver.findElement(By.id("divpaxinfo"));
        updatedDropdownBy.click();

        Thread.sleep(2000l);
        clickAddDropdown(5, driver);
        driver.findElement(By.id("btnclosepaxoption")).click();
        System.out.println(updatedDropdownBy.getText());
        Assert.assertEquals(updatedDropdownBy.getText(), "5 Adult", "incorrect number of entrance");

        driver.findElement(By.cssSelector("#ctl00_mainContent_btn_FindFlights")).click();

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
