package pageobject.matahari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import utilities.SeleniumHelpers;

public class PopUpAddToCartPO {
    WebDriver driver;
    SeleniumHelpers selenium;

    public PopUpAddToCartPO(WebDriver driver){
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

    @FindBy(xpath = "//*[@class='cart-popup-swatch-attribute-options clearfix']/div[@id='option-label-size-558-item-16548']")
    private WebElement choseSize;

    @FindBy(xpath = "//*[@id=\"product-options-wrapper\"]/div/div/div/div[3]/div/div[1]")
    private WebElement choseColor;

    @FindBy(id = "product-addtocart-button")
    private WebElement addTocartBtn;


    /**
     * Chose Size
     * @throws InterruptedException throws exception
     */
    public void clickOnChoseSize() throws InterruptedException {
        selenium.hardWait(3);
        selenium.javascriptClickOn(choseSize);
    }

    /**
     * Chose color
     * @throws InterruptedException throws exception
     */
    public void clickOnChoseColor()  throws InterruptedException{
        selenium.clickOn(choseColor);
    }

    /**
     * Click add to cart button
     * @throws InterruptedException throws exception
     */

    public void clickOnAddToCart() throws InterruptedException {
        selenium.clickOn(addTocartBtn);
    }


}




