package automationexercise.pageobjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactUsObjects extends BasePageObjects {

    public ContactUsObjects() {
        super();
    }

    @FindBy(css = "header li:nth-child(8)")
    WebElement contactUsLink;
    @FindBy(css = "input[name='upload_file']")
    WebElement uploadFile;
    @FindBy(css = "input[data-qa='submit-button']")
    WebElement submitButton;
    @FindBy(css = "div.status.alert.alert-success")
    public WebElement successMessage;
    @FindBy(css = "header li:nth-child(1)")
    WebElement hompageLink;

    public void clickContactUs() {
        contactUsLink.click();
    }

    public void uploadFile() {
        String userDirectory = System.getProperty("user.dir");
        uploadFile.sendKeys(userDirectory +"\\src\\test\\resources\\testdata\\ContactUsTest.txt");
        submitButton.click();
        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public void backToHomePage() {
        hompageLink.click();
    }
}
