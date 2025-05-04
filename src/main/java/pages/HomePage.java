package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver){
        super(driver);

    }

    //top navigation bar
//    private By Specials = By.id("menu_specials");
//    private By Account = By.id("menu_account");

//    private By Cart = By.id("menu_cart");
//    private By Checkout = By.id("menu_checkout");
//    private By SearchKeywords = By.id("search_form");



    //Main Categories Menu

//    private By Makeup = By.xpath("//a[@href=\"https://automationteststore.com/index.php?rt=product/category&path=36\"]");
//    private By Skincare = By.xpath("//a[@href=\"https://automationteststore.com/index.php?rt=product/category&path=43\"]");
//    private By Fragrance = By.xpath("//a[@href=\"https://automationteststore.com/index.php?rt=product/category&path=49\"]");
//    private By Men = By.xpath("//a[@href=\"https://automationteststore.com/index.php?rt=product/category&path=58\"]");
//    private By HairCare = By.xpath("//a[@href=\"https://automationteststore.com/index.php?rt=product/category&path=52\"]");
//    private By Books = By.xpath("//a[@href=\"https://automationteststore.com/index.php?rt=product/category&path=65\"]");


    private By LoginorRegister = By.xpath( "//*[@id=\"customer_menu_top\"]/li/a");
    private By WelcomeBack = By.xpath("//*[@id=\"customer_menu_top\"]/li/a/div");


    public void openLoginOrRegister() {

       WaitElements(LoginorRegister, 10);
        click(LoginorRegister);
    }


    public String getLoginStatusText() {
        return getText(WelcomeBack);
    }
}



