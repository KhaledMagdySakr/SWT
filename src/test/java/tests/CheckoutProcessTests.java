package tests;
/**
 * Automation Script: Checkout Process Test
 * Description: This test validates that a user can complete the checkout process successfully.
 * Expected Result: The user should be redirected to the confirmation page after checkout.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.*;

import java.io.IOException;
import java.time.Duration;

public class CheckoutProcessTests extends BaseTest {
    HomePage homePage;
    ProductPage productPage;
    AddToCartPage addToCartPage;
    CheckoutPage checkoutPage;
    CategoryPage categoryPage;

    @BeforeClass
    public void setUpPages() {
        homePage = new HomePage(driver);
        productPage = new ProductPage(driver);
        addToCartPage = new AddToCartPage(driver);
        checkoutPage = new CheckoutPage(driver);
        categoryPage = new CategoryPage(driver);
    }

    @DataProvider(name = "Data")
    public Object[][] getOurData() throws IOException {
        return ExcelReader.getData();
    }

    @Test(dataProvider = "Data")
    public void testCheckoutProcess(String name, String email) throws InterruptedException {

//        // Wait for cart page to load
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//        // Start of the actual test: Checkout process from the checkout button click
        
        // 1. Click on checkout button
        addToCartPage.Checkout();
        
        // 2. Wait for checkout page to load
        wait.until(ExpectedConditions.elementToBeClickable(By.id("checkout_btn")));
        
        // 3. Click on confirm button
        checkoutPage.ClickonConfirmButton();
        
        // 4. Wait for confirmation action to complete
        wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//a[@class='btn btn-default mr10']")));
        
        // 5. Click on continue button to complete the checkout
        checkoutPage.ClickOnContinueButton();
        
        // 6. Verify that checkout was successful by checking welcome message
        wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//*[@id=\"customer_menu_top\"]/li/a/div")));
        
        String loginStatus = homePage.getLoginStatusText();
        Assert.assertTrue(loginStatus.contains("Welcome"), 
            "Checkout process failed - Welcome message not displayed after checkout");
        
        // Additional assertions could be added here to verify order confirmation,
        // such as checking for order number, confirmation message, etc.
    }
}