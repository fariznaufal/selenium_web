package pageobject.berrybenka;

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

    @FindBy(xpath = "/html/body/header/div[3]/ul/li[1]/a")
    private WebElement MasukDaftarButton;

    @FindBy(xpath = "//*[@id=\"form-login-route\"]/div/input[1]")
    private WebElement InputEmail;

    @FindBy(xpath = "//*[@id=\"form-login-route\"]/div/input[2]")
    private WebElement InputPassword;

    @FindBy(xpath = "//*[@id=\"form-login-route\"]/div/input[3]")
    private WebElement MasukButton;

    @FindBy(xpath = "/html/body/header/div[3]/ul/li[1]/a")
    private WebElement loginAlertMessage;

    /**
     * Click masuk daftar button
     *@throws InterruptedException
     */
    public void clickOnMasukDaftarButton() throws InterruptedException {
        selenium.clickOn(MasukDaftarButton);
    }

    /**
     * Enter email
     *@throws InterruptedException
     */
    public void enterEmail(String email) {selenium.enterText(InputEmail, email, true);
    }

    /**
     * Enter password
     * @throws InterruptedException
     */
    public void enterPassword(String password) throws InterruptedException {
        selenium.enterText(InputPassword, password, true);
    }

    /**
     * click masuk button
     * @throws InterruptedException
     */
    public void clickOnMasukButton() throws InterruptedException {
        selenium.clickOn(MasukButton);
    }

    /**
     * verify login successfully
     * @throws InterruptedException
     */
    public void alertBoxAppeared() {
        selenium.isElementAppeared(loginAlertMessage);
    }
}
