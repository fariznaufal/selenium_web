package steps.sociolla;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pageobject.sociolla.FrontPagePO;
import pageobject.sociolla.LoginPO;
import pageobject.sociolla.NavbarPO;
import utilities.SeleniumHelpers;
import utilities.ThreadManager;

public class LoginSteps {
    private WebDriver driver = ThreadManager.getDriver();
    private LoginPO login = new LoginPO(driver);
    private FrontPagePO FrontPage = new FrontPagePO(driver);
    private NavbarPO Navbar = new NavbarPO(driver);
    private SeleniumHelpers selenium = new SeleniumHelpers(driver);

    @When("user click MASUK button sociolla")
    public void user_click_masuk_button() throws InterruptedException {
        FrontPage.clickOnButtonMasuk();
    }
    @And("user input email login {string}")
    public void user_input_emailOrUsername(String emailOrUsername) {

        login.enterEmailOrUsername(emailOrUsername);
    }
    @And("user input password login {string}")
    public void user_input_password(String password){

        login.enterPasswordLogin(password);
    }
    @And("user click login button sociolla")
    public void user_click_loginSociolla_button() throws InterruptedException {
        login.clickOnLoginButton();
    }
    @Then("system display alert box login")
    public void system_display_alert_box() {

        login.alertBoxIsAppeared();
    }
    @Then("system display toast message login")
    public void system_display_toast_message() {

        login.toastMessageIsAppeared();
    }
    @Then("verify profile sociolla")
    public boolean verify_profile_sociolla() {
        return Navbar.verifyProfileLogin();
    }
}
