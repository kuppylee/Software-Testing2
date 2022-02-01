package introduction;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class AssignmentsWait {
    public static void main (String args[]) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",
                "/Users/decagon/Desktop/AutomationTesting_WorkSpace/testautomationu/webdriver_java/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver,5);
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("rahulshettyacademy");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("learning");

        WebElement user = driver.findElement(By.xpath("//input[@value='user']"));
        user.click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[@id='okayBtn']"))));
        driver.findElement(By.xpath("//button[@id='okayBtn']")).click();

        WebElement dropDown = driver.findElement(By.xpath("//select[@class='form-control']"));
        dropDown.click();
        Select consultantInDropDown = new Select(dropDown);
        consultantInDropDown.selectByVisibleText("Consultant");
        driver.findElement(By.xpath("//input[@id='terms']")).click();
        driver.findElement(By.xpath("//input[@id='signInBtn']")).click();

        // Add to cart
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Add ']")));
        addItem(driver);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='nav-item active'] //a[@class='nav-link btn btn-primary']")));
        driver.findElement(By.xpath("//li[@class='nav-item active'] //a[@class='nav-link btn btn-primary']")).click();



    }

    public static void addItem(WebDriver driver){
       List<WebElement> products = driver.findElements(By.xpath("//button[text()='Add ']"));

       for (int i = 0; i < products.size(); i++){
           products.get(i).click();
       }
    }
}
