package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CategoryPage extends BasePage{
    public CategoryPage(WebDriver driver){
        super(driver);
    }
    //Apparel & accessories important locators
    private By WedgeHeel = By.xpath("//*[@id=\"maincontainer\"]/div/div/div/div/div[2]/div[1]/div[1]/div/a");
    private By ApparelAccessories = By.xpath("//a[@href=\"https://automationteststore.com/index.php?rt=product/category&path=68\"]");
    private By ShoesCategory= By.xpath("//*[@id=\"categorymenu\"]/nav/ul/li[2]/a");

    // Click to open "Apparel & Accessories" category

    public void goToAccessories() {
        WaitElements(ApparelAccessories,3);
        click(ApparelAccessories);
    }
    // Click to open "Shoes" category

    public void goToShoes() {
        WaitElements(ShoesCategory,3);
        click(ShoesCategory);
    }
    // Select the red wedge heel product from the list

    public void selectRedSandal() {
        WaitElements(WedgeHeel,3);
        click(WedgeHeel);
    }

}
