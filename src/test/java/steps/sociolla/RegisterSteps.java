package steps.sociolla;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pageobject.sociolla.FrontPagePO;
import pageobject.sociolla.RegisterPO;
import utilities.SeleniumHelpers;
import utilities.ThreadManager;

public class RegisterSteps {

    private WebDriver driver = ThreadManager.getDriver();
    private RegisterPO regist = new RegisterPO(driver);
    private FrontPagePO FrontPage = new FrontPagePO(driver);
    private SeleniumHelpers selenium = new SeleniumHelpers(driver);

    @When("user click DAFTAR button sociolla")
    public void user_click_daftar_button() throws InterruptedException {
        FrontPage.clickOnButtonDaftar();
    }
    @And("user input firstname {string}")
    public void user_input_firstname(String firstName) {

        regist.enterFirstName(firstName);
    }
    @And("user input lastname {string}")
    public void user_input_lastname(String lastName) {

        regist.enterLastName(lastName);
    }
    @And("user input username {string}")
    public void user_input_regUsername(String regUsername) {

        regist.enterRegUsername(regUsername);
    }
    @And("user input email regist {string}")
    public void user_input_regEmail(String regEmail) {

        regist.enterEmail(regEmail);
    }
    @And("user input no handphone {string}")
    public void user_input_noHandphone(String noHandphone) {

        regist.enterNoHandphone(noHandphone);
    }
    @And("user input regist password {string}")
    public void user_input_regPassword(String regPassword) {

        regist.enterRegPassword(regPassword);
    }
    @And("user click regist button sociolla")
    public void user_click_regist_button() throws InterruptedException {
        regist.clickOnRegistButton();
    }
    @Then("system display alert box regist")
    public void system_display_regist_alert_box() {
        regist.regisAlertBoxIsAppeared();
    }
}
