package pages.apps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.base.BasePage;

import static constants.Constants.TimeOutVariables.EXPLICIT_WAIT;
public class MyAppsPage extends BasePage {
    WebDriver driver;
    public MyAppsPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }
    private final By appCard = By.xpath("//img[@src='https://app.3commas.io/rails/active_storage/representations/redirect/eyJfcmFpbHMiOnsibWVzc2FnZSI6IkJBaHBBbTM5IiwiZXhwIjpudWxsLCJwdXIiOiJibG9iX2lkIn19--537fc69cb2861ed60ef4477d9f9f3b4a0faa9c41/eyJfcmFpbHMiOnsibWVzc2FnZSI6IkJBaDdCam9MWm05eWJXRjBTU0lJY0c1bkJqb0dSVlE9IiwiZXhwIjpudWxsLCJwdXIiOiJ2YXJpYXRpb24ifX0=--451566e43432d5d1662eef11a653813e542d73af/Untitled%20design%20(1).png']");

    /**
     * Check the application has been deleted
     * */
    public MyAppsPage checkIfTheAppIsDeleted(){
        WebDriverWait wait = new WebDriverWait(driver,EXPLICIT_WAIT);
        Assert.assertTrue(wait.until(ExpectedConditions.invisibilityOfElementLocated(appCard)));
        return this;
    }
}
