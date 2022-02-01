package introduction;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class SSLCertification {

    public static void main(String[] args) {
        //  Desired capabilities
//        DesiredCapabilities capabilities = DesiredCapabilities.chrome(); shows error
        ChromeOptions chrome = new ChromeOptions();
        chrome.addArguments("disable-infobars");
        chrome.setAcceptInsecureCerts(true);
        chrome.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT );

        WebDriver driver = new ChromeDriver(chrome);

    }
}