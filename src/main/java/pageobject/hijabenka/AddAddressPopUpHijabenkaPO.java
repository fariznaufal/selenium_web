package pageobject.hijabenka;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import utilities.SeleniumHelpers;

public class AddAddressPopUpHijabenkaPO {
    WebDriver driver;
    SeleniumHelpers selenium;

    public AddAddressPopUpHijabenkaPO(WebDriver driver){
        this.driver = driver;
        selenium = new SeleniumHelpers(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 60), this);
    }

    @FindBy(xpath = "//*[@name='address']")
    private WebElement txt_address;

    @FindBy(xpath = "//*[@name='shipping_area']/option[2]")
    private WebElement select_province;

    @FindBy(xpath = "//*[@id='shipping_name']/option[2]")
    private WebElement select_city;

    @FindBy(xpath = "//*[@class='tambah-alamat-postal left']")
    private WebElement txt_postal_code;

    @FindBy(xpath = "//*[@name='phone']")
    private WebElement txt_phone;

    @FindBy(xpath = "//*[@id='account']/input[2]")
    private WebElement btn_save_address;

    /**
     * Enter Address
     * @param txtRequired or input address
     */
    public void enterAddress(String txtRequired){
        selenium.enterText(txt_address,txtRequired, true);
    }

    /**
     * select province
     * @throws InterruptedException throws exception
     */
    public void selectProvince()throws InterruptedException{
        selenium.click(select_province);
    }

    /**
     * select city
     * @throws InterruptedException throws exception
     */
    public void selectCity()throws InterruptedException{
        selenium.click(select_city);
    }

    /**
     * Enter postal code
     * @param txtRequired or input postal code
     */
    public void enterPostalCode(String txtRequired){
        selenium.enterText(txt_postal_code,txtRequired, true);
    }

    /**
     * Enter phone number
     * @param txtRequired or input phone number
     */
    public void enterPhone(String txtRequired){
        selenium.enterText(txt_phone,txtRequired, true);
    }

    /**
     * Click save address button
     * @throws InterruptedException throws exception
     */

    public void clickOnSaveAddress()throws InterruptedException{
        selenium.click(btn_save_address);
    }
}
