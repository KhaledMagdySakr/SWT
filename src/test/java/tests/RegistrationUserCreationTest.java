package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.CreateAccPage;

public class RegistrationUserCreationTest extends BaseTest {
    HomePage homePage;
    CreateAccPage createAccPage;

    @Test
    public void registerNewUser() {
        homePage = new HomePage(driver);
        createAccPage = new CreateAccPage(driver);
        
        homePage.openLoginOrRegister();
        homePage.navigateTo("https://automationteststore.com/index.php?rt=account/create");
        

       createAccPage.WaitElements(By.id("AccountFrm_firstname"), 10);
        
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
    }
}