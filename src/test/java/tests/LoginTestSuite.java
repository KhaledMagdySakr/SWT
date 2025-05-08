package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTestSuite extends BaseTest {
    static HomePage homePage;
    static LoginPage loginPage;

    public LoginTestSuite(WebDriver driver) {
        this.driver = driver;
    }

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