package pageobject.hijabenka;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import utilities.SeleniumHelpers;

public class HeaderHijabenkaPO {
    WebDriver driver;
    SeleniumHelpers selenium;

    public HeaderHijabenkaPO(WebDriver driver){
        this.driver = driver;
        selenium = new SeleniumHelpers(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 60), this);
    }

    @FindBy(xpath = "//*[@class='login-trigger']")
    private WebElement btn_login_register;

    @FindBy(xpath = "//*[@class='header-right']/ul/li[1]")
    private WebElement btn_account;

    @FindBy(xpath = "//*[@class='search-trigger']")
    private WebElement btn_search;

    @FindBy(xpath = "//*[@id=\"keyword\"]")
    private WebElement txt_search;

    /**
     * Click Masuk/Daftar Button
     * @throws InterruptedException
     */
    public void clickOnLoginRegisterButton()throws InterruptedException{
        selenium.click(btn_login_register);
    }

    /**
     * Click account button
     * @throws InterruptedException throws exception
     */
    public void clickOnAccount()throws InterruptedException{
        selenium.click(btn_account);
    }

    /**
     * Verify Account
     */
    public void verifyAccount(){
        selenium.isElementAppeared(btn_account);
    }

    /**
     * Click search button
     * @throws InterruptedException throws exception
     */
    public void clickOnSearch()throws InterruptedException{
        selenium.click(btn_search);
    }

    /**
     * Enter search item
     * @param searchItem or input search item
     */
    public void inputSearchItem(String searchItem){
        selenium.enterText(txt_search, searchItem, true);
    }

    /**
     * Enter function
     */
    public void enterSearchItem(){
        selenium.hitEnterKey(txt_search, false);
    }
}
