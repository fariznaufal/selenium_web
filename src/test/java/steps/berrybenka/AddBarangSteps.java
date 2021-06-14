package steps.berrybenka;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pageobject.berrybenka.AddBarangPO;
import utilities.SeleniumHelpers;
import utilities.ThreadManager;


//import static utilities.SeleniumHelpers.getChromeInstance;

public class AddBarangSteps {
    //private ChromeDriver driver = getChromeInstance();
    private WebDriver driver = ThreadManager.getDriver();
    private AddBarangPO add = new AddBarangPO(driver);
    private SeleniumHelpers selenium = new SeleniumHelpers(driver);

    @Then("user click barang")
    public void user_click_barang() throws InterruptedException{
        add.clickOnAddBarang();
    }

    @And("user click warna barang")
    public void user_click_warna_barang() throws InterruptedException{
        add.clickOnPilihWarna();

    }

    @And("user click ukuran barang")
    public void user_click_ukuran_barang() throws InterruptedException{
        add.clickOnPilihUkuran();
    }

    @And("user click beli sekarang button")
    public void user_click_beli_sekarang_button() throws InterruptedException{
        add.clickOnBeliSekarang();
    }

    @Then("verify add barang successfully")
    public void verify_add_barang_successfully() throws InterruptedException{
    }
}
