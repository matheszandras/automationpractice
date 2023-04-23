package automationexercise.pageobjects;

import automationexercise.hooks.Hooks;
import org.openqa.selenium.WebDriver;
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

}
