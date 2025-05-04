package tests;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.*;

import java.io.IOException;
import java.nio.file.AccessDeniedException;

public class E2E extends BaseTest{



        HomePage homePage;
        LoginPage loginPage;
        ProductPage productPage;
        AddToCartPage addToCartPage;
        CheckoutPage checkoutPage;
        CategoryPage categoryPage;
        ConfirmationPage confirmationPage;
        CreateAccPage createAccPage;

        @BeforeClass
        public void setUpPages() {
            homePage = new HomePage(driver);
            loginPage = new LoginPage(driver);
            productPage = new ProductPage(driver);
            addToCartPage = new AddToCartPage(driver);
            checkoutPage = new CheckoutPage(driver);
            categoryPage = new CategoryPage(driver);
            confirmationPage = new ConfirmationPage(driver);
            createAccPage = new CreateAccPage(driver);
        }


        @DataProvider (name = "Data")

        public Object[][] getOurData() throws IOException {
            return ExcelReader.getData();
        }


    @Test (dataProvider = "Data")
        public void Valid_End_TO_End_Add_To_Cart_Scenario(String name, String email) {
            homePage.openLoginOrRegister();
            loginPage.login(name, email);
            categoryPage.goToAccessories();
            categoryPage.goToShoes();
            categoryPage.selectRedSandal();
            productPage.selectSize();
            productPage.addToCart();
            addToCartPage.Checkout();
            checkoutPage.ClickonConfirmButton();
            checkoutPage.ClickOnContinueButton();

        String loginStatus = homePage.getLoginStatusText();
        Assert.assertTrue(loginStatus.contains("Welcome"), "Invalid Login Status");
        }






}
