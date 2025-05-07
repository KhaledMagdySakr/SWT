package tests;
/**
 * Automation Script: Register New User Test
 * Description: This test validates the successful registration of a new user and checks if the "My Account" page is displayed after registration.
 * Expected Result: After successful registration, the user should be redirected to the "My Account" page.
 * Author: YourName
 */

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.CreateAccPage;
import pages.MyAccPage;

public class RegistrationUserCreationTest extends BaseTest {
    // Test Case: Register new user successfully and validate My Account page is displayed

    // Arrange: Initialize all page objects
    HomePage homePage;
    CreateAccPage createAccPage;
    MyAccPage myAccPage ;

    @Test
    public void registerNewUser() {
        homePage = new HomePage(driver);
        createAccPage = new CreateAccPage(driver);
        myAccPage = new MyAccPage(driver);
        // Step 1: Open login/register menu

        homePage.openLoginOrRegister();
        // Step 2: Navigate to the account creation page directly

        homePage.navigateTo("https://automationteststore.com/index.php?rt=account/create");

        // Step 3: Wait for the registration form to be visible

       createAccPage.WaitElements(By.id("AccountFrm_firstname"), 10);
        // Step 4: Fill registration form and submit

        createAccPage.createAccount(
            "zoz", "ashraf",
            "zeoz" + System.currentTimeMillis() + "@test.com",
            "1234567890", "123456", 
            "TestCompany", "123 Street", 
            "Apt 4", "TestCity", 
            "22865", "Egypt",
            "Al Buhayrah",
            "zoz" + System.currentTimeMillis(),
            "password123", true
        );
        // Step 5: Wait for "My Account" section to appear after successful registration

        myAccPage.WaitElements(myAccPage.getMyAccountLocator(),10);
        // Step 6: Assertion - Check that "My Account" element is displayed

        Assert.assertTrue(myAccPage.isElementDisplayed(myAccPage.getMyAccountLocator()));
    }
}