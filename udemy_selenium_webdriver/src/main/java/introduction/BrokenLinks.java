package introduction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import javax.print.DocFlavor;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class BrokenLinks {

    public static void main(String[] args) throws IOException {
        System.setProperty("webdriver.chrome.driver",
                "/Users/decagon/Desktop/AutomationTesting_WorkSpace/testautomationu/webdriver_java/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        // get all the links
        // use java methods to call the urls and gets you the status code
        // if the status code is > 400 then that url is not working

        List<WebElement> links = driver.findElements(By.cssSelector("li[class='gf-li'] a"));
        SoftAssert a = new SoftAssert();
        for (WebElement link:links){

            String url = link.getAttribute("href");
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestMethod("HEAD");
            connection.connect();
            int responseCode = connection.getResponseCode();
            System.out.println(responseCode);
            a.assertTrue(responseCode<400,"The link with text: "+ link.getText() + "is broken with error code" + responseCode);
        }
        a.assertAll();
    }
}
