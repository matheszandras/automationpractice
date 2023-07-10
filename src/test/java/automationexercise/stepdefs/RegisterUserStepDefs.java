package automationexercise.stepdefs;

import automationexercise.hooks.Hooks;
import automationexercise.pageobjects.RegisterUserObjects;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterUserStepDefs {

    public RegisterUserObjects registerUserObjects = new RegisterUserObjects();

    @When("^The user clicks on the Signup/Login button$")
    public void userClicksRegister() {
        registerUserObjects.userClicksRegister();
    }

    @And("^The user fills name and email address fields$")
    public void fillNameAndEmail() {
        registerUserObjects.fillNameAndEmail();
    }

    @And("^The user clicks on Signup button$")
    public void signup() {
        registerUserObjects.signup();
        Assert.assertTrue("Registration form is not visible", registerUserObjects.loginFormTitle.isDisplayed());
    }

    @And("^The user fills the registration form$")
    public void fillForm() {
        //Map<String, String> webelements
        registerUserObjects.fillForm();
    }
//{string}{string}{string} String selector, String type, String value selector, type, value
    @And("^The user clicks on Create Account button$")
    public void createAccount() throws InterruptedException {
        registerUserObjects.createAccount();
        Assert.assertEquals("account not created", "ACCOUNT CREATED!", registerUserObjects.accountCreated.getText());
        registerUserObjects.continueRegistration.click();
        try {
            Hooks.webDriver.switchTo().frame("aswift_2");
        } catch (NoSuchFrameException e) {
            throw new RuntimeException(e);
        }
        try {
            Hooks.webDriver.switchTo().frame("ad_iframe");
        } catch (NoSuchFrameException e) {
            throw new RuntimeException(e);
        }
        WebDriverWait wait = new WebDriverWait(Hooks.getWebDriver(), 20);
        wait.until(ExpectedConditions.elementToBeClickable(registerUserObjects.closeRegisteredUserAd));
        registerUserObjects.closeRegisteredUserAd.click();
        Assert.assertEquals("User not logged in!", registerUserObjects.username, registerUserObjects.loggedInUsername.getText());
    }

    @Then("^The user clicks on the delete account button$")
    public void deleteAccount() {
        registerUserObjects.deleteAccount();
        Assert.assertEquals("Account was not deleted!", "ACCOUNT DELETED!", registerUserObjects.deletedAccountMessage.getText());
    }
}
