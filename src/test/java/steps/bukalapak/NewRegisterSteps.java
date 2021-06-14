package steps.bukalapak;

import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pageobject.bukalapak.NewRegisterPO;
import utilities.ThreadManager;

public class NewRegisterSteps {
    private WebDriver driver = ThreadManager.getDriver();
    private NewRegisterPO register = new NewRegisterPO(driver);

    @When("new user input fullname {string}")
    public void new_user_input_fullname(String fullname) {
        register.enterFullName(fullname);
    }

    @When("new user input email {string}")
    public void new_user_input_email(String email) {
        register.enterEmail(email);
    }

    @When("new user input password {string}")
    public void new_user_input_password(String password) {
        register.enterPassword(password);
    }

    @When("new user click radio laki")
    public void new_user_click_laki() {
        register.clickOnRadioLaki();
    }

    @When("new user click submit")
    public void new_user_click_submit() {
        register.clickOnSubmit();
    }
}
