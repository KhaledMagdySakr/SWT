package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class BasePage {
    private WebDriver driver;
    private WebDriverWait Wait;

    public BasePage (WebDriver driver){

        this.driver=driver;
    }
    public void type(By by, String text){

        driver.findElement(by).sendKeys(text);
    }
    public void WaitElements(By by,int time){
        Wait =new WebDriverWait(driver, Duration.ofSeconds(time));
        Wait.until(ExpectedConditions.visibilityOfElementLocated(by));

    }
    public void WaitClick (By by,int time){
        Wait =new WebDriverWait(driver, Duration.ofSeconds(time));
        Wait.until(ExpectedConditions.elementToBeClickable(by));

    }
    public void WaitUrl (String url){
        Wait =new WebDriverWait(driver, Duration.ofSeconds(5));
        Wait.until(ExpectedConditions.urlToBe(url));

    }
    public void click (By by)
    {
        driver.findElement(by).click();
    }
    public void clear (By by){

        driver.findElement(by).clear();
    }
    public void selectByVisibleText(By by, String visibleText) {
        Select dropdown = new Select(driver.findElement(by));
        dropdown.selectByVisibleText(visibleText);
    }
    public void selectByValue(By by, String value) {
        Select dropdown = new Select(driver.findElement(by));
        dropdown.selectByValue(value);
    }
    public void selectByIndex(By by, int index) {
        Select dropdown = new Select(driver.findElement(by));
        dropdown.selectByIndex(index);
    }
    public String getText(By by) {
        return driver.findElement(by).getText();

    }
    public boolean isElementDisplayed(By by) {
        return driver.findElement(by).isDisplayed();

    }
    public void navigateTo(String url) {
        driver.get(url);

    }
    public void submit(By locator) {
        driver.findElement(locator).submit();

    }
    public void acceptAlert() {
        driver.switchTo().alert().accept();

    }

    public void dismissAlert() {
        driver.switchTo().alert().dismiss();

    }

    public String getAlertText() {
        return driver.switchTo().alert().getText();

    }

    public void sendTextToAlert(String text) {
        driver.switchTo().alert().sendKeys(text);

    }

    public boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
}
