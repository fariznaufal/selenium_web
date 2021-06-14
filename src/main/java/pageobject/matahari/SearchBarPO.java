package pageobject.matahari;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import utilities.SeleniumHelpers;

import java.util.List;
import java.util.Locale;

public class SearchBarPO {
    WebDriver driver;
    SeleniumHelpers selenium;

    public SearchBarPO(WebDriver driver){
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
    @FindBy(id = "search")
    private WebElement searchBar;

    @FindBy(xpath = "//*[@class='action search']")
    private WebElement buttonSearch;


    /**
     * input item
     * @param SB
     * @throws InterruptedException
     */
    public void inputSearch(String SB){
        selenium.enterText(searchBar, SB, true);
    }

    /**
     * click Button Search
     */
    public void ClickbuttonSearch ()  throws InterruptedException {
        selenium.click(buttonSearch);
    }
}
