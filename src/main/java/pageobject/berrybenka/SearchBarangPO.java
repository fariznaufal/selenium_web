package pageobject.berrybenka;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import utilities.SeleniumHelpers;

public class SearchBarangPO {
    WebDriver driver;
    SeleniumHelpers selenium;

    public SearchBarangPO(WebDriver driver){
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

    @FindBy(xpath = "//*[@class=\"search-trigger\"]")
    private WebElement btn_search;

    @FindBy(xpath = "//*[@id=\"keyword\"]")
    private WebElement txt_searchField;


    /**
     * Search
     *@throws InterruptedException
     */
    public void clickOnSearch() throws InterruptedException {
        selenium.clickOn(btn_search);
    }

    /**
     * Input Search Barang
     *@throws InterruptedException
     */
    public void InputSearchBarang(String searchBarang) throws InterruptedException {
        selenium.enterText(txt_searchField, searchBarang, true);
    }

    /**
     * Enter Search Barang
     *@throws InterruptedException
     */
    public void enterSearchBarang() throws InterruptedException {
        selenium.hitEnterKey(txt_searchField, false);
    }
}
