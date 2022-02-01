package introduction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locator3 {

    public static void main(String[] args){

        System.setProperty("webdriver.chrome.driver",
                "/Users/decagon/Desktop/AutomationTesting_WorkSpace/testautomationu/webdriver_java/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        String text1 = driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).getText();
        System.out.println(text1);

        String text2 = driver.findElement(By.xpath("//header/div/button[1]/parent::div/button[2]")).getText();
        System.out.println(text2);
    }
}
