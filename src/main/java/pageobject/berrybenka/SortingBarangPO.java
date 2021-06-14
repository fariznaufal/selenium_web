package pageobject.berrybenka;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import utilities.SeleniumHelpers;

public class SortingBarangPO {
    WebDriver driver;
    SeleniumHelpers selenium;

    public SortingBarangPO(WebDriver driver){
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

    @FindBy(id = "sort-by")
    private WebElement select_sort_by;

    @FindBy(xpath = "//*[@id=\"keyword\"]")
    private WebElement txt_searchField;

    /**
     * Enter Barang
     *@throws InterruptedException
     */
    public void enterSearchBarang() throws InterruptedException {
        selenium.hitEnterKey(txt_searchField, false);
    }

    /**
     * Sorting Barang
     *@throws InterruptedException
     */
    public void clickOnSorting() throws InterruptedException {
        selenium.click(select_sort_by);
    }
}
