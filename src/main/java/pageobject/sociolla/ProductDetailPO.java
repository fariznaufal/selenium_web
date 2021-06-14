package pageobject.sociolla;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import utilities.SeleniumHelpers;

public class ProductDetailPO {

    WebDriver driver;
    SeleniumHelpers selenium;

    public ProductDetailPO(WebDriver driver){
        this.driver = driver;
        selenium = new SeleniumHelpers(driver);

        //This initElements method will create all WebElements
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 60), this);
    }

    @FindBy(xpath = "//*[@class='btn-qty btn-right']")
    private WebElement quantityButton;

    @FindBy(xpath = "//*[@class='submit addtocartsingle btn-buy-now']")
    private WebElement buyNowButton;

    /**
     * click quantity
     * @throws InterruptedException
     */
    public void clickOnQuantityButton() throws InterruptedException {
        selenium.clickOn(quantityButton);
    }
    /**
     * click button buy now
     * @throws InterruptedException
     */
    public void clickOnBuyNowButton() throws InterruptedException {
        selenium.clickOn(buyNowButton);
    }
}
