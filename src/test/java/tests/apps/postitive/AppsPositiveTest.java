package tests.apps.postitive;

import tests.base.BaseTest;
import static testdata.TestData.URLs.APP_URL;
import static testdata.TestData.URLs.AUTH_URL;
import org.testng.annotations.*;

public class AppsPositiveTest extends BaseTest {

    @Test
    public void checkToSetApp()  {
        basePage.goToAuthUrl(AUTH_URL);
        basePage.signIn();
        basePage.goToUrl(APP_URL);
        appPage.clickGetFreeButton();
        appPage.clickConfirmButtonInTheModalWindow();
        appPage.clicklaunchButtonInTheModalWindow();
        appPage.checkApplicatinIsSet();
    }

    @Test(dependsOnMethods = "checkToSetApp")
    public void checkToAddAppToFavorite()  {
        basePage.goToAuthUrl(AUTH_URL);
        basePage.signIn();
        basePage.closeModalWindowAboutCookies();
        basePage.goToUrl(APP_URL);
        appPage.clickToSettingsButton();
        appPage.clickToAddToFavoriteButtonInTheDropDown();
        basePage.goToFavoritesPage();
        favoritesPage.checkIfTheAppIsAddedToFavorite();
    }

    @Test(dependsOnMethods = "checkToAddAppToFavorite")
    public void checkToDeleteAppFromFavorite()  {
        basePage.goToAuthUrl(AUTH_URL);
        basePage.signIn();
        basePage.closeModalWindowAboutCookies();
        basePage.goToFavoritesPage();
        favoritesPage.clickToAppCard();
        appPage.clickToSettingsButton();
        appPage.clickToRemoveFromFavoriteButtonInTheDropDown();
        basePage.goToFavoritesPage();
        favoritesPage.checkIfTheAppIsRemovedFromFavorite();
    }

    @Test(dependsOnMethods = "checkToSetApp")
    public void checkToDeleteApp()  {
        basePage.goToAuthUrl(AUTH_URL);
        basePage.signIn();
        basePage.closeModalWindowAboutCookies();
        basePage.goToMyAppsPage();
        basePage.goToUrl(APP_URL);
        appPage.clickToSettingsButton();
        appPage.clickToDeleteAppButtonInTheDropDown();
        appPage.confirmDeletingApp();
        myAppsPage.checkIfTheAppIsDeleted();
    }
}
