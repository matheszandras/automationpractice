package automationexercise.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks {

    public static WebDriver webDriver;


    @Before
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        webDriver.quit();
    }

    public static WebDriver getWebDriver() {
        return webDriver;
    }
}
