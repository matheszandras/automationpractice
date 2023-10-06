package automationexercise.pageobjects;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterUserObjects extends BasePageObjects {

    public RegisterUserObjects() {
        super();
    }

    public String username = RandomStringUtils.randomAlphabetic(7);
    String email = RandomStringUtils.randomAlphanumeric(7) + "@test.com";

    @FindBy(css = "div#slider-carousel")
    public WebElement carousel;
    @FindBy(css = "a[href='/login']")
    WebElement loginButton;

    @FindBy(css = "div[class='signup-form']")
    WebElement signUpTitle;
    @FindBy(css = "input[data-qa='signup-name']")
    WebElement signUpName;
    @FindBy(css = "input[data-qa='signup-email']")
    WebElement signUpEmail;
    @FindBy(css = "button[data-qa='signup-button']")
    WebElement signUpButton;
    @FindBy(css = "div[class='login-form'] h2:first-child")
    public WebElement loginFormTitle;

    @FindBy(css = "button[data-qa='create-account']")
    WebElement loginFormCreateAccount;

    @FindBy(css = "h2[data-qa='account-created']")
    public WebElement accountCreated;

    @FindBy(css = "a[data-qa='continue-button']")
    public WebElement continueRegistration;

    @FindBy(css = "#header li:nth-child(10) b")
    public WebElement loggedInUsername;

    @FindBy(css = "a[href='/delete_account']")
    WebElement deleteAccount;

    @FindBy(css = "h2[data-qa=account-deleted]")
    public WebElement deletedAccountMessage;

    public void userClicksRegister() {
        loginButton.click();
    }

    public void fillNameAndEmail() {
        signUpName.sendKeys(username);
        signUpEmail.sendKeys(email);
    }

    public void signup() {
        signUpButton.click();
    }

    public void createAccount() {
        loginFormCreateAccount.click();
    }

    public void deleteAccount() {
        deleteAccount.click();
    }
}
