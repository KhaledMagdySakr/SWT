package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage{
    public CheckoutPage(WebDriver driver){
        super(driver);}

    private By ConfirmButton = By.id("checkout_btn");
    private By ContinueButton = By.xpath("//a[@class=\"btn btn-default mr10\"]");


    public void ClickonConfirmButton(){
        WaitElements(ConfirmButton,3);
        click(ConfirmButton);
    }

    public void ClickOnContinueButton(){
        WaitElements(ContinueButton,3);
        click(ContinueButton);
    }
}
