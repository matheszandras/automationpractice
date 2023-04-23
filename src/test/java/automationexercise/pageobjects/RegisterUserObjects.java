package automationexercise.pageobjects;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterUserObjects extends BasePageObjects {

    public RegisterUserObjects() {
        super();
    }

    String username = RandomStringUtils.randomAlphabetic(7);
    String password = RandomStringUtils.randomAlphanumeric(7);

    @FindBy(css = "slider-carousel")
    public WebElement carousel;
    //   slider-carousel - visible

    @FindBy(css = "a[href='/login']")
    WebElement loginButton;

    @FindBy(css = "div[class='signup-form']")
    WebElement signUpTitle;
    //div[class='signup-form'] - contains New User Signup!

    @FindBy(css = "input[data-qa='signup-name']")
    WebElement signUpName;

    @FindBy(css = "input[data-qa='signup-email']")
    WebElement signUpEmail;

    @FindBy(css = "button[data-qa='signup-button']")
    WebElement signUpButton;

    @FindBy(css = "div[class='login-form']h2:first-child")
    public WebElement loginFormTitle;
    //  -visiblex
    @FindBy(css = "input[value='Mr']")
    WebElement loginFormUserTitle;

    @FindBy(css = "input#password")
    WebElement loginFormPassword;

    @FindBy(css = "select#days")
    WebElement loginFormDays;

    @FindBy(css = "select#days option[value='11']")
    WebElement loginFormSelectedDay;

    @FindBy(css = "select#months")
    WebElement loginFormMonths;

    @FindBy(css = "select#months option[value='8']")
    WebElement loginFormSelectedMonth;

    @FindBy(css = "select#years")
    WebElement loginFormYears;

    @FindBy(css = "select#years option[value='1988']")
    WebElement loginFormSelectedYear;

    @FindBy(css = "input#newsletter")
    WebElement loginFormNewsletter;

    @FindBy(css = "input#optin")
    WebElement loginFormOptSpecialOffers;

    @FindBy(css = "input#first_name")
    WebElement loginFormUserFirstName;

    @FindBy(css = "input#last_name")
    WebElement loginFormUserLastName;

    @FindBy(css = "input#company")
    WebElement loginFormCompany;

    @FindBy(css = "input#address1")
    WebElement loginFormAddress1;

    @FindBy(css = "input#address2")
    WebElement loginFormAddress2;

    @FindBy(css = "select#country")
    WebElement loginFormCountry;

    @FindBy(css = "input#state")
    WebElement loginFormState;

    @FindBy(css = "input#city")
    WebElement loginFormCity;

    @FindBy(css = "input#zipcode")
    WebElement loginFormZipCode;

    @FindBy(css = "input#mobile_number")
    WebElement loginFormMobileNumber;

    @FindBy(css = "button[data-qa='create-account']")
    WebElement loginFormCreateAccount;

    @FindBy(css = "h2[data-qa='account-created']")
    WebElement accountCreated;

    @FindBy(css = "a[data-qa='continue-button']")
    WebElement continueRegistration;

    @FindBy(css = "div[aria-label='Close ad']")
    WebElement closeAd;

    @FindBy(css = "a[href='/delete_account']")
    WebElement deleteAccount;

    @FindBy(css = "h2[data-qa=account-deleted]")
    WebElement deletedAccountMessage;

    public void userClicksRegister() {
        loginButton.click();
    }

    public void fillNameAndEmail() {
        signUpName.sendKeys(username);
        signUpEmail.sendKeys(password);
    }

    public void signup() {
        signUpButton.click();
    }


}
