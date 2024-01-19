package pages.apps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.base.BasePage;

import static constants.Constants.TimeOutVariables.EXPLICIT_WAIT;
public class FavoritesPage extends BasePage {
    WebDriver driver;
    public FavoritesPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }
    @FindBy(xpath = "//img[@src='https://app.3commas.io/rails/active_storage/representations/redirect/eyJfcmFpbHMiOnsibWVzc2FnZSI6IkJBaHBBbTM5IiwiZXhwIjpudWxsLCJwdXIiOiJibG9iX2lkIn19--537fc69cb2861ed60ef4477d9f9f3b4a0faa9c41/eyJfcmFpbHMiOnsibWVzc2FnZSI6IkJBaDdCam9MWm05eWJXRjBTU0lJY0c1bkJqb0dSVlE9IiwiZXhwIjpudWxsLCJwdXIiOiJ2YXJpYXRpb24ifX0=--451566e43432d5d1662eef11a653813e542d73af/Untitled%20design%20(1).png']")
    private WebElement appCard;
    @FindBy(xpath = "//div[@class='empty-placeholder']//span[text()='Nothing in here yet.']")
    private WebElement messageAboutEmpty;

    /**
     * Check if the app is added to favorites
     * */
    public FavoritesPage checkIfTheAppIsAddedToFavorite(){
        WebDriverWait wait = new WebDriverWait(driver,EXPLICIT_WAIT);
        driver.switchTo().activeElement();
        wait.until(ExpectedConditions.visibilityOf(appCard));
        return this;
    }

    /**
     * Check if the app is removed from favorites
     * */
    public FavoritesPage checkIfTheAppIsRemovedFromFavorite(){
        WebDriverWait wait = new WebDriverWait(driver,EXPLICIT_WAIT);
        driver.switchTo().activeElement();
        wait.until(ExpectedConditions.visibilityOf(messageAboutEmpty));
        return this;
    }

    /**
     * Click to app card and redirect to App page
     * */
    public FavoritesPage clickToAppCard(){
        WebDriverWait wait = new WebDriverWait(driver,EXPLICIT_WAIT);
        driver.switchTo().activeElement();
        wait.until(ExpectedConditions.visibilityOf(appCard)).click();
        return this;
    }
}
