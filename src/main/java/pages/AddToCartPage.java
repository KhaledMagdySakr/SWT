package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddToCartPage extends BasePage {
    public AddToCartPage(WebDriver driver) {
        super(driver);
    }
    // Locator for the checkout button

    private By CheckoutButton = By.id("cart_checkout1");

    // Method to click on the checkout button

    public void Checkout() {
        WaitElements(CheckoutButton, 3);
        click(CheckoutButton);
    }

}