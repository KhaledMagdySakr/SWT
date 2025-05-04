package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{
   public LoginPage(WebDriver driver){
      super(driver);
   }

   private By ContinueButton =By.xpath("//button[@type=\"submit\"]");
   private By LoginName =By.id("loginFrm_loginname");
   private By Password =By.id("loginFrm_password");
   private By LoginButton =By.xpath("//button[@title=\"Login\"]");


   public void login(String username, String password) {
      WaitElements(LoginButton,2);
      type(LoginName, username);
      type(Password, password);
      click(LoginButton);
   }



}
