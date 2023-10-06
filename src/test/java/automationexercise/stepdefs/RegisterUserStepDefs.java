package automationexercise.stepdefs;

import automationexercise.pageobjects.FormObjects;
import automationexercise.pageobjects.RegisterUserObjects;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class RegisterUserStepDefs {
    public FormObjects registrationFormObjects = new FormObjects();
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
    public void fillForm(DataTable webElements) {

        List<Map<String, String>> tableRows = webElements.asMaps(String.class, String.class);

        for (Map<String, String> columns : tableRows) {
            String selector = columns.get("selector");
            String value = columns.get("value");
            switch (columns.get("type")) {
                case "input": {
                    registrationFormObjects.fillInputField(selector, value);
                }
                case "checkbox": {
                    registrationFormObjects.checkBox(selector);
                }
                case "select": {
                    registrationFormObjects.selectDropdown(selector, value);
                }
            }
        }
    }

    @And("^The user clicks on Create Account button$")
    public void createAccount() {
        registerUserObjects.createAccount();
        Assert.assertEquals("account not created", "ACCOUNT CREATED!", registerUserObjects.accountCreated.getText());
        registerUserObjects.continueRegistration.click();
        Assert.assertEquals("User not logged in!", registerUserObjects.username, registerUserObjects.loggedInUsername.getText());
    }

    @Then("^The user clicks on the delete account button$")
    public void deleteAccount() {
        registerUserObjects.deleteAccount();
        Assert.assertEquals("Account was not deleted!", "ACCOUNT DELETED!", registerUserObjects.deletedAccountMessage.getText());
    }
}
