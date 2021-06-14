package pageobject.sociolla;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import utilities.SeleniumHelpers;

public class RegisterPO {

    WebDriver driver;
    SeleniumHelpers selenium;

    public RegisterPO(WebDriver driver){
        this.driver = driver;
        selenium = new SeleniumHelpers(driver);

        //This initElements method will create all WebElements
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 60), this);
    }

    @FindBy(id = "firstname")
    private WebElement firstNameEditText;

    @FindBy(id = "lastname")
    private WebElement lastNameEditText;

    @FindBy(id = "regusername")
    private WebElement regUsernameEditText;

    @FindBy(id = "email")
    private WebElement emailEditText;

    @FindBy(id = "minhp")
    private WebElement noHandphoneEditText;

    @FindBy(id = "regpassword")
    private WebElement regpasswordEditText;

    @FindBy(xpath = "(//*[@class='submit button btn-danger'][@value='DAFTAR SEKARANG'])")
    private WebElement registButton;

    @FindBy(xpath = "//*[@class='alert']")
    private WebElement registAlertBox;

    /**
     * Enter firstname
     * @param firstName
     *@throws InterruptedException
     */
    public void enterFirstName (String firstName) {

        selenium.enterText(firstNameEditText, firstName, true);
    }
    /**
     * Enter lastname
     * @param lastName
     *@throws InterruptedException
     */
    public void enterLastName (String lastName) {

        selenium.enterText(lastNameEditText, lastName, true);
    }
    /**
     * Enter registrasi username
     * @param regUsername
     *@throws InterruptedException
     */
    public void enterRegUsername (String regUsername) {

        selenium.enterText(regUsernameEditText, regUsername, true);
    }
    /**
     * Enter email
     * @param email
     *@throws InterruptedException
     */
    public void enterEmail (String email) {

        selenium.enterText(emailEditText, email, true);
    }
    /**
     * Enter no handphone
     * @param NoHandphone
     *@throws InterruptedException
     */
    public void enterNoHandphone (String NoHandphone) {

        selenium.enterText(noHandphoneEditText, NoHandphone, true);
    }
    /**
     * Enter registrasi password
     * @param regPassword
     *@throws InterruptedException
     */
    public void enterRegPassword (String regPassword) {

        selenium.enterText(regpasswordEditText, regPassword, true);
    }
    /**
     * click registrasi button
     *@throws InterruptedException
     */
    public void clickOnRegistButton() throws InterruptedException {
        selenium.clickOn(registButton);
    }
    /**
     * error alert box
     *@throws InterruptedException
     */
    public void regisAlertBoxIsAppeared() {

        selenium.isElementAppeared(registAlertBox);
    }
}
