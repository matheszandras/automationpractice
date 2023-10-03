package automationexercise.pageobjects;

import automationexercise.hooks.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FormObjects extends BasePageObjects {

    public FormObjects() {
        super();
    }

    public void fillInputField(String selector, String value) {
        WebElement inputField = Hooks.getWebDriver().findElement(new By.ByCssSelector(selector));
        scrollIntoview(inputField);
        inputField.sendKeys(value);
    }

    public void checkBox(String selector) {
        WebElement checkBox = Hooks.getWebDriver().findElement(new By.ByCssSelector(selector));
        scrollIntoview(checkBox);
        checkBox.click();
    }

    public void selectDropdown(String selector, String value) {
        WebElement element = Hooks.getWebDriver().findElement(By.cssSelector(selector));
        Select dropdown = new Select(element);
        scrollIntoview(element);
        dropdown.selectByValue(value);
    }
}
