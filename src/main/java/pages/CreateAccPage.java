package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateAccPage extends BasePage {
    private By FirstName = By.id("AccountFrm_firstname");
    private By LastName = By.id("AccountFrm_lastname");
    private By Email = By.id("AccountFrm_email");
    private By Telephone = By.id("AccountFrm_telephone");
    private By Fax = By.id("AccountFrm_fax");
    private By Company = By.id("AccountFrm_company");
    private By Address1 = By.id("AccountFrm_address_1");
    private By Address2 = By.id("AccountFrm_address_2");
    private By City = By.id("AccountFrm_city");
    private By Region = By.id("AccountFrm_zone_id");
    private By ZipCode = By.id("AccountFrm_postcode");
    private By Country = By.id("AccountFrm_country_id");
    private By LoginName = By.id("AccountFrm_loginname");
    private By Password = By.id("AccountFrm_password");
    private By PasswordConfirm = By.id("AccountFrm_confirm");
    private By SubscribeYes = By.xpath("//input[@name='newsletter' and @value='1']");
    private By SubscribeNo = By.xpath("//input[@name='newsletter' and @value='0']");
    private By PrivacyPolicy = By.id("AccountFrm_agree");
    private By ContinueButton = By.xpath("//button[@title='Continue']");

    public CreateAccPage(WebDriver driver) {
        super(driver);
    }

    // Personal Information Methods
    public void setPersonalInfo(String firstName, String lastName, String email, String telephone) {
        WaitElements(FirstName, 10);
        type(FirstName, firstName);
        type(LastName, lastName);
        type(Email, email);
        type(Telephone, telephone);
    }

    // Additional Information Methods
    public void setAdditionalInfo(String fax, String company) {
        type(Fax, fax);
        type(Company, company);
    }

    // Address Methods
    public void setAddress(String address1, String address2, String city, String zipcode) {
        type(Address1, address1);
        type(Address2, address2);
        type(City, city);
        type(ZipCode, zipcode);
    }

    // Region and Country Methods
    public void setRegionAndCountry(String region, String country) {
        selectByVisibleText(Country, country);
        selectByVisibleText(Region, region);

    }

    // Login Information Methods
    public void setLoginInfo(String loginName, String password) {
        type(LoginName, loginName);
        type(Password, password);
        type(PasswordConfirm, password);
    }

    // Newsletter Subscription
    public void setNewsletter(boolean subscribe) {
        click(subscribe ? SubscribeYes : SubscribeNo);
    }

    // Privacy Policy and Submit
    public void acceptPrivacyAndSubmit() {
        click(PrivacyPolicy);
        click(ContinueButton);
    }

    // Main create account method using all the component methods
    public void createAccount(String firstName, String lastName, String email, String telephone,
                            String fax, String company, String address1, String address2,
                            String city,  String zipcode, String country,String region,
                            String loginName, String password, boolean subscribe) {
        
        setPersonalInfo(firstName, lastName, email, telephone);
        setAdditionalInfo(fax, company);
        setAddress(address1, address2, city, zipcode);
        setRegionAndCountry(region, country);
        setLoginInfo(loginName, password);
        setNewsletter(subscribe);
        acceptPrivacyAndSubmit();
    }

    // Verification Methods
    public boolean isRegistrationFormDisplayed() {
        return isElementDisplayed(FirstName);
    }

    public String getErrorMessage() {
        By errorMessage = By.className("alert-error");
        return getText(errorMessage);
    }

    public boolean isSuccessMessageDisplayed() {
        By successMessage = By.className("alert-success");
        return isElementDisplayed(successMessage);
    }
}