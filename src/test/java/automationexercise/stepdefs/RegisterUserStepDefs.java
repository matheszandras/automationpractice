package automationexercise.stepdefs;

import automationexercise.hooks.Hooks;
import automationexercise.pageobjects.RegisterUserObjects;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;

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
        registerUserObjects.fillForm();
    }

    @And("^The user clicks on Create Account button$")
    public void createAccount() throws InterruptedException {
        registerUserObjects.createAccount();
        Assert.assertEquals("account not created","ACCOUNT CREATED!",registerUserObjects.accountCreated.getText());
        registerUserObjects.continueRegistration.click();
        JavascriptExecutor js = (JavascriptExecutor) Hooks.getWebDriver();
        js.executeScript("document.addEventListener('click', click);");
        registerUserObjects.closeRegisteredUserAd.click();
        Assert.assertEquals("User not logged in!",registerUserObjects.username,registerUserObjects.loggedInUsername.getText());
    }

    @Then("$")
    public void deleteAccount (){
        registerUserObjects.deleteAccount();
        Assert.assertEquals("Account was not deleted!","Your account has been permanently deleted!", registerUserObjects.deletedAccountMessage);

    }


}
