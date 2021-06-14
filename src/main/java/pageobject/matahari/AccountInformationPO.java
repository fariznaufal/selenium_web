package pageobject.matahari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import utilities.SeleniumHelpers;

public class AccountInformationPO {
    WebDriver driver;
    SeleniumHelpers selenium;

    public AccountInformationPO(WebDriver driver) {
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

    @FindBy(xpath = "//*[@data-ui-id='default-shipping-edit-link']")
    private WebElement btnChange;

    @FindBy(xpath = "//*[@class='box-content']/address")
    private WebElement addressinfo;

    /**
     * Click add adress
     *
     * @throws InterruptedException
     */
    public void clickOnAddAdress() throws InterruptedException {
        selenium.clickOn(btnChange);
    }

    /**
     * Verify changed address information
     */
    public boolean verifyAddressInformation() {
        return selenium.isElementAppeared(addressinfo);
    }
}
