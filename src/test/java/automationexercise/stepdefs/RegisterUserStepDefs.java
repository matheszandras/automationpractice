package automationexercise.stepdefs;

import automationexercise.pageobjects.RegisterUserObjects;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.junit.Assert;

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
        Assert.assertTrue("Registraion form is not visible", registerUserObjects.loginFormTitle.isDisplayed());
    }

    @And("^The user fills the registration form$")
    public void fillForm() {
        registerUserObjects.fillForm();
    }

    @And("^The user click on Create Account button$")
    public void createAccount() {
        registerUserObjects.createAccount();
        Assert.assertEquals("account not created","Account created",registerUserObjects.accountCreated.getText());
    }


}
