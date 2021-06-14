package pageobject.hijabenka;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import utilities.SeleniumHelpers;

public class LoginPopUpHijabenkaPO {
    WebDriver driver;
    SeleniumHelpers selenium;

    public LoginPopUpHijabenkaPO(WebDriver driver) {
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

    @FindBy(xpath = "//*[@name='customer_email']")
    private WebElement txt_email;

    @FindBy(xpath = "//*[@name='password']")
    private WebElement txt_password;

    @FindBy(xpath = "//*[@value='masuk']")
    private WebElement btn_login;

    @FindBy(xpath = "//*[@id=\"form-login-route\"]/a")
    private WebElement btn_register;

    /**
     * Enter email
     * @param emailOrPassword
     */
    public void enterUsername(String emailOrPassword){
        selenium.enterText(txt_email, emailOrPassword, true);
    }

    /**
     * Enter Password
     * @param emailOrPassword
     */
    public void enterPassword(String emailOrPassword){
        selenium.enterText(txt_password, emailOrPassword, true);
    }

    /**
     * Click Login Button
     * @throws InterruptedException
     */
    public void clickOnLoginButton()throws InterruptedException{
        selenium.click(btn_login);
    }

    /**
     * Click register button
     * @throws InterruptedException throws exception
     */
    public void clickOnRegister()throws InterruptedException{
        selenium.click(btn_register);
    }
}
