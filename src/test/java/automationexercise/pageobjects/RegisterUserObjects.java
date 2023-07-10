package automationexercise.pageobjects;

import automationexercise.hooks.Hooks;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class RegisterUserObjects extends BasePageObjects {

    public RegisterUserObjects() {
        super();
    }

    public String username = RandomStringUtils.randomAlphabetic(7);
    String email = RandomStringUtils.randomAlphanumeric(7) + "@test.com";
    String password = RandomStringUtils.randomAlphanumeric(7);
    String firstname = "Test";
    String lastname = "User";
    String company = "Lockheed Martin Corp.";
    String address1 = "6801 Rockledge Drive";
    String address2 = "---";
    String state = "Maryland";
    String city = "Bethesda";
    String zipcode = "20817 ";
    String mobileNumber = RandomStringUtils.randomNumeric(13);

    Wait<WebDriver> fluentWait = new FluentWait<>(Hooks.getWebDriver())
            .withTimeout(Duration.ofSeconds(30L))
            .pollingEvery(Duration.ofSeconds(5L))
            .ignoring(NoSuchElementException.class);

    public void closeFormAd() {
        fluentWait.until(ExpectedConditions.visibilityOf(closeAd));
        WebElement closeButton = fluentWait.until(driver -> driver.findElement(By.id("aswift_2_host")));
        closeButton.click();
    }

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

    @FindBy(css = ".grippy-host")
    public WebElement closeFormAd;

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
    public WebElement continueRegistration;

    @FindBy(css = "#header li:nth-child(10) b")
    public WebElement loggedInUsername;

    @FindBy(id = "aswift_2_host")
    WebElement closeAd;

    @FindBy(className = "down")
    WebElement closeAdDown;

    @FindBy(css = "a[href='/delete_account']")
    WebElement deleteAccount;

    @FindBy(css = "h2[data-qa=account-deleted]")
    public WebElement deletedAccountMessage;

    @FindBy(css = "#dismiss-button")
    public WebElement closeRegisteredUserAd;

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

    public void fillForm() {
//Map<String, String> webelements

        //  WebElement continueRegistration = driver.findElement(By.id());
        loginFormUserTitle.click();
        loginFormPassword.sendKeys(password);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", loginFormYears);
        loginFormDays.click();
        loginFormSelectedDay.click();
        loginFormMonths.click();
        loginFormSelectedMonth.click();
        loginFormYears.click();
        loginFormSelectedYear.click();
        loginFormNewsletter.click();
        loginFormOptSpecialOffers.click();
        loginFormUserFirstName.sendKeys(firstname);
        loginFormUserLastName.sendKeys(lastname);
        loginFormCompany.sendKeys(company);
        loginFormAddress1.sendKeys(address1);
        loginFormAddress2.sendKeys(address2);
        JavascriptExecutor js2 = (JavascriptExecutor) driver;
        js2.executeScript("arguments[0].scrollIntoView();", loginFormMobileNumber);
        loginFormCountry.click();
        loginFormSelectedCountry.click();
        loginFormState.sendKeys(state);
        loginFormCity.sendKeys(city);


        loginFormZipCode.sendKeys(zipcode);
        loginFormMobileNumber.sendKeys(mobileNumber);
    }

    public void createAccount() {
        loginFormCreateAccount.click();
    }

    public void deleteAccount() {
        deleteAccount.click();
    }
}
