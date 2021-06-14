package steps.bukalapak;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageobject.bukalapak.RegisterPO;
import utilities.ThreadManager;

public class RegisterSteps {
    private WebDriver driver = ThreadManager.getDriver();
    private RegisterPO register = new RegisterPO(driver);

    @When("user input register email {string}")
    public void user_input_register_email(String email) {
        register.enterEmailorPhone(email);
    }

    @Then("verify if email error message is shown")
    public void verify_email_error_message() {
        Assert.assertTrue(register.verifyErrorMessageText());
    }
}
