package tests;
/**
 * Automation Script: Add to Cart Test
 * Description: This test checks that a user can add a red sandal to the cart successfully.
 * Expected Result: Product appears in cart page after addition.
 * Author: YourName
 */

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.*;

import java.io.IOException;
import java.time.Duration;

public class AddToCartTest extends BaseTest {
    HomePage homePage;
    ProductPage productPage;
    AddToCartPage addToCartPage;
    CategoryPage categoryPage;
    // Setup: Initialize all page objects before running the test class

    @BeforeClass
    public void setUpPages() {
        homePage = new HomePage(driver);
        productPage = new ProductPage(driver);
        addToCartPage = new AddToCartPage(driver);
        categoryPage = new CategoryPage(driver);
    }
    // Data Provider: Read data (e.g. name, email) from Excel file

    @DataProvider(name = "Data")
    public Object[][] getOurData() throws IOException {
        return ExcelReader.getData();
    }
    // Test Case: Add a red sandal to the cart

    @Test(dataProvider = "Data")
    public void addProductToCartTest(String name, String email) throws InterruptedException {
        // Step 1: Navigate to Accessories > Shoes > Select Red Sandal
        categoryPage.goToAccessories();
        categoryPage.goToShoes();
        categoryPage.selectRedSandal();

        // Step 2: Select product size (if required)
        // Step 3: Add the selected product to the cart

        productPage.selectProductSize();
        productPage.addProductToCart();
        // Step 4: Wait for confirmation/cart page to load

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));



    }
}