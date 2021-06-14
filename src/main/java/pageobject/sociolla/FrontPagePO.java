package pageobject.sociolla;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import utilities.SeleniumHelpers;

public class FrontPagePO {
    WebDriver driver;
    SeleniumHelpers selenium;

    public FrontPagePO(WebDriver driver){
        this.driver = driver;
        selenium = new SeleniumHelpers(driver);

        //This initElements method will create all WebElements
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 60), this);
    }

    @FindBy(xpath = "//*[@class='login-mobile__button'][1]")
    private WebElement buttonMasuk;

    @FindBy(xpath = "//*[@class='login-mobile__button has-bg']")
    private WebElement buttonDaftar;

    /**
     * masuk ke sociolla
     * @throws InterruptedException
     */
    public void clickOnButtonMasuk() throws InterruptedException {
        selenium.clickOn(buttonMasuk);
    }
    /**
     * daftar ke sociolla
     * @throws InterruptedException
     */
    public void clickOnButtonDaftar() throws InterruptedException {
        selenium.clickOn(buttonDaftar);
    }
}
