package automationexercise.pageobjects;

import automationexercise.hooks.Hooks;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BasePageObjects {

    private static final String url = "https://www.automationexercise.com/";
    WebDriver driver;

    public BasePageObjects() {
        this.driver = Hooks.getWebDriver();
        PageFactory.initElements(driver, this);
    }

    public BasePageObjects open() {
        driver.get(url);
        return this;
    }

    public BasePageObjects scrollIntoview(WebElement element) {
        JavascriptExecutor js2 = (JavascriptExecutor) driver;
        js2.executeScript("arguments[0].scrollIntoView();", element);
        return this;
    }
}
