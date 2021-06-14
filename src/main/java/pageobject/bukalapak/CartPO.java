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

import static org.apache.http.util.TextUtils.isEmpty;

public class CartPO {
    WebDriver driver;
    SeleniumHelpers selenium;
    String productName;

    public CartPO(WebDriver driver) {
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
    private WebElement productOnCart;

    @FindBy(xpath = "//span[@class='bl-text bl-text--body-default'][contains(text(),'Pilih Semua')]")
    private WebElement selectAllButton;

    @FindBy(xpath = "//span[@class='bl-text bl-text--body-small']/span[@class='bl-link is-contrast']")
    private WebElement deleteAllButton;

    /**
     * Click on select all checkbox
     */
    public void clickOnSelectAll() throws InterruptedException {
        selenium.hardWait(3);
        selenium.clickOn(selectAllButton);
    }

    /**
     * Click on delete all button
     */
    public void clickOnDeleteAll() throws InterruptedException {
        selenium.clickOn(deleteAllButton);
    }

    /**
     * Set product name
     */
    public void setProductName() {
        this.productName = productOnCart.getText();
    }

    /**
     * Get product name
     */
    public String getProductName() {
        return this.productName;
    }

    /**
     * Verify product name on cart
     */
    public boolean verifyProductNameOnCart() {
        if (!isEmpty(this.productName)) {
            System.out.println(this.productName.toLowerCase(Locale.ROOT));
            System.out.println(productOnCart.getText().toLowerCase(Locale.ROOT));

            return this.productName.toLowerCase(Locale.ROOT).equals(productOnCart.getText().toLowerCase(Locale.ROOT));
        }
        return false;
    }

    /**
     * Verify all item name
     * @param storednames list of stored item names
     */
    public boolean verifyItemNames(List<String> storednames) {
        List<WebElement> cartitems = driver.findElements(By.xpath("//p[@class='bl-text bl-text--subheading-2 bl-text--ellipsis__2']/span"));
        for (String storedname: storednames
             ) {
            System.out.println(storedname);
        }
        for (WebElement cartitem : cartitems) {
            System.out.println(cartitem.getText());
            if (!storednames.contains(cartitem.getText())) return false;
        }
        return true;
    }
}
