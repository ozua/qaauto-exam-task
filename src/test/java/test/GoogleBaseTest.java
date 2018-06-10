package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import page.GoogleStartPage;

/**
 * BaseTest object class
 */
public class GoogleBaseTest {
    GoogleStartPage googleStartPage;
    WebDriver webDriver;

    @Parameters({"browserType", "envURL"})

    /**
     * Method used to launch determined URL and Browser listed in *.xml file at the beginning of the test
     */
    @BeforeMethod
    public void beforeTest(@Optional("firefox") String browserType,
                           @Optional("https://google.com/") String envURL) {

        switch (browserType.toLowerCase()){
            case "firefox" :
                WebDriverManager.firefoxdriver().setup();
                webDriver = new FirefoxDriver();
                break;
            case "chrome" :
                WebDriverManager.chromedriver().setup();
                webDriver = new ChromeDriver();
                break;
            default :
                WebDriverManager.iedriver().setup();
                webDriver = new InternetExplorerDriver();
        }

        webDriver.navigate().to(envURL);
        googleStartPage = new GoogleStartPage(webDriver);
    }

    /**
     * Method used to close browser after the end of the test
     */
    @AfterMethod
    public void atfer() {
        webDriver.close();
    }
}
