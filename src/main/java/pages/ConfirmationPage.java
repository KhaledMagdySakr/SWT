package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfirmationPage extends BasePage{
    public ConfirmationPage(WebDriver driver){
        super(driver);}
    private By Continue = By.xpath("//a[@class=\"btn btn-default mr10\"]");


    public void clickContinue() {
        WaitElements(Continue,3);
        click(Continue);
    }



}
