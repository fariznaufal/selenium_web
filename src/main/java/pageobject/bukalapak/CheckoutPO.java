package pageobject.bukalapak;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import utilities.SeleniumHelpers;

import java.util.List;
import java.util.Locale;

public class CheckoutPO {
    WebDriver driver;
    SeleniumHelpers selenium;
    String productName;

    public CheckoutPO(WebDriver driver) {
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

    @FindBy(xpath = "//p[@class='bl-text bl-text--subheading-2 bl-text--ellipsis__2']/span")
    private WebElement cartItemName;


    /**
     * Set product name
     */
    public void setProductName() {
        this.productName = cartItemName.getText();
    }

    /**
     * Get product name
     */
    public String getProductName() {
        return this.productName;
    }

    /**
     * Verify item name
     */
    public boolean verifyItemName() {
        return this.productName.toLowerCase(Locale.ROOT).equals(cartItemName.getText().toLowerCase(Locale.ROOT));
    }


}
