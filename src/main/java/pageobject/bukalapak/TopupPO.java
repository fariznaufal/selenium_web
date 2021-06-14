package pageobject.bukalapak;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import utilities.SeleniumHelpers;

import java.util.Arrays;

public class TopupPO {
    WebDriver driver;
    SeleniumHelpers selenium;
    String notel;

    public TopupPO(WebDriver driver) {
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

    @FindBy(xpath = "//input[@class='c-inp qa-vp-phone-credit-prepaid-lp-customer-number']")
    private WebElement inputNomorTelepon;

    @FindBy(xpath = "//div[@class='multiselect multiselect']")
    private WebElement nominalDropdown;

    @FindBy(xpath = "//li[@class='multiselect__element']/*//strong[contains(text(), '5.000')]")
    private WebElement nominalOption;

    @FindBy(xpath = "//button[@class='phone-credit-buy-btn c-btn c-btn--large c-btn--default c-btn--red']")
    private WebElement beliPulsaButton;

    @FindBy(xpath = "//div[@class='flex mv-8 qa-sidebar-phone-number']/div[@class='ml-16 qa-detail-row-value']")
    private WebElement nomorTeleponDetail;




    /**
     * Click Pulsa Prabayar Menu
     * @param nomortelepon Nomor Telepon
     */
    public void inputNomorTelepon(String nomortelepon) {
        notel = nomortelepon;
        selenium.enterText(inputNomorTelepon, nomortelepon, true);
    }

    /**
     * Select Dropdown Nominal
     * @throws InterruptedException throws exception
     */
    public void selectNominal() throws InterruptedException {
        selenium.hardWait(3);
        selenium.clickOn(nominalDropdown);
        selenium.clickOn(nominalOption);
    }

    /**
     * Click Beli Pulsa Button
     * @throws InterruptedException throws exception
     */
    public void clickOnBeliPulsaButton() throws InterruptedException {
        selenium.clickOn(beliPulsaButton);
    }

    /**
     * Verify Detail Transaction
     * @throws InterruptedException throws exception
     */
    public boolean verifyPhoneNumber() {
        String notelDetail = nomorTeleponDetail.getText().trim();
        return notel.equals(notelDetail);
    }
}
