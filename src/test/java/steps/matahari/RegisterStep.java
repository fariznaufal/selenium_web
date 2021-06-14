package steps.matahari;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pageobject.matahari.LoginMatahariPO;
import pageobject.matahari.RegisterMatahariPO;
import utilities.SeleniumHelpers;
import utilities.ThreadManager;

public class RegisterStep {

    private WebDriver driver = ThreadManager.getDriver();
    private RegisterMatahariPO register = new RegisterMatahariPO(driver);
    private SeleniumHelpers selenium = new SeleniumHelpers(driver);
    private LoginMatahariPO login = new LoginMatahariPO(driver);

    @When("user click link register")
    public void user_click_link_register() throws InterruptedException {
        login.clickLinkDaftar();
    }

    @When("user input register email matahari {string}")
    public void user_input_regist_eremail_matahari(String email) throws InterruptedException {
        register.enterEmailRegister(email);
    }

    @When("user input register nama lengkap matahari {string}")
    public void user_input_register_nama_lengkap_matahari(String nama) throws InterruptedException {
      register.enterNama(nama);
    }

    @When("user input register telephone lengkap matahari {string}")
    public void user_input_register_telephone_lengkap_matahari(String telephone) throws InterruptedException {
      register.enterTelephone(telephone);
    }

    @When("user input register date {string}")
    public void user_input_register_date(String date) throws InterruptedException {
      register.enterDate(date);
        register.clickOnDone();
    }

    @When("user input register password {string}")
    public void user_input_register_password(String password) throws InterruptedException {
       register.enterPasswordRegister(password);
    }

    @When("user click gender matahari")
    public void user_click_gender_matahari() throws InterruptedException {
       register.selectOnGender();
    }

    @When("user click register button matahari")
    public void user_click_register_button_matahari() throws InterruptedException {
      register.clickOnRegister();
    }

    @Then("Verify alert matahari")
    public boolean verify_alert_matahari() {
        return register.verifyAlert();
    }






}
