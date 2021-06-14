package pageobject.bukalapak;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import utilities.SeleniumHelpers;

public class HeaderPO {
    WebDriver driver;
    SeleniumHelpers selenium;
    JavascriptExecutor jse;

    public HeaderPO(WebDriver driver) {
        this.driver = driver;
        selenium = new SeleniumHelpers(driver);
        jse = (JavascriptExecutor) driver;

        //This initElements method will create all WebElements
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 60), this);
    }

    /*
     * All WebElements are identified by @FindBy annotation
     *
     * @FindBy can accept tagName, partialLinkText, name, linkText, id, css,
     * className, xpath as attributes.
     */

    @FindBy(xpath = "//span[@data-sigil-event-tracker='virtual_product']")
    private WebElement produkVirtualDropdown;

    @FindBy(xpath = "//li[@data-sigil-event-tracker='vp_category_topup_&_isi_pulsa']")
    private WebElement topupIsiPulsaMenu;

    @FindBy(xpath = "//img[@alt='pulsa_prabayar']")
    private WebElement pulsaPrabayarMenu;

    @FindBy(xpath = "//*[@class='sigil-header__nav-action svg-icon svg-fill']/..")
    private WebElement viewCartButton;

    @FindBy(xpath = "//img[@class='bl-avatar__img']")
    private WebElement imgProfile;

    @FindBy(xpath = "//span[@data-test='profile-url']")
    private WebElement profileDropdown;

    @FindBy(xpath = "//p[contains(text(), 'Pengaturan Akun')]")
    private WebElement accountSettingMenu;

    /**
     * Click Account Setting Menu
     */
    public void clickOnAccountSettingMenu() throws InterruptedException {
        selenium.clickOn(profileDropdown);
        selenium.clickOn(accountSettingMenu);
    }

    /**
     * Verify if profile image exist
     */
    public boolean verifyProfileImageIsAppeared() {
        return selenium.isElementAppeared(imgProfile);
    }

    /**
     * Click view cart button
     *
     * @throws InterruptedException throws exception
     */
    public void clickOnViewCart() throws InterruptedException {
        selenium.clickOn(viewCartButton);
    }

    /**
     * Click Pulsa Prabayar Menu
     * @throws InterruptedException throws exception
     */
    public void clickOnPulsaPrabayarMenu() throws InterruptedException {
        selenium.clickOn(produkVirtualDropdown);
        selenium.clickOn(topupIsiPulsaMenu);
        selenium.clickOn(pulsaPrabayarMenu);
    }
}
