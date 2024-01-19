package pages.myportfolio;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.base.BasePage;

import static testdata.TestData.MyAccountsTestData.*;
import static constants.Constants.TimeOutVariables.EXPLICIT_WAIT;

public class MyPortfolioPage extends BasePage {
    WebDriver driver;
    public MyPortfolioPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
    @FindBy(xpath = "//button[@class='sc-iAKWXU ikmowm zL9zZ']")
    private WebElement connectExchangeButton;
    @FindBy(xpath = "//div[@data-e2e='huobi']")
    private WebElement exchangeLabel;
    @FindBy(xpath = "//input[@id='account-name']")
    private WebElement nameField;
    @FindBy(xpath = "//input[@id='account-api_key']")
    private WebElement apiKeyField;
    @FindBy(xpath = "//input[@id='account-secret']")
    private WebElement apiSecretField;
    @FindBy(xpath = "//button[@class='sc-iAKWXU hFwqSh hPaHz']")
    private WebElement connectExchangeButtonInTheWidget;
    @FindBy(xpath = "//button[@class='sc-iAKWXU bkQfGk']")
    private WebElement connectedExchangeSettingsButton;
    @FindBy(xpath = "//button//span[text()='Delete']")
    private WebElement deleteButtonInTheDropdown;
    @FindBy(xpath = "//button[@class='sc-iAKWXU frbySU']")
    private WebElement deleteButtonInTheWidget;
    private final By connectedExchangeName = By.xpath("//span[@data-e2e='title']");

    /**
     * Open the widget for connecting new exchange
     */
    public MyPortfolioPage openTheWidgetToConnectExchange() {
        WebDriverWait wait = new WebDriverWait(driver, EXPLICIT_WAIT);
        driver.switchTo().activeElement();
        wait.until(ExpectedConditions.elementToBeClickable(connectExchangeButton)).click();
        return this;
    }

    /**
     * Choose exchange
     */
    public MyPortfolioPage chooseExchange() {
        WebDriverWait wait = new WebDriverWait(driver, EXPLICIT_WAIT);
        wait.until(ExpectedConditions.elementToBeClickable(exchangeLabel)).click();
        return this;
    }

    /**
     * Enter name to the name field
     */
    public MyPortfolioPage enterName() {
        nameField.sendKeys(Keys.SHIFT, Keys.HOME, Keys.DELETE);
        nameField.sendKeys(NAME);
        return this;
    }

    /**
     * Enter api key to the field
     */
    public MyPortfolioPage enterApiKey() {
        WebDriverWait wait = new WebDriverWait(driver, EXPLICIT_WAIT);
        wait.until(ExpectedConditions.elementToBeClickable(apiKeyField)).sendKeys(API_KEY);
        return this;
    }

    /**
     * Enter api secret to the field
     */
    public MyPortfolioPage enterApiSecret() {
        apiSecretField.sendKeys(API_SECRET);
        return this;
    }

    /**
     * Connect exchange to the account on 3commas
     */
    public MyPortfolioPage submitFormToConnectExchange() {
        connectExchangeButtonInTheWidget.click();
        return this;
    }

    /**
     * Check that exchange is connected to account on 3commas
     */
    public MyPortfolioPage checkIfTheExchangeIsConnected() {
        WebDriverWait wait = new WebDriverWait(driver, EXPLICIT_WAIT);
        WebElement actualTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(connectedExchangeName));
        Assert.assertEquals(actualTitle.getText(),NAME);
        return this;
    }

    /**
     * Open settings dropdown of connected exchange
     */
    public MyPortfolioPage openSettingsDropDownOfConnectedExchange() {
        WebDriverWait wait = new WebDriverWait(driver, EXPLICIT_WAIT);
        driver.switchTo().activeElement();
        wait.until(ExpectedConditions.elementToBeClickable(connectedExchangeSettingsButton)).click();
        return this;
    }

    /**
     * Click to delete button in the settings dropdown of connected exchange
     */
    public MyPortfolioPage clickToDeleteButtonInTheDropDown() {
        deleteButtonInTheDropdown.click();
        return this;
    }

    /**
     * Approve in the opened widget to delete connected exchange
     */
    public MyPortfolioPage approveDeletingConnectedExchange() {
        WebDriverWait wait = new WebDriverWait(driver, EXPLICIT_WAIT);
        wait.until(ExpectedConditions.elementToBeClickable(deleteButtonInTheWidget)).click();
        return this;
    }

    /**
     * Check that connected exchange is deleted
     */
    public MyPortfolioPage checkIfTheExchangeIsDeleted() {
        WebDriverWait wait = new WebDriverWait(driver, EXPLICIT_WAIT);
        Assert.assertTrue(wait.until(ExpectedConditions.invisibilityOfElementLocated(connectedExchangeName)));
        return this;
    }
}
