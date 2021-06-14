package pageobject.berrybenka;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import utilities.SeleniumHelpers;

public class FilterBarangPO {
    WebDriver driver;
    SeleniumHelpers selenium;

    public FilterBarangPO(WebDriver driver){
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

    @FindBy(xpath = "//*[@id=\"ul-category\"]/li[4]")
    private WebElement click_category;

    @FindBy(xpath = "//*[@id=\"keyword\"]")
    private WebElement txt_searchFilterField;

    /**
     * Pilih Category Sepatu/Flats
     *@throws InterruptedException
     * @param
     */
    public void clickOnCategory() throws InterruptedException {
        selenium.click(click_category);
    }
    /**
     * Input Search Barang
     *@throws InterruptedException
     */
    public void InputSearchFilterBarang(String searchFilterBarang) throws InterruptedException {
        selenium.enterText(txt_searchFilterField, searchFilterBarang, true);
    }

    /**
     * Enter Search Barang
     *@throws InterruptedException
     */
    public void enterSearchFilterBarang() throws InterruptedException {
        selenium.hitEnterKey(txt_searchFilterField, false);
    }

    /**
     * Verify Filter Sepatu/Flats
     *@throws InterruptedException

    public void alertBoxAppeared() {
        selenium.isElementAppeared(FilterAlertMessage);
    }*/
}
