package pageobject.bukalapak;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import utilities.SeleniumHelpers;

public class RegisterPO {
    WebDriver driver;
    SeleniumHelpers selenium;

    public RegisterPO(WebDriver driver) {
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
    private WebElement registerEmailorPhone;

    @FindBy(id = "user_gender_laki-laki")
    private WebElement radioLakiLaki;

    @FindBy(id = "user_gender_perempuan")
    private WebElement radioPerempuan;

    @FindBy(id = "user_password")
    private WebElement registerPassword;

    @FindBy(id = "user_password_confirmation")
    private WebElement registerPasswordConfirm;

    @FindBy(id = "user_agreement")
    private WebElement checkboxUserAgreement;

    @FindBy(xpath = "//button[@name='commit']")
    private WebElement registerSubmitButton;

    @FindBy(xpath = "//div[@class='c-fld__error' and contains(text(), 'E-mail atau nomor handphone harus valid')]")
    private WebElement errorMessageEmail;


    /**
     * Enter Full Name
     * @param FullName full name input
     */
    public void enterFullName(String FullName) {
        selenium.enterText(registerFullName, FullName, true);
    }

    /**
     * Enter Register Email or Phone
     * @param EmailOrPhone email or phone input
     */
    public void enterEmailorPhone(String EmailOrPhone) {
        selenium.enterText(registerEmailorPhone, EmailOrPhone, true);
    }

    /**
     * Enter Password
     * @param Password password input
     */
    public void enterPassword(String Password) {
        selenium.enterText(registerPassword, Password, true);
    }

    /**
     * Enter Password Confirm
     * @param PasswordConfirm password confirmation input
     */
    public void enterPasswordConfirm(String PasswordConfirm) {
        selenium.enterText(registerPasswordConfirm, PasswordConfirm, true);
    }

    /**
     * Select radio button Laki-laki
     * @throws InterruptedException throws exception
     */
    public void clickOnRadioLakiLaki() throws InterruptedException {
        selenium.clickOn(radioLakiLaki);
    }

    /**
     * Select radio radio Perempuan
     * @throws InterruptedException throws exception
     */
    public void clickOnRadioPerempuan() throws InterruptedException {
        selenium.clickOn(radioPerempuan);
    }

    /**
     * Click on checkbox user agreement
     * @throws InterruptedException throws exception
     */
    public void clickOnUserAgreement() throws InterruptedException {
        selenium.clickOn(checkboxUserAgreement);
    }

    /**
     * Click submit button
     * @throws InterruptedException throws exception
     */
    public void clickOnSubmitButton() throws InterruptedException {
        selenium.clickOn(registerSubmitButton);
    }

    /**
     * Verify email error message appeared
     */
    public boolean verifyErrorMessageText() {
        return selenium.isElementAppeared(errorMessageEmail);
    }

    /**
     * Verify if nama lengkap field exisst
     */
    public boolean verifyFieldFullNameIsAppeared() {
        return selenium.isElementAppeared(registerFullName);
    }
}
