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

//public boolean isProductInCart() throws InterruptedException {
//    // Look for indicators that a product is in the cart
//    // This could be a product item in the cart, quantity field, subtotal, etc.
//
//    // Common elements that indicate items in cart
//    By cartItemsCheck = By.xpath("//div[contains(@class, 'cart-item') or contains(@class, 'product-item')]");
//    By cartQuantityCheck = By.xpath("//input[contains(@name, 'quantity')]");
//    By cartSubtotalCheck = By.xpath("//div[contains(@class, 'subtotal') or contains(text(), 'Sub-Total')]");
//    By cartProductNameCheck = By.xpath("//table[@class='table table-striped table-bordered']//td[contains(@class, 'name')]");
//
//    // Wait for the cart page to load properly
//    // Replace the Java's Object wait() with Thread.sleep() or proper WebDriver wait
//    Thread.sleep(2000); // Wait for 2 seconds
//
//    // Check if any of these elements are present
//    // If any one of them is found, we can assume a product is in the cart
//    try {
//        return isElementDisplayed(cartItemsCheck) ||
//               isElementDisplayed(cartQuantityCheck) ||
//               isElementDisplayed(cartSubtotalCheck) ||
//               isElementDisplayed(cartProductNameCheck);
//    } catch (Exception e) {
//        // If there's an exception, it likely means no product is in the cart
//        return false;
//    }
}
