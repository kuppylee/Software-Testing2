package introduction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class StaticDropDown {

    public static void main(String[] args){

        System.setProperty("webdriver.chrome.driver",
                "/Users/decagon/Desktop/AutomationTesting_WorkSpace/testautomationu/webdriver_java/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        // dropdown with select tag
        WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
        Select dropdown = new Select(staticDropdown);
        dropdown.selectByIndex(3);
        String selectedDropdownText = dropdown.getFirstSelectedOption().getText();
        System.out.println(selectedDropdownText);
        dropdown.selectByVisibleText("AED");
        String selectedDropdownText2 = dropdown.getFirstSelectedOption().getText();
        System.out.println(selectedDropdownText2);
        dropdown.selectByValue("INR");
        String selectedDropdownText3 = dropdown.getFirstSelectedOption().getText();
        System.out.println(selectedDropdownText3);

    }
}
