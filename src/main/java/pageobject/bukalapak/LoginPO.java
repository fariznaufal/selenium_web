package pageobject.bukalapak;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import utilities.SeleniumHelpers;

public class LoginPO {
    WebDriver driver;
    SeleniumHelpers selenium;

    public LoginPO(WebDriver driver) {
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

    @FindBy(id = "user_session_username")
    private WebElement emailOrPhoneNumberEditText;

    @FindBy(id = "user_session_password")
    private WebElement passwordEditText;

    @FindBy(xpath = "//button[@name='commit']")
    private WebElement loginButton;

    @FindBy(xpath = "//span[@class='c-fld__error']")
    private WebElement loginAlertBox;

    @FindBy(xpath = "//a[@class='js-tel--login_forget_password']")
    private WebElement forgotPasswordButton;

    @FindBy(xpath = "//a[@class='js-tel--login_register' and contains(text(),'Daftar di sini')]")
    private WebElement registerButton;

    @FindBy(xpath = "//p[contains(text(),'Logout')]")
    private WebElement logoutButton;

    /**
     * Enter email or phone number
     * @param emailOrPassword email or password input
     */
    public void enterEmailOrPhoneNumber(String emailOrPassword) {
        selenium.enterText(emailOrPhoneNumberEditText, emailOrPassword, true);
    }

    /**
     * Enter password
     * @param password password input
     */
    public void enterPassword(String password) {
        selenium.enterText(passwordEditText, password, true);
    }

    /**
     * Click login button
     * @throws InterruptedException throws exception
     */
    public void clickOnLoginButton() throws InterruptedException {
        selenium.clickOn(loginButton);
    }

    /**
     * Enter password
     */
    public void pressEnterOnPassword() {
        selenium.hitEnterKey(passwordEditText, false);
    }

    /**
     * Verify Login alert box is appeared
     */
    public boolean alertBoxIsAppeared() {
        return selenium.isElementAppeared(loginAlertBox);
    }

    /**
     * Click Forgot Password button
     * @throws InterruptedException throws exception
     */
    public void clickOnForgotPasswordButton() throws InterruptedException {
        selenium.clickOn(forgotPasswordButton);
    }

    /**
     * Click Register button
     * @throws InterruptedException throws exception
     */
    public void clickOnRegisterButton() throws InterruptedException {
        selenium.clickOn(registerButton);
    }

    /**
     * Verify if logout button exist
     */
    public boolean verifyLogoutIsAppeared() {
        return selenium.isElementAppeared(logoutButton);
    }

}
