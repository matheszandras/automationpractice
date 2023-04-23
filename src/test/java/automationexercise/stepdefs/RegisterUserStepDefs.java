package automationexercise.stepdefs;

import automationexercise.pageobjects.RegisterUserObjects;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class RegisterUserStepDefs {

    public RegisterUserObjects registerUserObjects = new RegisterUserObjects();

    @When("^The user clicks on the Signup/Login button$")
    public void userClicksRegister() {
        userClicksRegister();
    }

    @And("^The user fills name and email address fields$")
    public void fillNameAndEmail() {
        fillNameAndEmail();
    }

    @And("^The user clicks on Signup button$")
    public void signup() {
        signup();
        Assert.assertTrue("Registraion form is not visible", registerUserObjects.loginFormTitle.isDisplayed());
    }
    @And("^The user fills the registration form$")
    public void fillForm(){

    }

}
