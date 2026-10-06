// Declares that this class belongs to the 'tests' package.
package tests;
// Imports the WebDriver interface for browser automation.
import org.openqa.selenium.WebDriver;
// Imports the ChromeDriver class to launch and control the Chrome browser.
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
// Imports the @AfterClass annotation from TestNG.
import org.testng.annotations.AfterClass;
// Imports the @BeforeClass annotation from TestNG.
import org.testng.annotations.BeforeClass;
// Imports the @Test annotation from TestNG.
import org.testng.annotations.Test;
// Declares a public class named FirstTest.
public class FirstTest {
    // Declares a WebDriver reference variable.
    WebDriver driver;

    // Runs once before all test methods in this class.
    @BeforeClass
    // Defines the setup method and allows InterruptedException.
    public void setup() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        // IntelliJ runs inside a Flatpak sandbox, where Chrome exits immediately
        // unless its own sandbox is turned off.
        options.addArguments("--no-sandbox", "--disable-dev-shm-usage");
        // Creates a new Chrome browser instance.
        driver = new ChromeDriver(options);
        // Pauses execution for 3 seconds.
        Thread.sleep(3000);
        // Maximizes the browser window.
        driver.manage().window().maximize();
        // Pauses execution for another 3 seconds.
        Thread.sleep(3000);
    }

    // Marks this method as a TestNG test case.
    @Test
    // Defines the test method and allows InterruptedException.
    public void testcase() throws InterruptedException {
        // Opens the specified website in the browser.
        driver.get("https://mvnrepository.com/");
        // Waits for 3 seconds.
        Thread.sleep(3000);
        // Prints the title of the current web page to the console.
        System.out.println("The title of the page is: " + driver.getTitle());
        // Minimizes the browser window.
        driver.manage().window().minimize();
        // Waits for 3 seconds.
        Thread.sleep(3000);
        // Maximizes the browser window again.
        driver.manage().window().maximize();
        // Waits for another 3 seconds.
        Thread.sleep(3000);
    }

    // Runs once after all test methods in this class.
    @AfterClass
    // Defines the cleanup method.
    public void teardown() {
        // Closes all browser windows and ends the WebDriver session.
        driver.quit();
    }
}