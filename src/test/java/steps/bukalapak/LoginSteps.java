package steps.bukalapak;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageobject.bukalapak.HeaderPO;
import pageobject.bukalapak.LoginPO;
import pageobject.bukalapak.RegisterPO;
import utilities.SeleniumHelpers;
import utilities.ThreadManager;

public class LoginSteps {
    private WebDriver driver = ThreadManager.getDriver();
    private HeaderPO header = new HeaderPO(driver);
    private LoginPO login = new LoginPO(driver);
    private RegisterPO register = new RegisterPO(driver);
    private SeleniumHelpers selenium = new SeleniumHelpers(driver);

    @When("user input email bukalapak {string}")
    public void user_input_email(String emailOrPhoneNumber) {
        login.enterEmailOrPhoneNumber(emailOrPhoneNumber);
    }

    @When("user input password bukalapak {string}")
    public void user_input_password(String password) {
        login.enterPassword(password);
    }

    @When("user click on login button bukalapak")
    public void user_click_login_button() throws InterruptedException {
        login.clickOnLoginButton();
    }

    @When("user pressed Enter key on Password field bukalapak")
    public void user_click_press_enter_on_password() {
        login.pressEnterOnPassword();
    }

    @Then("verify if system displayed alert box bukalapak")
    public void system_display_alert_box() {
        Assert.assertTrue(login.alertBoxIsAppeared());
    }

    @When("user click on forgot password button bukalapak")
    public void user_click_forgot_password_button() throws InterruptedException {
        login.clickOnForgotPasswordButton();
    }

    @When("user click on register button bukalapak")
    public void user_click_register_button() throws InterruptedException {
        login.clickOnRegisterButton();
    }

    @Then("verify if user successfully logged in")
    public void verify_user_logged_in() throws InterruptedException {
        selenium.hardWait(3);
        Assert.assertTrue(header.verifyProfileImageIsAppeared());
    }

    @Then("verify if user directed to register page")
    public void verify_user_redirected_to_register() {
        Assert.assertTrue(register.verifyFieldFullNameIsAppeared());
    }
}