package automationexercise.pageobjects;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterUserObjects extends BasePageObjects {

    public RegisterUserObjects() {
        super();
    }

    String username = RandomStringUtils.randomAlphabetic(7);
    String email = RandomStringUtils.randomAlphanumeric(7) + "@test.com";

    @FindBy(css = "div#slider-carousel")
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

    @FindBy(css = "div[class='login-form'] h2:first-child")
    public WebElement loginFormTitle;
    //  -visiblex

    @FindBy(css = ".grippy-host")
    WebElement closeFormAd;
    /*
    * .grippy-host
    *
    * */
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

    @FindBy(css = "select#country option[value='New Zealand']")
    WebElement loginFormSelectedCountry;

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
    public WebElement accountCreated;

    @FindBy(css = "a[data-qa='continue-button']")
    WebElement continueRegistration;

    @FindBy(css = "div[aria-label='Close ad']")
    WebElement closeAd;

    @FindBy(css = "a[href='/delete_account']")
    WebElement deleteAccount;

    @FindBy(css = "h2[data-qa=account-deleted]")
    WebElement deletedAccountMessage;

    public void userClicksRegister() {
        if (closeFormAd.isDisplayed()){
            closeFormAd.click();
            loginButton.click();
        }
        loginButton.click();
    }

    public void fillNameAndEmail() {
        if (closeFormAd.isDisplayed()){
            closeFormAd.click();
            signUpName.sendKeys(username);
            signUpEmail.sendKeys(email);
        }
        signUpName.sendKeys(username);
        signUpEmail.sendKeys(email);
    }

    public void signup() {
        if (closeFormAd.isDisplayed()){
            closeFormAd.click();
            signUpButton.click();
        }
        signUpButton.click();
    }

    public void fillForm(){
        if (closeFormAd.isDisplayed()){
            closeFormAd.click();
        }
        /*WebDriverWait wait = new WebDriverWait(Hooks.getWebDriver(),10);
        wait.until(ExpectedConditions.visibilityOf(closeFormAd));
        closeFormAd.click();*/
        loginFormUserTitle.click();
        loginFormPassword.sendKeys();
        loginFormDays.click();
        loginFormSelectedDay.click();
        loginFormMonths.click();
        loginFormSelectedMonth.click();
        loginFormYears.click();
        loginFormSelectedYear.click();
        loginFormNewsletter.click();
        loginFormOptSpecialOffers.click();
        loginFormUserFirstName.sendKeys();
        loginFormUserLastName.sendKeys();
        loginFormCompany.sendKeys();
        loginFormAddress1.sendKeys();
        loginFormAddress2.sendKeys();
        loginFormCountry.click();
        loginFormSelectedCountry.click();
        loginFormState.sendKeys();
        loginFormCity.sendKeys();
        loginFormZipCode.sendKeys();
        loginFormMobileNumber.sendKeys();
    }
    public void createAccount(){
        loginFormCreateAccount.click();
    }



}
