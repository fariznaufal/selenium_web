package pageobject.sociolla;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import utilities.SeleniumHelpers;

public class ShoppingBagPO {
    WebDriver driver;
    SeleniumHelpers selenium;

    public ShoppingBagPO(WebDriver driver){
        this.driver = driver;
        selenium = new SeleniumHelpers(driver);

        //This initElements method will create all WebElements
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 60), this);
    }

    @FindBy(xpath = "//*[@class='checkout-button']")
    private WebElement checkoutButton;

    @FindBy(xpath = "//*[@class='list-step__text']")
    private WebElement verifyBuyNow;

    /**
     * click button checkout
     * @throws InterruptedException
     */
    public void clickOnCheckoutButton() throws InterruptedException {
        selenium.clickOn(checkoutButton);
    }
    /**
     * Verify chekout pada page pembayaran
     * @throws InterruptedException
     */
    public boolean verifyBuyNow() {
        return selenium.isElementAppeared(verifyBuyNow);
    }
}
