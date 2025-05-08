package tests;
/**
 * BaseTest class serves as the base class for test setup and teardown in the test suite.
 * It initializes the WebDriver, sets up the necessary environment before the test suite runs,
 * and performs cleanup tasks after the tests are completed.
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

public class BaseTest {
    // Declaring the WebDriver instance that will be shared across test classes

    protected static WebDriver driver;
    // Setup method that runs before the test suite

    @BeforeSuite
    public void suiteSetUp() {
        // Initialize the ChromeDriver

        driver = new ChromeDriver();
        // Navigate to the URL of the website under test

        driver.get("https://automationteststore.com/");
        // Maximize the browser window

        driver.manage().window().maximize();
        // Set an implicit wait time for finding elements

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    // Tear down method that runs after the test suite

    @AfterSuite
    public void suiteTearDown() {
        // Quit the WebDriver session after the tests are complete

        if (driver != null) {
            driver.quit();
        }
    }
}