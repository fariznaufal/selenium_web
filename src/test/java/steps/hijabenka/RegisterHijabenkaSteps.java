package steps.hijabenka;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pageobject.hijabenka.LoginPopUpHijabenkaPO;
import pageobject.hijabenka.RegisterHijabenkaPO;
import utilities.SeleniumHelpers;
import utilities.ThreadManager;

public class RegisterHijabenkaSteps {
    private WebDriver driver = ThreadManager.getDriver();
    private LoginPopUpHijabenkaPO loginPopUpHijabenkaPO = new LoginPopUpHijabenkaPO(driver);
    private RegisterHijabenkaPO registerHijabenkaPO = new RegisterHijabenkaPO(driver);
    private SeleniumHelpers selenium = new SeleniumHelpers(driver);

    @Then("user click on button make account")
    public void user_click_button_make_account() throws InterruptedException{
        loginPopUpHijabenkaPO.clickOnRegister();
    }

    @Then("input first name {string} and last name {string}")
    public void input_first_name_and_last_name(String firstName, String lastName) {
        registerHijabenkaPO.enterFirstName(firstName);
        registerHijabenkaPO.enterLastName(lastName);
    }

    @And("user input new email {string}")
    public void user_input_new_email(String emailNew) {
        registerHijabenkaPO.enterEmailNew(emailNew);
    }

    @And("user input new password {string} and retype password {string}")
    public void user_input_new_password_and_retype_password(String passNew, String retypePass) {
        registerHijabenkaPO.enterPasswordNeW(passNew);
        registerHijabenkaPO.enterRetypePassword(retypePass);
    }

    @And("user click on button make new account")
    public void user_click_on_button_make_new_account()throws InterruptedException {
        registerHijabenkaPO.clickOnMakeAccount();
    }
}


