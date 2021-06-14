package steps.matahari;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageobject.matahari.AccountInformationPO;
import pageobject.matahari.ChangeAddressPO;
import pageobject.matahari.HeaderPO;
import utilities.SeleniumHelpers;
import utilities.ThreadManager;

public class ChangeAddressStep {
    private WebDriver driver = ThreadManager.getDriver();
    private SeleniumHelpers selenium = new SeleniumHelpers(driver);
    private ChangeAddressPO adress = new ChangeAddressPO(driver);
    private HeaderPO header = new HeaderPO(driver);
    private AccountInformationPO account = new AccountInformationPO(driver);

    @When("user click link profil")
    public void user_click_link_profil() throws InterruptedException {
        header.clickOnLinkProfil();
    }

    @When("user click Add Address")
    public void user_click_Add_Address() throws InterruptedException {
        account.clickOnAddAdress();
    }

    @When("user input add address {string} {string} {string} {string} {string}")
    public void user_input_add_address(String label, String name, String telephone, String addres, String zip) throws InterruptedException {
        adress.enterLabel(label);
        adress.enterName(name);
        adress.enterTelephone(telephone);
        adress.enterAddress(addres);
        adress.enterZIP(zip);
    }

    @When("user select option province, city, subdistrict")
    public void user_select_option() throws InterruptedException {
        adress.selectProvince();
        adress.selectOptionProvince();
        adress.selectCity();
        adress.selectOptionCity();
        adress.selectSubDistrict();
        adress.selectOptionSubDistrict();
    }

    @When("user click save button")
    public void user_click_save_button() throws InterruptedException {
      adress.clickButtonSave();
    }

    @Then("verify change address")
    public void verifyChangeAddress() {
        Assert.assertTrue(account.verifyAddressInformation());
    }
}
