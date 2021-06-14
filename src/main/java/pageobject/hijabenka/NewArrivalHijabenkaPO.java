package pageobject.hijabenka;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import utilities.SeleniumHelpers;

public class NewArrivalHijabenkaPO {
    WebDriver driver;
    SeleniumHelpers selenium;

    public NewArrivalHijabenkaPO(WebDriver driver){
        this.driver = driver;
        selenium = new SeleniumHelpers(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 60), this);
    }

    @FindBy(xpath = "//*[@id=\"li-catalog\"]/a")
    private WebElement btn_add_item;

    @FindBy(xpath = "//*[@id=\"BELOSHWH36-0E\"]")
    private WebElement btn_add_size_item;

    @FindBy(xpath = "//*[@class = 'button']/input")
    private WebElement btn_buy_now;

    /**
     * Click item from list
     * @throws InterruptedException throws exception
     */
    public void clickOnAddItem()throws InterruptedException{
        selenium.click(btn_add_item);
    }

    /**
     * Click size item
     * @throws InterruptedException throws exception
     */
    public void clickOnSize()throws InterruptedException{
        selenium.click(btn_add_size_item);
    }

    /**
     * Click buy item
     * @throws InterruptedException throws exception
     */
    public void clickOnOrderNow()throws InterruptedException {
        selenium.click(btn_buy_now);
    }
}
