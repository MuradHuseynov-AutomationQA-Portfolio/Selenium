package pages.base;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

import static testdata.TestData.SignInTestData.SESSION_ID_KEY;
import static testdata.TestData.SignInTestData.SESSION_ID_VALUE;
import static constants.Constants.TimeOutVariables.EXPLICIT_WAIT;

public class BasePage {
    WebDriver driver;
    JavascriptExecutor javascriptExecutor;
    public BasePage(WebDriver driver) {
        this.driver = driver;
        javascriptExecutor = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@data-name='invite_friends']")
    public WebElement inviteFriendsPageLink;
    @FindBy(xpath = "//a[@data-name='my_portfolio']")
    public WebElement myAccountsPageLink;
    @FindBy(xpath = "//button[@class='ch2-btn ch2-allow-all-btn ch2-btn-primary']")
    private WebElement allowAllCookiesButton;
    @FindBy(xpath = "//li[@data-name='apps_store']")
    private WebElement appsLinksDropdown;
    @FindBy(xpath = "//a[@data-name='store']")
    private WebElement storePageLink;
    @FindBy(xpath = "//a[@data-name='my_apps']")
    private WebElement myAppsPageLink;
    @FindBy(xpath = "//a[@data-name='favorites']")
    private WebElement favoritesPageLink;
    private By iframe = By.xpath("//iframe[@id='wiz-iframe']");

    @FindBy(xpath = "//div[@class='ct-banner-button-container']//button")
    private WebElement buttonInIframe;

    /**
     * Close iframe if it is visible
      */
    public void closeIframesIfTheyAreVisible(WebDriverWait wait){
        try {
            wait.until(ExpectedConditions.elementToBeClickable(iframe));
            List<WebElement> listOfIframes = driver.findElements(iframe);
            for (WebElement iframe : listOfIframes) {
                driver.switchTo().frame(iframe);
                buttonInIframe.click();
            }
        } catch (Exception e) {
            System.out.println("Iframes have't been displayed");
        }
    }

    /**
     * This method for redirect to InviteFriends page
     */
    public void goToInviteFriendsPage() {
        WebDriverWait wait = new WebDriverWait(driver, EXPLICIT_WAIT);
        wait.until(ExpectedConditions.elementToBeClickable(inviteFriendsPageLink)).click();
        closeIframesIfTheyAreVisible(wait);
        closeModalWindowAboutCookies();
        driver.navigate().refresh();
        javascriptExecutor.executeScript("window.scrollTo(0, 0);");
    }

    /**
     * This method for redirect to MyAppsPage page
     */
    public void goToMyAppsPage() {
        WebDriverWait wait = new WebDriverWait(driver, EXPLICIT_WAIT);
        wait.until(ExpectedConditions.elementToBeClickable(appsLinksDropdown)).click();
        wait.until(ExpectedConditions.elementToBeClickable(myAppsPageLink)).click();
        closeIframesIfTheyAreVisible(wait);
        closeModalWindowAboutCookies();
        driver.navigate().refresh();
        javascriptExecutor.executeScript("window.scrollTo(0, 0);");
    }

    /**
     * This method for redirect to MyAccount page
     */
    public void goToMyAccountsPage() {
        WebDriverWait wait = new WebDriverWait(driver, EXPLICIT_WAIT);
        wait.until(ExpectedConditions.elementToBeClickable(myAccountsPageLink)).click();
        closeIframesIfTheyAreVisible(wait);
        closeModalWindowAboutCookies();
        driver.navigate().refresh();
        javascriptExecutor.executeScript("window.scrollTo(0, 0);");
    }

    /**
     * This method for redirect to Favorites page
     */
    public void goToFavoritesPage() {
        WebDriverWait wait = new WebDriverWait(driver, EXPLICIT_WAIT);
        wait.until(ExpectedConditions.elementToBeClickable(appsLinksDropdown)).click();
        wait.until(ExpectedConditions.elementToBeClickable(favoritesPageLink)).click();
        closeIframesIfTheyAreVisible(wait);
        closeModalWindowAboutCookies();
        driver.navigate().refresh();
        javascriptExecutor.executeScript("window.scrollTo(0, 0);");
    }

    /**
     * The method for navigating to a specific URL
     */
    public void goToUrl(String url) {
        driver.get(url);
        WebDriverWait wait = new WebDriverWait(driver, EXPLICIT_WAIT);
        closeIframesIfTheyAreVisible(wait);
        closeModalWindowAboutCookies();
        driver.navigate().refresh();
        javascriptExecutor.executeScript("window.scrollTo(0, 0);");
    }

    /**
     * The method for navigating to a auth URL
     */
    public void goToAuthUrl(String url) {
        driver.get(url);
    }


    /**
     * The method for authorization to a specific site
     */
    public void signIn() {
        Cookie authCookie = new Cookie(SESSION_ID_KEY, SESSION_ID_VALUE);
        driver.manage().addCookie(authCookie);
        driver.navigate().refresh();
    }

    /**
     * The method for closing modal window about cookies
     */
    public void closeModalWindowAboutCookies() {
        WebDriverWait wait = new WebDriverWait(driver, EXPLICIT_WAIT);
        try {
            wait.until(ExpectedConditions.elementToBeClickable(allowAllCookiesButton)).click();
        }catch (Exception e){
            System.out.println("Modal window about cookies have't been displayed");
        }
    }
}

