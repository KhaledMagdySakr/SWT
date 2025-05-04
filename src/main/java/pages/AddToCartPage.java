package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddToCartPage extends BasePage{
    public AddToCartPage(WebDriver driver){
        super(driver);
    }

    private By CheckoutButton = By.id("cart_checkout1");


    public void Checkout(){
        WaitElements(CheckoutButton,3);
        click(CheckoutButton);
    }
}
