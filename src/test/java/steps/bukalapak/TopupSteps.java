package steps.bukalapak;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.http.Header;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageobject.bukalapak.HeaderPO;
import pageobject.bukalapak.TopupPO;
import utilities.SeleniumHelpers;
import utilities.ThreadManager;

public class TopupSteps {
    private WebDriver driver = ThreadManager.getDriver();
    private HeaderPO header = new HeaderPO(driver);
    private TopupPO topup = new TopupPO(driver);
    private SeleniumHelpers selenium = new SeleniumHelpers(driver);

    @When("user click on menu topup pulsa prabayar")
    public void user_click_topup_pulsa_prabayar() throws InterruptedException {
        header.clickOnPulsaPrabayarMenu();
    }

    @When("user input nomor telepon with {string} and select nominal")
    public void user_input_nomor_telepon(String nomortelepon) throws InterruptedException {
        topup.inputNomorTelepon(nomortelepon);
        topup.selectNominal();
    }

    @When("user click on beli pulsa button")
    public void user_click_beli_pulsa() throws InterruptedException {
        topup.clickOnBeliPulsaButton();
    }

    @Then("verify nomor telepon")
    public void verify_nomor_telepon() {
        Assert.assertTrue(topup.verifyPhoneNumber());
    }

}
