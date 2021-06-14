package pageobject.bukalapak;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import utilities.SeleniumHelpers;

public class VendorPagePO {
    WebDriver driver;
    SeleniumHelpers selenium;
    String notel;

    public VendorPagePO(WebDriver driver) {
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

    @FindBy(xpath = "//button[@class='merchant-page__button ut-follow-button c-btn c-btn--default c-btn--default c-btn--red c-btn--spinner']")
    private WebElement followButton;

    @FindBy(xpath = "//div[@class='success flash__message']")
    private WebElement successNotice;

    /**
     * Click follow vendor
     * @throws InterruptedException throws exception
     */
    public void clickOnFollowButton() throws InterruptedException {
        selenium.clickOn(followButton);
    }

    /**
     * Verify if notice popup has shown
     */
    public boolean verifyNoticePopup() {
        return selenium.isVisibleInViewport(successNotice);
    }
}
