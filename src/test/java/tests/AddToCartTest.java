package tests;

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

    @BeforeClass
    public void setUpPages() {
        homePage = new HomePage(driver);
        productPage = new ProductPage(driver);
        addToCartPage = new AddToCartPage(driver);
        categoryPage = new CategoryPage(driver);
    }

    @DataProvider(name = "Data")
    public Object[][] getOurData() throws IOException {
        return ExcelReader.getData();
    }

    @Test(dataProvider = "Data")
    public void addProductToCartTest(String name, String email) throws InterruptedException {
        // Navigate to product
        categoryPage.goToAccessories();
        categoryPage.goToShoes();
        categoryPage.selectRedSandal();
        
        // Add product to cart
        productPage.selectProductSize();
        productPage.addProductToCart();
        
        // Add explicit wait for cart page to load completely
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));



    }
}