package pageobject.bukalapak;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import utilities.SeleniumHelpers;

import java.util.List;

public class SearchbarPO {
    WebDriver driver;
    SeleniumHelpers selenium;

    public SearchbarPO(WebDriver driver) {
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

    @FindBy(id = "v-omnisearch__input")
    private WebElement searchBarInput;

    @FindBy(xpath = "//button[@class='v-omnisearch__submit']")
    private WebElement submitSearchButton;

    @FindBy(xpath = "//div[@id='autosuggest__result-item--2']")
    private WebElement vendorSearchResult;

    /**
     * Enter search keyword
     * @param keyword search input
     */
    public void enterSearchKeyword(String keyword) throws InterruptedException{
        searchBarInput.click();
        selenium.enterText(searchBarInput, keyword, true);
    }

    /**
     * Click submit search button
     * @throws InterruptedException throws exception
     */
    public void clickOnSubmitSearch() throws InterruptedException {
        selenium.clickOn(submitSearchButton);
    }

    /**
     * Click vendor search result
     * @throws InterruptedException throws exception
     */
    public void clickOnVendorSearchResult() throws InterruptedException {
        selenium.hardWait(3);
        selenium.clickOn(vendorSearchResult);
    }
}