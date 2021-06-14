package steps.bukalapak;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageobject.bukalapak.SearchbarPO;
import pageobject.bukalapak.VendorPagePO;
import utilities.SeleniumHelpers;
import utilities.ThreadManager;

public class VendorPageSteps {
    private WebDriver driver = ThreadManager.getDriver();
    private SearchbarPO searchbar = new SearchbarPO(driver);
    private VendorPagePO vendorpage = new VendorPagePO(driver);
    private SeleniumHelpers selenium = new SeleniumHelpers(driver);

    @When("user click on vendor page search result")
    public void user_click_vendor_page_search_result() throws InterruptedException {
        searchbar.clickOnVendorSearchResult();
    }

    @When("user click on follow button")
    public void user_click_follow_button() throws InterruptedException {
        vendorpage.clickOnFollowButton();
    }

    @Then("verify popup notice")
    public void verify_popup_notice() {
        Assert.assertTrue(vendorpage.verifyNoticePopup());
    }
}
