package pageobject.bukalapak;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import utilities.SeleniumHelpers;

public class FilterSearchPO {
    WebDriver driver;
    SeleniumHelpers selenium;
    JavascriptExecutor jse;

    public FilterSearchPO(WebDriver driver) {
        this.driver = driver;
        selenium = new SeleniumHelpers(driver);
        jse = (JavascriptExecutor) driver;

        //This initElements method will create all WebElements
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 60), this);
    }

    /*
     * All WebElements are identified by @FindBy annotation
     *
     * @FindBy can accept tagName, partialLinkText, name, linkText, id, css,
     * className, xpath as attributes.
     */

    @FindBy(xpath = "//label[@class='bl-checkbox te-filter-bukamall mb-8']/input")
    private WebElement checkboxBukamall;

    @FindBy(xpath = "//div[@class='ps__rail-y']")
    private WebElement customScroll;

    /**
     * Click checkbox Bukamall
     * @throws InterruptedException throws exception
     */
    public void clickOnCheckboxBukamall() throws InterruptedException {
        selenium.click(checkboxBukamall);
    }

    /**
     * Hover to filter scrollbar
     */
    public void hoverFilterScrollbar() {
        selenium.hoverElement(customScroll);
    }

    /**
     * Scroll to bukamall checkbox
     * @throws InterruptedException throws exception
     */
    public void scrollToCheckboxBukamall() throws InterruptedException {
        while (!selenium.isVisibleInViewport(checkboxBukamall)) {
            jse.executeScript("document.querySelector(\"div[class='sidebar-scroll-area ps ps--active-y']\").scrollTop += 100");
            selenium.hardWait(1);
        }
    }
}
