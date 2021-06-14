package pageobject.matahari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import utilities.SeleniumHelpers;

public class ChangeAddressPO {
    WebDriver driver;
    SeleniumHelpers selenium;

    public ChangeAddressPO(WebDriver driver) {
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

    //*[@id="maincontent"]/div[2]/div[1]/div[3]/div[2]/div/div[2]/a

    @FindBy(id = "label_alamat")
    private WebElement adressLabel;

    @FindBy(id = "firstname")
    private WebElement fullname;

    @FindBy(id = "telephone")
    private WebElement telephonetext;

    @FindBy(id = "street_1")
    private WebElement addresField;

    @FindBy(id = "region_id")
    private WebElement region;

    @FindBy(xpath = "//*[@id=\"region_id\"]/option[2]")
    private WebElement optionRegion;

    @FindBy(id = "city_id")
    private WebElement city;

    @FindBy(xpath = "//*[@id=\"city_id\"]/option[2]")
    private WebElement optionCity;

    @FindBy(id = "sub_district_id")
    private WebElement subDistrict;

    @FindBy(xpath = "//*[@id=\"sub_district_id\"]/option[2]")
    private WebElement optionSubDistrict;

    @FindBy(id = "zip")
    private WebElement zip;

    @FindBy(xpath = "//*[@class='action save primary']")
    private WebElement btnSave;

    /**
     * Enter Address Label
     *
     * @param label
     * @throws InterruptedException
     */
    public void enterLabel(String label) throws InterruptedException {
        selenium.enterText(adressLabel, label, true);
    }

    /**
     * Enter Full Name
     *
     * @param name
     * @throws InterruptedException
     */
    public void enterName(String name) throws InterruptedException {
        selenium.enterText(fullname, name, true);
    }

    /**
     * Enter Telephone
     *
     * @param telephone
     * @throws InterruptedException
     */
    public void enterTelephone(String telephone) throws InterruptedException {
        selenium.enterText(telephonetext, telephone, true);
    }

    /**
     * Enter Address
     *
     * @param address
     * @throws InterruptedException
     */
    public void enterAddress(String address) throws InterruptedException {
        selenium.enterText(addresField, address, true);
    }

    /**
     * Select Province
     *
     * @throws InterruptedException
     */
    public void selectProvince() throws InterruptedException {
        selenium.clickOn(region);
    }

    /**
     * Select option province
     *
     * @throws InterruptedException
     */
    public void selectOptionProvince() throws InterruptedException {
        selenium.clickOn(optionRegion);
    }

    /**
     * Select city
     *
     * @throws InterruptedException
     */
    public void selectCity() throws InterruptedException {
        selenium.clickOn(city);
    }

    /**
     * Select option city
     *
     * @throws InterruptedException
     */
    public void selectOptionCity() throws InterruptedException {
        selenium.clickOn(optionCity);
    }

    /**
     * Select sub district
     *
     * @throws InterruptedException
     */
    public void selectSubDistrict() throws InterruptedException {
        selenium.clickOn(subDistrict);
    }

    /**
     * Select option sub district
     *
     * @throws InterruptedException
     */
    public void selectOptionSubDistrict() throws InterruptedException {
        selenium.clickOn(optionSubDistrict);
    }

    /**
     * Select option sub district
     *
     * @throws InterruptedException
     */
    public void clickButtonSave() throws InterruptedException {
        selenium.clickOn(btnSave);
    }

    /**
     * Enter zip
     *
     * @param zipcode
     * @throws InterruptedException
     */
    public void enterZIP(String zipcode) throws InterruptedException {
        selenium.enterText(zip, zipcode, true);
    }

}

