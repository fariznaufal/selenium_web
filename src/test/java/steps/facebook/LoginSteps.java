package steps.facebook;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pageobject.facebook.LoginPO;
import utilities.ThreadManager;

public class LoginSteps {
    private WebDriver driver = ThreadManager.getDriver();
    private LoginPO login = new LoginPO(driver);

    @When("user input email {string}")
    public void user_input_email(String emailOrPhoneNumber) {
        login.enterEmailOrPhoneNumber(emailOrPhoneNumber);
    }

    @When("user input password {string}")
    public void user_input_password(String password) throws InterruptedException {
        login.enterPassword(password);
    }

    @When("user click login button")
    public void user_click_login_button() throws InterruptedException {
        login.clickOnLoginButton();
    }

    @Then("system display alert box")
    public void system_display_alert_box() {
        login.alertBoxIsAppeared();
    }

}
