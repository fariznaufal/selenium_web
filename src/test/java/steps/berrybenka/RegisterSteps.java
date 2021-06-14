package steps.berrybenka;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pageobject.berrybenka.RegisterPO;
import utilities.SeleniumHelpers;
import utilities.ThreadManager;

public class RegisterSteps {
    private WebDriver driver = ThreadManager.getDriver();
    private RegisterPO register = new RegisterPO(driver);
    private SeleniumHelpers selenium = new SeleniumHelpers(driver);

    @Then("user click the button daftar")
    public void user_click_the_button_daftar() throws InterruptedException {
        register.clickOnDaftarAkunBaruButton();
    }

    @Then("user input nama depan {string}")
    public void user_input_nama_depan(String namaDepan) throws InterruptedException {
        register.enterInputNamaDepan(namaDepan);
    }

    @And("user input nama belakang {string}")
    public void user_input_nama_belakang(String namaBelakang) throws InterruptedException {
        register.enterInputNamaBelakang(namaBelakang);
    }

    @And("user input email for register {string}")
    public void user_input_email_for_register(String emailRegister) throws InterruptedException {
        register.enterInputEmailRegister(emailRegister);
    }

    @And("user input password for register {string}")
    public void user_input_password_for_register(String passwordRegister) throws InterruptedException {
        register.enterInputPasswordRegister(passwordRegister);
    }

    @And("user input ketik ulang password {string}")
    public void user_input_ketik_ulang_password(String ketikUlangPassword) throws InterruptedException{
        register.enterKetikUlangPassword(ketikUlangPassword);
    }

    @And("user click buat akun button")
    public void user_click_buat_akun_button() throws InterruptedException{
        register.BuatAkunButton();
    }

    @Then("verify register success")
    public void verify_register_success() {
        register.alertBoxAppeared();
    }
}
