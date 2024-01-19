package common;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.Assert;
import java.util.concurrent.TimeUnit;
import static common.Config.BROWSER;
import static constants.Constants.TimeOutVariables.IMPICIT_WAIT;
public class CommonActions {
    public static WebDriver createDriver() {
        WebDriver driver = null;
        switch (BROWSER) {
            case "CHROME":
                System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
                driver = new ChromeDriver();
                break;
//            case "MOZILA":
//                System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
//                driver = new FirefoxDriver();
//                break;
//            case "EDGE":
//                System.setProperty("webdriver.edge.driver", "src/main/resources/msedgedriver.exe");
//                driver = new EdgeDriver();
//                break;
//            case "OPERA":
//                System.setProperty("webdriver.opera.driver", "src/main/resources/operadriver.exe");
//                driver = new OperaDriver();
//                break;
            default:
                Assert.fail("INCORRECT BROWSER NAME" + BROWSER);
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(IMPICIT_WAIT, TimeUnit.SECONDS);
        return driver;
    }
}