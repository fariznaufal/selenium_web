package pageobject.hijabenka;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import utilities.SeleniumHelpers;

public class ShoppingCartPopUpHijabenkaPO {
    WebDriver driver;
    SeleniumHelpers selenium;

    public ShoppingCartPopUpHijabenkaPO(WebDriver driver){
        this.driver = driver;
        selenium = new SeleniumHelpers(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 60), this);
    }

    @FindBy(xpath = "//*[@class='addtocart']")
    private WebElement btn_purchase;

    /**
     * Click buy process, verify item
     * @throws InterruptedException throws exception
     */
    public void verifyItem()throws InterruptedException{
        selenium.isElementAppeared(btn_purchase);
    }
}
