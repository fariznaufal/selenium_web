package steps.bukalapak;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.http.Header;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageobject.bukalapak.AccountSettingPO;
import pageobject.bukalapak.HeaderPO;
import utilities.SeleniumHelpers;
import utilities.ThreadManager;

public class AccoutSettingSteps {
    private WebDriver driver = ThreadManager.getDriver();
    private HeaderPO header = new HeaderPO(driver);
    private AccountSettingPO accountsetting = new AccountSettingPO(driver);
    private SeleniumHelpers selenium = new SeleniumHelpers(driver);

    @When("user click on account setting menu and edit profile button")
    public void user_click_account_setting() throws InterruptedException {
        header.clickOnAccountSettingMenu();
        accountsetting.clickOnEditProfileButton();
    }

    @When("user input name with {string} and click save")
    public void user_input_name(String name) throws InterruptedException {
        accountsetting.enterName(name);
        accountsetting.clickOnSaveButton();
    }

    @Then("verify account name with {string}")
    public void verify_account_name(String name) {
        Assert.assertTrue(accountsetting.verifyAccountName(name));
    }
}
