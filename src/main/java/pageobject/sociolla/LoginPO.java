package pageobject.sociolla;

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

    @FindBy(id = "username")
    private WebElement emailOrUsernameEditText;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordEditText;

    @FindBy(xpath = "//*[@class='submit button btn-danger']")
    private WebElement loginButton;

    @FindBy(xpath = "//*[@class='alert']")
    private WebElement loginAlertBox;

    @FindBy(xpath = "//*[@class='toast-message']")
    private WebElement loginToastMessage;

    /**
     * Enter email or username
     * @param emailOrUsername
     *@throws InterruptedException
     */
    public void enterEmailOrUsername (String emailOrUsername) {
        selenium.enterText(emailOrUsernameEditText, emailOrUsername, true);
    }
    /**
     * Enter password
     * @param PasswordLogin
     *@throws InterruptedException
     */
    public void enterPasswordLogin(String PasswordLogin)  {

        selenium.enterText(passwordEditText, PasswordLogin, true);
    }
    /**
     * click login button
     *@throws InterruptedException
     */
    public void clickOnLoginButton() throws InterruptedException {
        selenium.clickOn(loginButton);
    }
    /**
     * error alert box
     * @throws InterruptedException
     */
    public void alertBoxIsAppeared() {

        selenium.isElementAppeared(loginAlertBox);
    }
    /**
     * error toast message
     * @throws InterruptedException
     */
    public void toastMessageIsAppeared() {

        selenium.isElementAppeared(loginToastMessage);
    }
}
