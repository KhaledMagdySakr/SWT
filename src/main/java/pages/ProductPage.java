package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage {
    // Locators for the elements on the Product page

    private By SelectSize = By.id("option344747");
    private By AddToCart = By.xpath("//a[@class=\"cart\"]");
    private By ProductPrice = By.className("price");
    private By ProductName = By.xpath("//h1[@class='productname']");
    private By QuantityInput = By.id("product_quantity");

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    // Fluent interface methods
    // Method to select the product size

    public ProductPage selectProductSize() {
        WaitElements(SelectSize, 2);
        click(SelectSize);
        return this;
    }
    // Method to set the quantity of the product

    public ProductPage setQuantity(String quantity) {
        WaitElements(QuantityInput, 2);
        clear(QuantityInput);
        type(QuantityInput, quantity);
        return this;
    }
    // Method to add the product to the cart

    public AddToCartPage addProductToCart() {
        WaitClick(AddToCart, 2);
        click(AddToCart);
        return new AddToCartPage(driver);
    }

// Method to get the product name

    public String getProductName() {
        WaitElements(ProductName, 2);
        return getText(ProductName);
    }
// Method to get the product price

    public String getProductPrice() {
        WaitElements(ProductPrice, 2);
        return getText(ProductPrice);
    }


}