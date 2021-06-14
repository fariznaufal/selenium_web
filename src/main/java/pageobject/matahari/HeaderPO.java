package pageobject.matahari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import utilities.SeleniumHelpers;

public class HeaderPO {
    WebDriver driver;
    SeleniumHelpers selenium;
    String productName;

    public HeaderPO(WebDriver driver) {
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
    @FindBy(xpath = "//a[@class='navbar-link authorization-link']")
    private WebElement linkLogin;

    @FindBy(xpath = "//div[@id='first-characters']")
    private WebElement linkProfil;

    @FindBy(xpath = "//a[@class='action showcart']")
    private WebElement showCart;

    @FindBy(xpath = "//strong[@class='product-item-name']/a")
    private WebElement itemOnCart;

    /**
     * Set product name
     */
    public void setItemName() {
        this.productName = itemOnCart.getText();
    }

    /**
     * Get product name
     */
    public String getItemName() {
        return this.productName;
    }

    /**
     * Click Navbar login
     *
     * @throws InterruptedException
     */
    public void clickOnNavbarLogin() throws InterruptedException {
        selenium.clickOn(linkLogin);
    }

    /**
     * Click link Profil
     *
     * @throws InterruptedException
     */
    public void clickOnLinkProfil() throws InterruptedException {
        selenium.clickOn(linkProfil);
    }

    /**
     * verify Profil name
     *
     * @throws InterruptedException
     */
    public boolean verifyProfilPicture() {
        return (selenium.isElementAppeared(linkProfil));
    }

    /**
     * Click Show cart
     *
     * @throws InterruptedException throws exception
     */
    public void clickOnShowCart() throws InterruptedException {
        selenium.clickOn(showCart);
    }

    /**
     * verify item name on cart
     *
     * @throws InterruptedException throws exception
     */
    public boolean verifyItemNameCart() {
        return selenium.isElementAppeared(itemOnCart);
    }

}
