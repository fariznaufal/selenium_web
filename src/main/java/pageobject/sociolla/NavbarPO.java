package pageobject.sociolla;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import utilities.SeleniumHelpers;

public class NavbarPO {

    WebDriver driver;
    SeleniumHelpers selenium;

    public NavbarPO(WebDriver driver){
        this.driver = driver;
        selenium = new SeleniumHelpers(driver);

        //This initElements method will create all WebElements
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 60), this);
    }

    @FindBy(xpath = "//*[@id='globalSearch']")
    private WebElement searchFilterEditText;

    @FindBy(xpath = "//*[@class='username']")
    private WebElement profileLogin;

    /**
     * input search
     * @param inputSearchFilter
     * @throws InterruptedException
     */
    public void inputSearchAndEnter (String inputSearchFilter) throws InterruptedException{
        selenium.enterText(searchFilterEditText, inputSearchFilter, true);
        selenium.hardWait(20);
        selenium.hitEnterKey(searchFilterEditText, false);
        selenium.hardWait(20);
    }
    /**
     * verify login on the homepage
     * @throws InterruptedException
     */
    public boolean verifyProfileLogin() {
        return selenium.isElementAppeared(profileLogin);
    }
}
