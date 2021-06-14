package steps.matahari;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pageobject.matahari.FilterBarangPO;
import pageobject.matahari.ProductListPO;
import utilities.SeleniumHelpers;
import utilities.ThreadManager;

public class FilterStep {
    private WebDriver driver = ThreadManager.getDriver();
    private SeleniumHelpers selenium = new SeleniumHelpers(driver);
    private FilterBarangPO filter = new FilterBarangPO(driver);
    private ProductListPO list = new ProductListPO(driver);

    @When("user click filter color")
    public void user_click_filter() throws InterruptedException {
        list.clickOnSwitchFilter();
    }

    @When("user chose colors")
    public void user_chose_category_from_filter() throws InterruptedException {
        list.clickOnListFilter();

    }

    @Then("verify item")
    public void verify_item() {
       list.verifyFilter();
    }
}
