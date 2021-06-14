package pageobject.hijabenka;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import utilities.SeleniumHelpers;

public class AccountSettingHijabenkaPO {
    WebDriver driver;
    SeleniumHelpers selenium;

    public AccountSettingHijabenkaPO(WebDriver driver){
        this.driver = driver;
        selenium = new SeleniumHelpers(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 60), this);
    }

    @FindBy(xpath = "//*[@class='ubah-alamat']/h2/a")
    private WebElement btn_add_address;

    @FindBy(xpath = "//*[@class='fancybox']")
    private WebElement btn_change_address;

    /**
     * Click add address button
     * @throws InterruptedException throws exception
     */
    public void clickOnAddAddress()throws InterruptedException{
        selenium.click(btn_add_address);
    }

    /**
     * verify address
     */
    public void verifyAddress(){
        selenium.isElementAppeared(btn_change_address);
    }
}
