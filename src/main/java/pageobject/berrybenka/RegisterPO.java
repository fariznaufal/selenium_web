package pageobject.berrybenka;

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

    /*
     * All WebElements are identified by @FindBy annotation
     *
     * @FindBy can accept tagName, partialLinkText, name, linkText, id, css,
     * className, xpath as attributes.
     */
    @FindBy(xpath = "//*[@class=\"register-link\"]")
    private WebElement DaftarAkunBaruButton;

    @FindBy(xpath = "//*[@id=\"form-register\"]/div/div[1]/input[1]")
    private WebElement InputNamaDepan;

    @FindBy(xpath = "//*[@id=\"form-register\"]/div/div[1]/input[2]")
    private WebElement InputNamaBelakang;

    @FindBy(xpath = "//*[@id=\"form-register\"]/div/div[2]/input")
    private WebElement InputEmailRegister;

    @FindBy(xpath = "//*[@id=\"form-register\"]/div/div[3]/input")
    private WebElement InputPasswordRegister;

    @FindBy(xpath = "//*[@id=\"form-register\"]/div/div[3]/input")
    private WebElement InputKetikUlangPassword;

    @FindBy(id = "btn-register")
    private WebElement BuatAkunButton;

    @FindBy(xpath = "/html/body/header/div[3]/ul/li[1]/a")
    private WebElement RegisterAlertMessage;


    /**
     * DaftarAkunBaruButton
     *@throws InterruptedException
     */
    public void clickOnDaftarAkunBaruButton() throws InterruptedException {
        selenium.clickOn(DaftarAkunBaruButton);
    }

    /**
     * InputNamaDepan
     *@throws InterruptedException
     */
    public void enterInputNamaDepan(String namaDepan) throws InterruptedException {
        selenium.enterText(InputNamaDepan, namaDepan, true);
    }

    /**
     * InputNamaBelakang
     *@throws InterruptedException
     */
    public void enterInputNamaBelakang(String namaBelakang) throws InterruptedException {
        selenium.enterText(InputNamaBelakang, namaBelakang, true);
    }

    /**
     * InputEmail
     *@throws InterruptedException
     */
    public void enterInputEmailRegister(String emailRegister) throws InterruptedException {
        selenium.enterText(InputEmailRegister, emailRegister, true);
    }

    /**
     * InputPassword
     *@throws InterruptedException
     */
    public void enterInputPasswordRegister(String passwordRegister) throws InterruptedException {
        selenium.enterText(InputPasswordRegister, passwordRegister, true);
    }

    /**
     * InputKetikUlangPassword
     *@throws InterruptedException
     */
    public void enterKetikUlangPassword(String ketikUlangPassword) throws InterruptedException {
        selenium.enterText(InputKetikUlangPassword, ketikUlangPassword, true);
    }

    /**
     * BuatAkunButton
     *@throws InterruptedException
     */
    public void BuatAkunButton() throws InterruptedException {
        selenium.clickOn(BuatAkunButton);
    }


    /**
     * Enter password
     * @throws InterruptedException
     */
    public void alertBoxAppeared() {
        selenium.isElementAppeared(RegisterAlertMessage);
    }
}
