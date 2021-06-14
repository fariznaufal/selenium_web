package pageobject.facebook;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import utilities.SeleniumHelpers;

public class LoginPO {
    WebDriver driver;
    SeleniumHelpers selenium;

    public LoginPO(WebDriver driver){
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

    @FindBy(id = "email")
    private WebElement emailOrPhoneNumberEditText;

    @FindBy(id = "pass")
    private WebElement passwordEditText;

    //    @FindBy(xpath = "//*[@data-testid='royal_login_button']")
    @FindBy(xpath = "//button[@name='login']")
    private WebElement loginButton;

    //    @FindBy(xpath = "error_box")
    @FindBy(id = "error_box")
    private WebElement loginAlertBox;

    /**
     * Enter email or phone number
     * @param emailOrPassword
     */
    public void enterEmailOrPhoneNumber(String emailOrPassword) {
        selenium.enterText(emailOrPhoneNumberEditText, emailOrPassword, true);
    }

    /**
     * Enter password
     * @param emailOrPassword
     */
    public void enterPassword(String emailOrPassword) throws InterruptedException {
        selenium.enterText(passwordEditText, emailOrPassword, true);
    }

    /**
     * Enter password
     * @throws InterruptedException
     */
    public void clickOnLoginButton() throws InterruptedException {
        selenium.clickOn(loginButton);
    }

    /**
     * Enter password
     * @throws InterruptedException
     */
    public void alertBoxIsAppeared() {
        selenium.isElementAppeared(loginAlertBox);
    }


}
