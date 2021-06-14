package steps.hijabenka;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pageobject.hijabenka.HeaderHijabenkaPO;
import pageobject.hijabenka.LoginPopUpHijabenkaPO;
import utilities.SeleniumHelpers;
import utilities.ThreadManager;

public class LoginHijabenkaSteps {
    private WebDriver driver = ThreadManager.getDriver();
    private LoginPopUpHijabenkaPO loginPopUpHijabenkaPO = new LoginPopUpHijabenkaPO(driver);
    private HeaderHijabenkaPO headerHijabenkaPO = new HeaderHijabenkaPO(driver);
    private SeleniumHelpers selenium = new SeleniumHelpers(driver);
    
    @When("user click on button login")
    public void user_click_on_button_login() throws InterruptedException { headerHijabenkaPO.clickOnLoginRegisterButton(); }

    @Then("input the email {string}")
    public void input_the_email(String email){
        loginPopUpHijabenkaPO.enterUsername(email);
    }

    @And("user the input password {string}")
    public void user_the_input_password(String password){ loginPopUpHijabenkaPO.enterPassword(password); }

    @And("user click on login register button")
    public void user_click_on_login_register_button() throws InterruptedException{ loginPopUpHijabenkaPO.clickOnLoginButton();}

    @Then("verify the login")
    public void verify_the_login(){
        headerHijabenkaPO.verifyAccount();
    }
}
