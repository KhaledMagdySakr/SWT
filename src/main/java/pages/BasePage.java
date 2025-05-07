package pages;
/**
 * BasePage class provides common  methods that can be used across all other page classes.
 * This class contains methods for interacting with web elements, handling waits, and dealing with alerts.
 * Author: omnia
 */

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class BasePage {
    public WebDriver driver;
    // declare WebDriverWait  for waiting conditions

    private WebDriverWait Wait;
    // Constructor to initialize the WebDriver

    public BasePage (WebDriver driver){

        this.driver=driver;
    }
    // Type text into a field

    public void type(By by, String text){

        driver.findElement(by).sendKeys(text);
    }
    // Wait until an element is visible

    public void WaitElements(By by,int time){
        Wait =new WebDriverWait(driver, Duration.ofSeconds(time));
        Wait.until(ExpectedConditions.visibilityOfElementLocated(by));

    }
    // Wait until an element is clickable

    public void WaitClick (By by,int time){
        Wait =new WebDriverWait(driver, Duration.ofSeconds(time));
        Wait.until(ExpectedConditions.elementToBeClickable(by));

    }
    // Wait until the URL becomes the expected one

    public void WaitUrl (String url){
        Wait =new WebDriverWait(driver, Duration.ofSeconds(5));
        Wait.until(ExpectedConditions.urlToBe(url));

    }
    // click on an element

    public void click (By by)
    {
        driver.findElement(by).click();
    }
    public void clear (By by){

        driver.findElement(by).clear();
    }
    // Select dropdown by visible text

    public void selectByVisibleText(By by, String visibleText) {
        Select dropdown = new Select(driver.findElement(by));
        dropdown.selectByVisibleText(visibleText);
    }
    // same but by value
    public void selectByValue(By by, String value) {
        Select dropdown = new Select(driver.findElement(by));
        dropdown.selectByValue(value);
    }
    // here is by index
    public void selectByIndex(By by, int index) {
        Select dropdown = new Select(driver.findElement(by));
        dropdown.selectByIndex(index);
    }
       // Get text from an element
    public String getText(By by) {
        return driver.findElement(by).getText();

    }
    // Check if an element is displayed

    public boolean isElementDisplayed(By by) {
        return driver.findElement(by).isDisplayed();

    }
    // Go to a specific URL

    public void navigateTo(String url) {
        driver.get(url);

    }
    // Submit a form

    public void submit(By locator) {
        driver.findElement(locator).submit();

    }
    // Accept a browser alert

    public void acceptAlert() {
        driver.switchTo().alert().accept();

    }
    // Dismiss a browser alert


    public void dismissAlert() {
        driver.switchTo().alert().dismiss();

    }
    // Get text from an alert popup


    public String getAlertText() {
        return driver.switchTo().alert().getText();

    }
    // Send text to an alert popup


    public void sendTextToAlert(String text) {
        driver.switchTo().alert().sendKeys(text);

    }
    // Check if an alert popup is showing


    public boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    public void verifyLoginError() {
        
    }

    public void verifyLoginSuccess() {
    }


}