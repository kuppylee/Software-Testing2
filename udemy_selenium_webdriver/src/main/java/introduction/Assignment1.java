package introduction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment1 {

    public static void main(String[] args){

        System.setProperty("webdriver.chrome.driver",
                "/Users/decagon/Desktop/AutomationTesting_WorkSpace/testautomationu/webdriver_java/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://cleartrip.com/");
        Select selectAdult = new Select(driver.findElement(By.xpath("//*[@class='mb-4'] //*[@class='bc-neutral-100 bg-transparent']")));
        selectAdult.selectByValue("3");
        Select selectChildren = new Select(driver.findElement(By.xpath("//*[@class='col flex flex-middle'] ")));
        selectChildren.selectByValue("4");

    }
}
