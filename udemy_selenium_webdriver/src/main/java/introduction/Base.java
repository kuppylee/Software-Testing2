package introduction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Base {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",
                "/Users/decagon/Desktop/AutomationTesting_WorkSpace/testautomationu/webdriver_java/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        WebDriverWait w = new WebDriverWait(driver,5);
        // Implicit wait
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        String [] itemsNeeded = {"Cucumber","Brocolli","Beetroot"};

        driver.get("https://rahulshettyacademy.com/seleniumPractise/");
        Thread.sleep(3000);
//        Base b = new Base();
//        b.addItems(driver,itemsNeeded);
        addItems(driver,itemsNeeded);
        driver.findElement(By.cssSelector("img[alt='Cart']")).click();
        driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
        // explicit wait
        w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));
        driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
        driver.findElement(By.cssSelector("button.promoBtn")).click();
//        explicit wait
        w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));

        String couponMessage = driver.findElement(By.cssSelector("span.promoInfo")).getText();
        System.out.println(couponMessage);
        driver.findElement(By.xpath("//button[contains(text(),'Place Order')]")).click();




    }
    public static void addItems(WebDriver driver, String [] itemsNeeded){

        List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
        int j = 0;

        for(int i = 0; i<products.size();i++){

            String[] name = products.get(i).getText().split("-");
            String formattedName = name[0].trim();
            // convert the array to an arraylist
            List itemsNeededList = Arrays.asList(itemsNeeded);
            ///check whether name you extracted is present in the arraylist or not
            if (itemsNeededList.contains(formattedName)){
                j++;
//               // click on the button present there
                driver.findElements(By.xpath("//div[@class='product-action'] /button[@type='button']")).get(i).click();
                if (j == itemsNeededList.size()){
                    break;
                }
            }
        }
    }

}
