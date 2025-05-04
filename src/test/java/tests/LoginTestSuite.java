package tests;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTestSuite extends BaseTest {
    HomePage homePage;
    LoginPage loginPage;

    @Test
    public void loginWithValidCredentials() {
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        
        homePage.openLoginOrRegister();
        loginPage.login("hodaa", "hodahoda55@");
        homePage.verifyLoginSuccess();
    }

    @Test
    public void loginWithInvalidCredentials() {
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        
        homePage.openLoginOrRegister();
        loginPage.login("invalid@test.com", "wrongpass");
        loginPage.verifyLoginError();
    }
}