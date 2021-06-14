package pageobject.bukalapak;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import utilities.SeleniumHelpers;

public class AccountSettingPO {
    WebDriver driver;
    SeleniumHelpers selenium;

    public AccountSettingPO(WebDriver driver) {
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

    @FindBy(xpath = "//a[@class='btn btn--red btn--medium'][contains(text(), 'Edit')]")
    private WebElement editProfileButton;

    @FindBy(xpath = "//input[@id='user_name']")
    private WebElement nameInput;

    @FindBy(xpath = "//input[@value='Simpan']")
    private WebElement saveButton;

    @FindBy(xpath = "//div[@id='setting_account']/dl[4]/dd")
    private WebElement accountName;

    /**
     * Click Edit Profile Button
     */
    public void clickOnEditProfileButton() throws InterruptedException {
        selenium.clickOn(editProfileButton);
    }

    /**
     * Click Save
     */
    public void clickOnSaveButton() throws InterruptedException {
        selenium.clickOn(saveButton);
    }

    /**
     * Enter Name
     * @param name Account Name
     */
    public void enterName(String name) {
        selenium.enterText(nameInput, name, true);
    }

    /**
     * Verify Account Name
     * @param name Account Name
     */
    public boolean verifyAccountName(String name) {
        return accountName.getText().equals(name);
    }

}
