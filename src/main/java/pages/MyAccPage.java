package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccPage extends BasePage {
    public MyAccPage(WebDriver driver){
        super(driver);

    }
    // Locator for My Account section

        private By MyAccount = By.xpath("//span[@class='maintext']");
    // Method to return the locator of the 'My Account' element

    public By getMyAccountLocator (){
            return MyAccount;
        }

}
