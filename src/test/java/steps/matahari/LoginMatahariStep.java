package steps.matahari;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pageobject.facebook.LoginPO;
import pageobject.matahari.HeaderPO;
import pageobject.matahari.LoginMatahariPO;
import utilities.SeleniumHelpers;
import utilities.ThreadManager;

public class LoginMatahariStep {

    private WebDriver driver = ThreadManager.getDriver();
    private LoginMatahariPO login = new LoginMatahariPO(driver);
    private SeleniumHelpers selenium = new SeleniumHelpers(driver);
    private HeaderPO header = new HeaderPO(driver);

    @Given("user click link navbar login matahari")
    public void user_click_link_navbar_login() throws InterruptedException {

        header.clickOnNavbarLogin();
    }

    @When("user input email {string} matahari")
    public void user_input_email(String email) throws InterruptedException {

        login.enterEmail(email);
    }

    @When("user input password {string} matahari" )
    public void user_input_password(String password) throws InterruptedException{
        // Write code here that turns the phrase above into concrete actions
        login.enterPassword(password);
    }

    @When("user click login button matahari")
    public void user_click_login_button()throws InterruptedException {
        login.clickOnLoginButton();
    }

    @Then("Verify Profil Picture matahari")
    public boolean direct_to_page_login(){
        if (header.verifyProfilPicture()){
            return true;
        }
        return  false;
    }

}
