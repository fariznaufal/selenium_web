package pageobject.berrybenka;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import utilities.SeleniumHelpers;

public class AddBarangPO {
    WebDriver driver;
    SeleniumHelpers selenium;

    public AddBarangPO(WebDriver driver){
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
    ;

    @FindBy(xpath = "//*[@id=\"li-catalog\"]/a")
    private WebElement click_add_barang;

    @FindBy(xpath = "//*[@id=\"filter-color\"]/li/label")
    private WebElement click_pilihWarna;

    @FindBy(xpath = "//*[@id=\"BEJISHMU38-MC\"]")
    private WebElement click_pilihUkuran;

    @FindBy(xpath = "//*[@id=\"frmAddCart\"]/div[3]/input")
    private WebElement btn_beliSekarang;

    @FindBy(xpath = "//a[@class=\"add2cart\"]")
    private WebElement AddBarangAlertMessage;

    /**
     * Add Barang yang diinginkan
     *@throws InterruptedException
     */
    public void clickOnAddBarang() throws InterruptedException {
        selenium.clickOn(click_add_barang);
    }

    /**
     * Pilih Warna Barang
     *@throws InterruptedException
     */
    public void clickOnPilihWarna() throws InterruptedException {
        selenium.clickOn(click_pilihWarna);
    }

    /**
     * Pilih Ukuran Barang
     *@throws InterruptedException
     */
    public void clickOnPilihUkuran() throws InterruptedException {
        selenium.clickOn(click_pilihUkuran);
    }

    /**
     * Click Button Beli Sekarang
     *@throws InterruptedException
     */
    public void clickOnBeliSekarang() throws InterruptedException {
        selenium.clickOn(btn_beliSekarang);
    }

    /**
     * Verify AddBarang success being added
     *@throws InterruptedException
     */
    public void alertBoxAppeared() {
        selenium.isElementAppeared(AddBarangAlertMessage);
    }
}
