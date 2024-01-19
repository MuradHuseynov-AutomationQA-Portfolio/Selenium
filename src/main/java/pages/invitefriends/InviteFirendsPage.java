package pages.invitefriends;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.base.BasePage;

import static testdata.TestData.InviteFriendsTestData.CODE;
import static testdata.TestData.InviteFriendsTestData.DESCRIPTION;
import static constants.Constants.TimeOutVariables.EXPLICIT_WAIT;

public class InviteFirendsPage extends BasePage {
    WebDriver driver;
    public InviteFirendsPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }
    @FindBy(xpath = "//button[@class='sc-iAKWXU bmeOME']")
    private WebElement createNewLinkButton;

    @FindBy(xpath = "//div[@class='col-xs-12 col-lg-4']//input")
    private WebElement codeField;

    @FindBy(xpath = "//div[@class='col-xs-12 col-lg-6']//input")
    private WebElement descriptionField;

    @FindBy(xpath = "//button[@class='sc-iAKWXU btJRIb js-create-tracking-code-form']")
    private WebElement createButton;

    private final By valueInTheTable = By.xpath("//table[@class='table-info tracking-code-table table-info_has-border-bottom']//*[text()='" + CODE + "']");


    // Open form for creating new link
    public InviteFirendsPage openFormToCreateNewLink(){
        WebDriverWait wait = new WebDriverWait(driver, EXPLICIT_WAIT);
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(createNewLinkButton));
        button.click();
        return this;
    }

    /**
     * Enter code to codeField
     * */
    public InviteFirendsPage enterCode(){
        codeField.sendKeys(CODE);
        return this;
    }

    /**
     * Enter description to descriptionField
     * */
    public InviteFirendsPage enterDescription(){
        descriptionField.sendKeys(DESCRIPTION);
        return this;
    }

    /**
     * Submit form of creating new link
     * */
    public InviteFirendsPage submitFormToCreateNewLink(){
        createButton.click();
        return this;
    }

    // Check if created new link is existed
    public InviteFirendsPage checkNewLinkIsCreated(){
        WebDriverWait wait = new WebDriverWait(driver,EXPLICIT_WAIT);
        WebElement actualValue = wait.until(ExpectedConditions.visibilityOfElementLocated(valueInTheTable));
        Assert.assertEquals(actualValue.getText(),CODE);
        return this;
    }
}
