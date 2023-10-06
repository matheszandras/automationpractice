package automationexercise.stepdefs;

import automationexercise.hooks.Hooks;
import automationexercise.pageobjects.ContactUsObjects;
import automationexercise.pageobjects.FormObjects;
import automationexercise.pageobjects.RegisterUserObjects;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Map;

public class ContactUsStepDefs {

    public FormObjects formObjects = new FormObjects();
    public ContactUsObjects contactUsObjects = new ContactUsObjects();
    public RegisterUserObjects registerUserObjects = new RegisterUserObjects();

    @When("^The user clicks on the Contact Us button$")
    public void userClicksContactUs() {
        contactUsObjects.clickContactUs();
    }

    @And("^The user enters data to the form$")
    public void fillContactUsForm(DataTable WebElements) {
        List<Map<String, String>> tableRows = WebElements.asMaps(String.class, String.class);

        for (Map<String, String> columns : tableRows) {
            switch (columns.get("type")) {
                case "input": {
                    String selector = columns.get("selector");
                    String value = columns.get("value");
                    formObjects.fillInputField(selector, value);
                }
            }
        }
    }

    @And("^The user uploads a file$")
    public void uploadFile() {
        contactUsObjects.uploadFile();
        Assert.assertEquals("File upload wasn't successful","Success! Your details have been submitted successfully.",
                contactUsObjects.successMessage.getText());
    }

    @Then("^The user returns to the Homepage")
    public void returnToHomePage() {
        contactUsObjects.backToHomePage();
        WebDriverWait wait = new WebDriverWait(Hooks.getWebDriver(), 10);
        wait.until(ExpectedConditions.visibilityOf(registerUserObjects.carousel));
    }
}
