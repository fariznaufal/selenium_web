package pageobject.matahari;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import utilities.SeleniumHelpers;

public class RegisterMatahariPO {
    WebDriver driver;
    SeleniumHelpers selenium;

    public RegisterMatahariPO(WebDriver driver){
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


    @FindBy(id = "email_address")
    private WebElement emailText;

    @FindBy(id = "firstname")
    private WebElement namaText;

    @FindBy(id = "telephone")
    private WebElement telephoneText;

    @FindBy(id = "date")
    private WebElement dateText;

    @FindBy(xpath = "//*[@id=\"ui-datepicker-div\"]/div[2]/button[2]")
    private WebElement btnDone;

    @FindBy(id = "password")
    private WebElement passwordText;

    @FindBy(xpath = "//*[@class='field choice ingroup'][2]")
    private WebElement gender;

    @FindBy(id = "mro-number")
    private WebElement mroText;

    @FindBy(xpath = "//*[@class='action submit primary']")
    private WebElement BtnRegister;

    @FindBy(xpath = "//*[@class='action submit primary']")
    private WebElement alertMessage;

    /**
     * Enter email
     * @param email
     *@throws InterruptedException
     */
    public void enterEmailRegister(String email) {

        selenium.enterText(emailText, email, true);
    }

    /**
     * Enter nama
     * @param nama
     *@throws InterruptedException
     */
    public void enterNama(String nama) {

        selenium.enterText(namaText, nama, true);
    }

    /**
     * Enter telephone
     * @param telephone
     *@throws InterruptedException
     */
    public void enterTelephone(String telephone) {

        selenium.enterText(telephoneText, telephone, true);
    }

    /**
     * Enter date
     * @param date
     *@throws InterruptedException
     */
    public void enterDate(String date) {

        selenium.enterText(dateText, date, true);
    }

    /**
     * Enter Done
     * @throws InterruptedException
     */
    public void clickOnDone() throws InterruptedException {
        selenium.click(btnDone);
    }

    /**
     * Enter password Register
     *@throws InterruptedException
     */
    public void enterPasswordRegister(String password) throws InterruptedException {
        selenium.enterText(passwordText, password, true);
    }


    /**
     * Select Gender
     * @throws InterruptedException
     */
    public void selectOnGender() throws InterruptedException {
        selenium.click(gender);
    }

    /**
     * Enter mro
     * @param mro
     *@throws InterruptedException
     */
    public void enterMro(String mro) throws InterruptedException {
        selenium.enterText(mroText, mro, true);
    }

    /**
     * Enter Register Button
     * @throws InterruptedException
     */
    public void clickOnRegister() throws InterruptedException {
        selenium.click(BtnRegister);
    }

    /**
     * Verify error message appeared
     */
    public boolean verifyAlert() {
        return selenium.isElementAppeared(alertMessage);
    }
}

