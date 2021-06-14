package pageobject.bukalapak;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import utilities.SeleniumHelpers;

public class NewRegisterPO {
    WebDriver driver;
    SeleniumHelpers selenium;

    public NewRegisterPO(WebDriver driver) {
        this.driver = driver;
        selenium = new SeleniumHelpers(driver);

        //This initElements method will create all WebElements
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 60), this);
    }

    /*
     * All WebElements are identified by @FindBy annotation
     *
     * @FindBy can accept tagName, partialLinkText, name, linkText, id, css,
     * className, xpath as attributes.
     */


    @FindBy(id = "user_name")
    private WebElement registerFullName;

    @FindBy(id = "email_or_phone")
    private WebElement registerEmailPhone;

    @FindBy(id = "user_gender_laki-laki")
    private WebElement registerRadioLaki;

    @FindBy(id = "user_password")
    private WebElement registerPassword;

    @FindBy(id = "user_password_confirmation")
    private WebElement registerPasswordConfirm;

    @FindBy(id = "user_agreement")
    private WebElement userAgreement;

    @FindBy(xpath = "//button[@name='commit'][@type='submit']")
    private WebElement buttonSubmit;

    /**
     * Enter Full Name
     * @param fullname full name input
     */
    public void enterFullName(String fullname) {
        selenium.enterText(registerFullName, fullname, true);
    }

    /**
     * Enter Email
     * @param email email input
     */
    public void enterEmail(String email) {
        selenium.enterText(registerEmailPhone, email, true);
    }

    /**
     * Click Radio Laki
     */
    public void clickOnRadioLaki() {
        registerRadioLaki.click();
    }

    /**
     * Click user agreement and submit button
     */
    public void clickOnSubmit() {
        userAgreement.click();
        buttonSubmit.click();
    }

    /**
     * Enter Password and Confirm Password
     * @param password password input
     */
    public void enterPassword(String password) {
        selenium.enterText(registerPassword, password, true);
        selenium.enterText(registerPasswordConfirm, password, true);
    }
}
