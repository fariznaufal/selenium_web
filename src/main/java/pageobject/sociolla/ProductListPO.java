package pageobject.sociolla;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import utilities.SeleniumHelpers;

public class ProductListPO {
    WebDriver driver;
    SeleniumHelpers selenium;

    public ProductListPO(WebDriver driver){
        this.driver = driver;
        selenium = new SeleniumHelpers(driver);

        //This initElements method will create all WebElements
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 60), this);
    }

    @FindBy(xpath = "//*[@id='desktop_504']")
    private WebElement brandFilterCheckbox;

    @FindBy(xpath = "//*[@class='btn btn-apply']")
    private WebElement filterApplyButton;

    @FindBy(xpath = "//*[@class='product__brand']")
    private WebElement verifyFilter;

    @FindBy(xpath = "(//*[@class='product__name'][@target='_blank'])")
    private WebElement productNameText;

    @FindBy(xpath = "//*[@class= 'filter-price']")
    private WebElement hargaSortingButton;

    /**
     * click brand filter
     * @throws InterruptedException
     */
    public void clickOnBrandFilterCheckbox() throws InterruptedException {
        selenium.clickOn(brandFilterCheckbox);
    }
    /**
     * click apply button
     * @throws InterruptedException
     */
    public void clickOnFilterApplyButton() throws InterruptedException {
        selenium.clickOn(filterApplyButton);
    }
    /**
     * click product name text
     * @throws InterruptedException
     */
    public void clickProductNameText() throws InterruptedException {
        selenium.click(productNameText);
        selenium.hardWait(20);
    }
    /**
     * sorting harga
     * @throws InterruptedException
     */
    public void clickOnHargaButton() throws InterruptedException {
        selenium.clickOn(hargaSortingButton);
    }
    /**
     * verifikasi after filter
     * @throws InterruptedException
     */
    public boolean verifyFilterBrand() {
        return selenium.isElementAppeared(verifyFilter);
    }
}
