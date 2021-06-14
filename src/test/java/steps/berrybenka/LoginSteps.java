package steps.berrybenka;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pageobject.berrybenka.LoginPO;
import utilities.SeleniumHelpers;
import utilities.ThreadManager;

public class LoginSteps {
    private WebDriver driver = ThreadManager.getDriver();
    private LoginPO login = new LoginPO(driver);
    private SeleniumHelpers selenium = new SeleniumHelpers(driver);

    @When("user click the button masuk daftar")
    public  void user_click_the_button_masuk_daftar() throws InterruptedException{
        login.clickOnMasukDaftarButton();
    }

    @Then("user input the email {string}")
    public void user_input_the_email(String email) {
        login.enterEmail(email);
    }

    @And("user input the password {string}")
    public void user_input_the_password(String password) throws InterruptedException {
        login.enterPassword(password);
    }

    @And("user click masuk button")
    public void user_click_masuk_button() throws InterruptedException{
        login.clickOnMasukButton();
    }

    @Then("verify the login page")
    public void verify_the_login_page() {
        login.alertBoxAppeared();
    }
}




