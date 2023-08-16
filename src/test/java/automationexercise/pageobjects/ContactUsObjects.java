package automationexercise.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
        uploadFile.sendKeys("C:\\Users\\Andras_Mathesz\\Desktop");
        submitButton.click();
        driver.switchTo().alert().accept();
    }

    public void backToHomePage() {
        hompageLink.click();
    }
}
