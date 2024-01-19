package tests.base;
import common.CommonActions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.apps.AppPage;
import pages.apps.FavoritesPage;
import pages.apps.MyAppsPage;
import pages.base.BasePage;
import pages.invitefriends.InviteFirendsPage;
import pages.myportfolio.MyPortfolioPage;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Path;
import java.nio.file.Files;

import static common.Config.*;

public class BaseTest {
    protected WebDriver driver;
    protected BasePage basePage;
    protected InviteFirendsPage inviteFirendsPage;
    protected MyPortfolioPage myPortfolioPage;
    protected AppPage appPage;
    protected MyAppsPage myAppsPage;
    protected FavoritesPage favoritesPage;
    @BeforeMethod
    public void setUp() {
        driver = CommonActions.createDriver();
        basePage = new BasePage(driver);
        inviteFirendsPage = new InviteFirendsPage(driver);
        myPortfolioPage = new MyPortfolioPage(driver);
        appPage = new AppPage(driver);
        myAppsPage = new MyAppsPage(driver);
        favoritesPage = new FavoritesPage(driver);
    }
    @AfterMethod
    void clearCoockiesAndLocalStorageAndCloseBrowser() {
        if (CLEAR_COOKIES) {
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
            driver.manage().deleteAllCookies();
            javascriptExecutor.executeScript("window.sessionStorage.clear()");
        }
    }
    @AfterMethod
    public void closeTheBrowser() {
        if (CLOSE_BROWSER) {
            driver.quit();
        }
    }

//        /**
//     *  Delete old screenshots
//     * */
//    static {
//        if (CLEAR_REPORTS_DIR) {
//            Path path = Path.of("build/reports/tests/negativeResults");
//            try {
//                DirectoryStream<Path> files = Files.newDirectoryStream(path);
//                for (Path file : files) {
//                    Files.delete(file);
//                }
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//            Path path2 = Path.of("build/reports/tests/positiveResults");
//            try {
//                DirectoryStream<Path> files = Files.newDirectoryStream(path2);
//                for (Path file : files) {
//                    Files.delete(file);
//                }
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        }
//    }
}

