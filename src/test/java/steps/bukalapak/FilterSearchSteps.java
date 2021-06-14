package steps.bukalapak;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageobject.bukalapak.FilterSearchPO;
import pageobject.bukalapak.ProductListPO;
import utilities.SeleniumHelpers;
import utilities.ThreadManager;

import java.util.List;

public class FilterSearchSteps {
    private WebDriver driver = ThreadManager.getDriver();
    private ProductListPO productlist = new ProductListPO(driver);
    private FilterSearchPO filtersearch = new FilterSearchPO(driver);
    private SeleniumHelpers selenium = new SeleniumHelpers(driver);

    @When("user click on bukamall filter")
    public void user_click_bukamall_filter() throws InterruptedException {
        filtersearch.clickOnCheckboxBukamall();
    }

    @When("user hover filter scrollbar")
    public void user_hover_filter_scrollbar() {
        filtersearch.hoverFilterScrollbar();
    }

    @When("user scroll to bukamall checkbox")
    public void user_scroll_bukamall_checkbox() throws InterruptedException {
        filtersearch.scrollToCheckboxBukamall();
    }

    @When("user select sorting by {string}")
    public void user_select_sorting(String type) throws InterruptedException {
        productlist.selectSorting(type);
    }

    @Then("verify bukamall icon")
    public void verify_bukamall_icon() {
        Assert.assertTrue(productlist.verifyIconBukamall());
    }

    @Then("verify product sorting")
    public void verify_product_sorting() {
        Assert.assertTrue(productlist.verifyProductSorting());
    }
}
