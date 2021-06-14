package pageobject.bukalapak;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import utilities.SeleniumHelpers;

public class ProductPO {
    WebDriver driver;
    SeleniumHelpers selenium;
    String productName;

    public ProductPO(WebDriver driver) {
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

    @FindBy(xpath = "//button[@class='c-main-product__action__buy bl-button bl-button--primary bl-button--medium']")
    private WebElement buyNowButton;

    /**
     * Click on the first item
     * @throws InterruptedException throws exception
     */
    public void clickOnBuyNowButton() throws InterruptedException {
        selenium.clickOn(buyNowButton);
    }
}
