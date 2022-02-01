package introduction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

import java.time.Duration;

public class Locator2 {

    public static void main(String[] args) throws InterruptedException {
//        System.setProperty("webdriver.chrome.driver",
//                "/Users/decagon/Desktop/AutomationTesting_WorkSpace/testautomationu/webdriver_java/resources/chromedriver");
//        WebDriver driver = new ChromeDriver();
        System.setProperty("webdriver.edge.driver", "/Users/decagon/Documents/msedgedriver");
        WebDriver driver = new EdgeDriver();
        String name = "Sam";
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        String password = getPassword(driver);
        System.out.println(password);
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.id("inputUsername")).sendKeys(name);
        driver.findElement(By.name("inputPassword")).sendKeys(password);
        driver.findElement(By.className("signInBtn")).click();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String successfulLoginText = driver.findElement(By.tagName("p")).getText();
        System.out.println(successfulLoginText);
        Assert.assertEquals(successfulLoginText,"You are successfully logged in.", "Incorrect confirmation text");
        String successfulLoginByName = driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText();
        System.out.println(successfulLoginByName);
        Assert.assertEquals(successfulLoginByName,"Hello "+name+",");
        driver.findElement(By.xpath("//button[text()='Log Out']")).click();
//        driver.close();
    }

    public static String getPassword(WebDriver driver) throws InterruptedException {
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.linkText("Forgot your password?")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
        String passwordText = driver.findElement(By.cssSelector("form p")).getText();
        String[] passwordArray = passwordText.split("'");
        String[] passwordArray2 = passwordArray[1].split("'");
        String password = passwordArray2[0];
        return password;


    }
}
