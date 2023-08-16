package automationexercise.pageobjects;

import automationexercise.hooks.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class FormObjects extends BasePageObjects {

    public FormObjects() {
        super();
    }

    public void fillInputField(String selector, String value) {
        WebElement inputField = Hooks.getWebDriver().findElement(new By.ByCssSelector(selector));
        JavascriptExecutor js2 = (JavascriptExecutor) driver;
        js2.executeScript("arguments[0].scrollIntoView();", inputField);
        inputField.sendKeys(value);
    }

    public void checkBox(String selector) {
        WebElement checkBox = Hooks.getWebDriver().findElement(new By.ByCssSelector(selector));
        JavascriptExecutor js2 = (JavascriptExecutor) driver;
        js2.executeScript("arguments[0].scrollIntoView();", checkBox);
        checkBox.click();
    }

    public void selectDropdown(String selector) {
        WebElement dropdown = Hooks.getWebDriver().findElement(new By.ByCssSelector(selector));
        JavascriptExecutor js2 = (JavascriptExecutor) driver;
        js2.executeScript("arguments[0].scrollIntoView();", dropdown);
        dropdown.click();
    }
}
