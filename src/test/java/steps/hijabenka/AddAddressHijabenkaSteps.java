package steps.hijabenka;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pageobject.hijabenka.AccountDashboardHijabenkaPO;
import pageobject.hijabenka.AccountSettingHijabenkaPO;
import pageobject.hijabenka.AddAddressPopUpHijabenkaPO;
import pageobject.hijabenka.HeaderHijabenkaPO;
import utilities.SeleniumHelpers;
import utilities.ThreadManager;

public class AddAddressHijabenkaSteps {
    private WebDriver driver = ThreadManager.getDriver();
    private HeaderHijabenkaPO headerHijabenkaPO = new HeaderHijabenkaPO(driver);
    private AddAddressPopUpHijabenkaPO addAddressPopUpHijabenkaPO = new AddAddressPopUpHijabenkaPO(driver);
    private AccountDashboardHijabenkaPO accountDashboardHijabenkaPO = new AccountDashboardHijabenkaPO(driver);
    private AccountSettingHijabenkaPO accountSettingHijabenkaPO = new AccountSettingHijabenkaPO(driver);
    private SeleniumHelpers selenium = new SeleniumHelpers(driver);

    @And("user click on account button")
    public void user_click_on_account_button()throws InterruptedException {
        headerHijabenkaPO.clickOnAccount();
    }

    @And("user click on account setting button and click on add new address")
    public void user_click_on_account_setting_button_and_click_on_add_new_address() throws InterruptedException {
        accountDashboardHijabenkaPO.clickOnSetting();
        accountSettingHijabenkaPO.clickOnAddAddress();
    }

    @And("user fill the field {string} {string} {string}")
    public void user_fill_the_field(String address, String postalCode, String phone) throws InterruptedException{
        addAddressPopUpHijabenkaPO.enterAddress(address);
        addAddressPopUpHijabenkaPO.selectProvince();
        addAddressPopUpHijabenkaPO.selectCity();
        addAddressPopUpHijabenkaPO.enterPostalCode(postalCode);
        addAddressPopUpHijabenkaPO.enterPhone(phone);
        addAddressPopUpHijabenkaPO.clickOnSaveAddress();
    }

    @Then("verify the address")
    public void verify_the_address() {
        accountSettingHijabenkaPO.verifyAddress();
    }
}
