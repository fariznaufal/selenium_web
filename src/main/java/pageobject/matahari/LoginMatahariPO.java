package pageobject.matahari;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import utilities.SeleniumHelpers;

public class LoginMatahariPO {
    WebDriver driver;
    SeleniumHelpers selenium;

    public LoginMatahariPO(WebDriver driver){
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

    @FindBy(xpath = "//*[@class='sub-title']/a")
    private WebElement linkRegiter;

    @FindBy(id = "email")
    private WebElement emailText;

    @FindBy(id = "pass")
    private WebElement passwordText;

    @FindBy(id = "send2")
    private WebElement loginButton;

    /**
     * Enter email or phone number
     * @param email
     *@throws InterruptedException
     */
    public void enterEmail(String email) throws InterruptedException {
        selenium.enterText(emailText, email, true);
    }

    /**
     * Click link daftar
     *
     *@throws InterruptedException
     */
    public void clickLinkDaftar() throws InterruptedException {
        selenium.clickOn(linkRegiter);
    }

    /**
     * Enter password
     */
    public void enterPassword(String password) throws InterruptedException {
        selenium.enterText(passwordText, password, true);
    }

    /**
     * Enter Login Button
     * @throws InterruptedException
     */
    public void clickOnLoginButton() throws InterruptedException {
        selenium.click(loginButton);
    }


}

