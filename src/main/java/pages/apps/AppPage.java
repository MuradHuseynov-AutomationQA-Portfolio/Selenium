package pages.apps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.base.BasePage;

import static constants.Constants.TimeOutVariables.EXPLICIT_WAIT;
public class AppPage extends BasePage {
    WebDriver driver;
    public AppPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }
    @FindBy(xpath = "//iframe[@sandbox='allow-forms allow-popups allow-scripts allow-same-origin ']")
    private WebElement iframeOFApp;
    @FindBy(xpath = "//main//button[@class='sc-iAKWXU hgDMkb']")
    private WebElement settingsButton;
    @FindBy(xpath = "//p[text()='Add to favorite']")
    private WebElement addToFavoriteButton;
    @FindBy(xpath = "//p[text()='Remove from favorite']")
    private WebElement removeFromFavoriteButton;
    @FindBy(xpath = "//p[text()='Delete']")
    private WebElement deleteAppButton;
    @FindBy(xpath = "//button[@class='button button_danger button_md']")
    private WebElement confirmOfDeletingAppButton;
    @FindBy(xpath = "//a[@class='sc-iAKWXU gLHXqu sc-fDMmqs aXyBS']")
    private WebElement getFreeButton;
    @FindBy(xpath = "//button[@class='sc-iAKWXU jmUdjc']")
    private WebElement confirmButtonInTheModalWindow;

    @FindBy(xpath = "//button[@class='sc-iAKWXU ikmowm']")
    private WebElement launchButtonInTheModalWindow;

    /**
     * Check that application is set
     * */
    public AppPage checkApplicatinIsSet(){
        WebDriverWait wait = new WebDriverWait(driver,EXPLICIT_WAIT);
        wait.until(ExpectedConditions.visibilityOf(iframeOFApp));
        return this;
    }

    /**
     * Click to setting button
     * */
    public AppPage clickToSettingsButton(){
        WebDriverWait wait = new WebDriverWait(driver,EXPLICIT_WAIT);
        driver.switchTo().activeElement();
        wait.until(ExpectedConditions.elementToBeClickable(settingsButton)).click();
        return this;
    }

    /**
     * Click to delete button in the drop down
     * */
    public AppPage clickToDeleteAppButtonInTheDropDown(){
        WebDriverWait wait = new WebDriverWait(driver,EXPLICIT_WAIT);
        wait.until(ExpectedConditions.elementToBeClickable(deleteAppButton)).click();
        return this;
    }

    /**
     * Click to add to favorite button in the dropdown
     * */
    public AppPage clickToAddToFavoriteButtonInTheDropDown(){
        addToFavoriteButton.click();
        return this;
    }

    /**
     * Click to remove from favorite button in the dropdown
     * */
    public AppPage clickToRemoveFromFavoriteButtonInTheDropDown(){
        removeFromFavoriteButton.click();
        return this;
    }

    /**
     * Confirm deleting app
     * */
    public AppPage confirmDeletingApp(){
        WebDriverWait wait = new WebDriverWait(driver,EXPLICIT_WAIT);
        wait.until(ExpectedConditions.elementToBeClickable(confirmOfDeletingAppButton)).click();
        return this;
    }
    /**
     * Click to confirm button in modal window
     * */
    public AppPage clickConfirmButtonInTheModalWindow() {
        WebDriverWait wait = new WebDriverWait(driver,EXPLICIT_WAIT);
        wait.until(ExpectedConditions.elementToBeClickable(confirmButtonInTheModalWindow)).click();
        return this;
    }
    /**
     * Click to launch button in the modal window
     * */
    public AppPage clicklaunchButtonInTheModalWindow(){
        WebDriverWait wait = new WebDriverWait(driver, EXPLICIT_WAIT);
        wait.until(ExpectedConditions.elementToBeClickable(launchButtonInTheModalWindow)).click();
        return this;
    }
    public AppPage clickGetFreeButton(){
        WebDriverWait wait = new WebDriverWait(driver,EXPLICIT_WAIT);
        driver.switchTo().activeElement();
        wait.until(ExpectedConditions.elementToBeClickable(getFreeButton)).click();
        return this;
    }
}
