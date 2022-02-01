package introduction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

public class StreamTable {

    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver",
                "/Users/decagon/Desktop/AutomationTesting_WorkSpace/testautomationu/webdriver_java/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/greenkart/#/offers");
        driver.findElement(By.xpath("//tr/th[1]")).click();
        checkSortedTable(driver);

    }

    public static void checkSortedTable(WebDriver driver){
        // get the list
        List<WebElement> elementsList = driver.findElements(By.xpath("//tr/td[1]"));
        // get text of the elements  using streams
        List<String> originalList = elementsList.stream().map(s-> s.getText()).collect(Collectors.toList());
        // sort the text using streams
        List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());
        // compare the original list with the sorted list
        Assert.assertTrue(originalList.equals(sortedList));
    }


    public static void checkPrice(WebDriver driver) {
        List<WebElement> rows = driver.findElements(By.xpath("//tr/td[1]"));
        List<String> price;

        do {
           price  = rows.stream().filter(s -> s.getText().contains("Beans")).map(s -> getPriceVeggies(s)).collect(Collectors.toList());
            price.forEach(s -> System.out.println(s));
            // pagination -: to check incase the veggies is not on the first page
            if (price.size() < 1) {
                // click next
                driver.findElement(By.cssSelector("[aria-label='Next']")).click();
            }
        }while (price.size()<1);
    }

    private static String getPriceVeggies(WebElement s) {
       String priceValue = s.findElement(By.xpath("following-sibling::td[1]")).getText();
       return priceValue;

    }
}
