package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{
    // Constructor to initialize the driver from the BasePage

    public HomePage(WebDriver driver){
        super(driver);

    }
    // Locators for elements on the home page

    private By LoginorRegister = By.xpath( "//*[@id=\"customer_menu_top\"]/li/a");
    private By WelcomeBack = By.xpath("//*[@id=\"customer_menu_top\"]/li/a/div");

    // method to click on the login or register button
    public void openLoginOrRegister() {
    // wait for the login or register button to appear to click on it
       WaitElements(LoginorRegister, 10);
        click(LoginorRegister);
    }

    // welcome massage appear after registration
    public String getLoginStatusText() {
        return getText(WelcomeBack);
    }
}



