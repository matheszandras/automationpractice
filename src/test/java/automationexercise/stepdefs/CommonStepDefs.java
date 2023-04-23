package automationexercise.stepdefs;

import automationexercise.hooks.Hooks;
import automationexercise.pageobjects.BasePageObjects;
import automationexercise.pageobjects.RegisterUserObjects;
import io.cucumber.java.en.Given;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonStepDefs extends BasePageObjects {

    public RegisterUserObjects registerUserObjects = new RegisterUserObjects();

    @Given("^The user is on the website$")
    public void openHomepage() {
        open();
        WebDriverWait wait = new WebDriverWait(Hooks.getWebDriver(), 15);
        wait.until(ExpectedConditions.visibilityOf(registerUserObjects.carousel));
    }
}
