package pageobject.hijabenka;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import utilities.SeleniumHelpers;

public class AccountDashboardHijabenkaPO {
    WebDriver driver;
    SeleniumHelpers selenium;

    public AccountDashboardHijabenkaPO(WebDriver driver){
        this.driver = driver;
        selenium = new SeleniumHelpers(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 60), this);
    }

    @FindBy(xpath = "//*[@class='user-link']/ul/li[5]")
    private WebElement btn_setting;

    /**
     * Click setting button
     * @throws InterruptedException throws exception
     */
    public void clickOnSetting()throws InterruptedException{
        selenium.click(btn_setting);
    }
}
