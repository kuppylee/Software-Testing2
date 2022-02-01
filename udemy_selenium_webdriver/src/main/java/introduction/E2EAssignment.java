package introduction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class E2EAssignment {
    static  String textChosen ;

    public static void main(String args[]) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",
                "/Users/decagon/Desktop/AutomationTesting_WorkSpace/testautomationu/webdriver_java/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//input[@id='checkBoxOption2']")).click();
        if(driver.findElement(By.xpath("//input[@id='checkBoxOption2']")).isSelected()){
            textChosen = driver.findElement(By.xpath("//input[@id='checkBoxOption2']")).getAttribute("value");
            System.out.println(textChosen);
        }
        driver.findElement(By.id("dropdown-class-example")).click();
        List<WebElement> dropDowns = driver.findElements(By.xpath("//option[contains(@value,'option')]"));
        System.out.println(dropDowns);
        for (int i = 0; i < dropDowns.size(); i++){
            String dropDownOptions = dropDowns.get(i).getText();
            System.out.println(dropDownOptions);
            if(dropDownOptions.equalsIgnoreCase(textChosen)){
                dropDowns.get(i).click();
            }
        }

        driver.findElement(By.xpath("//input[@id='name']")).sendKeys(textChosen);
        driver.findElement(By.xpath("//input[@id='alertbtn']")).click();

        String alertText = driver.switchTo().alert().getText();
        System.out.println(alertText);
        if (alertText.contains(textChosen)) {
            System.out.println("success");
        }
        else {
            System.out.println("failed");
        }
        }


    }
