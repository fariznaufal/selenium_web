package pageobject.hijabenka;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import utilities.SeleniumHelpers;

public class RegisterHijabenkaPO {
    WebDriver driver;
    SeleniumHelpers selenium;

    public RegisterHijabenkaPO(WebDriver driver){
        this.driver = driver;
        selenium = new SeleniumHelpers(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 60), this);
    }

    @FindBy(xpath = "//*[@name='customer_fname']")
    private WebElement txt_first_name;

    @FindBy(xpath = "//*[@name='customer_lname']")
    private WebElement txt_last_name;

    @FindBy(xpath = "(//*[@name='customer_email'])[3]")
    private WebElement txt_emailNew;

    @FindBy(xpath = "(//*[@name='password'])[3]")
    private WebElement txt_passwordNew;

    @FindBy(xpath = "//*[@name='password_confirmation']")
    private WebElement txt_retypePassword;

    @FindBy(xpath = "//*[@id=\"btn-register\"]")
    private WebElement btn_make_account;

    /**
     * Enter First name
     * @param textRequired or input first name
     */
    public void enterFirstName(String textRequired){
        selenium.enterText(txt_first_name,textRequired, true);
    }

    /**
     * Enter Last name
     * @param textRequired or input last name
     */
    public void enterLastName(String textRequired){
        selenium.enterText(txt_last_name,textRequired, true);
    }

    /**
     * Enter Email
     * @param textRequired or input email
     */
    public void enterEmailNew(String textRequired){
        selenium.enterText(txt_emailNew,textRequired, true);
    }

    /**
     * Enter Password
     * @param textRequired or input password
     */
    public void enterPasswordNeW(String textRequired){
        selenium.enterText(txt_passwordNew,textRequired, true);
    }

    /**
     * Enter Retype password
     * @param textRequired or retype password
     */
    public void enterRetypePassword(String textRequired){
        selenium.enterText(txt_retypePassword,textRequired, true);
    }

    /**
     * Click Make account button
     * @throws InterruptedException throws exception
     */
    public void clickOnMakeAccount()throws InterruptedException{
        selenium.click(btn_make_account);
    }
}
