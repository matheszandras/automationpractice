package automationexercise.stepdefs;

import automationexercise.hooks.Hooks;
import automationexercise.pageobjects.BasePageObjects;
import automationexercise.pageobjects.FormObjects;
import automationexercise.pageobjects.RegisterUserObjects;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Map;

public class CommonStepDefs extends BasePageObjects {

    public RegisterUserObjects registerUserObjects = new RegisterUserObjects();
    public FormObjects formObjects = new FormObjects();

    @Given("^The user is on the website$")
    public void openHomepage() {
        open();
        WebDriverWait wait = new WebDriverWait(Hooks.getWebDriver(), 10);
        wait.until(ExpectedConditions.visibilityOf(registerUserObjects.carousel));
    }

    @And("^The user fills the form$")
    public void fillForm(DataTable webElements) {

        List<Map<String, String>> tableRows = webElements.asMaps(String.class, String.class);

        for (Map<String, String> columns : tableRows) {
            String selector = columns.get("selector");
            String value = columns.get("value");
            switch (columns.get("type")) {
                case "input": {
                    formObjects.fillInputField(selector, value);
                    break;
                }
                case "checkbox": {
                    formObjects.checkBox(selector);
                    break;
                }
                case "select": {
                    formObjects.selectDropdown(selector,value);
                    break;
                }
            }
        }
    }
}
