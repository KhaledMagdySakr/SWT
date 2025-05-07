package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage{
    public CheckoutPage(WebDriver driver){
        super(driver);}
// locators for the checkout page
    private By ConfirmButton = By.id("checkout_btn");
    private By ContinueButton = By.xpath("//a[@class=\"btn btn-default mr10\"]");

    // Method to click on the confirm button

    public void ClickonConfirmButton(){
        WaitElements(ConfirmButton,3);
        click(ConfirmButton);
    }
    // Method to click on the continue button

    public void ClickOnContinueButton(){
        WaitElements(ContinueButton,3);
        click(ContinueButton);
    }
}
