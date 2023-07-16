package Hook;

import Pages.EventsPage;
import Pages.StellenangebotePage;
import Pages.TestAutomationPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;
import java.time.Duration;
import Pages.MainPage;

public class Hook {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected MainPage mainPage;
    protected StellenangebotePage stellenangebotePage;
    protected EventsPage eventsPage;
    protected TestAutomationPage testAutomationPage;

    @Parameters("browser")
    @BeforeClass
    public void setup(String browserName) {
        if (browserName.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:/Chromedriver/chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            FirefoxOptions options = new FirefoxOptions();
            options.setBinary("C:/Program Files/Mozilla Firefox/firefox.exe");
            System.setProperty("webdriver.gecko.driver", "C:/FirefoxDriver/geckodriver.exe");
            driver = new FirefoxDriver(options);
        }
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        mainPage = new MainPage(driver);
        stellenangebotePage = new StellenangebotePage(driver);
        eventsPage = new EventsPage(driver);
        testAutomationPage = new TestAutomationPage(driver);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}