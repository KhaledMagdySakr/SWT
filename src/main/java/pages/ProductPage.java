package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage{
    public ProductPage(WebDriver driver){
        super(driver);
    }

    //Apparel & accessories -> WedgeHeel
    private By SelectSize = By.id("option344747");
    private By AddToCart =By.xpath("//a[@class=\"cart\"]");

    public void selectSize() {
        WaitElements( SelectSize,2);
       click(SelectSize);
    }


    public void addToCart() {
        click(AddToCart);
    }


}
