package automationexercise.pageobjects;

import automationexercise.hooks.Hooks;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

    /*public void fillForm(List(Map<String, String>) webElements, String value) {
//Map<String, String> webelements
         @FindBy (DataTable.TableConverter)

        WebElement  elem;
        WebElement teve = new WebElement(driver.findElement(By));
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
    }*/

    public void createAccount() {
        loginFormCreateAccount.click();
    }

    public void deleteAccount() {
        deleteAccount.click();
    }
}
