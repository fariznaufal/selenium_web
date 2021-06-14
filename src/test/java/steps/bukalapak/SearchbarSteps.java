package steps.bukalapak;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageobject.bukalapak.ProductListPO;
import pageobject.bukalapak.SearchbarPO;
import utilities.SeleniumHelpers;
import utilities.ThreadManager;

import java.util.List;
import java.util.Locale;


public class SearchbarSteps {
    private WebDriver driver = ThreadManager.getDriver();
    private ProductListPO productlist = new ProductListPO(driver);
    private SearchbarPO searchbar = new SearchbarPO(driver);
    private SeleniumHelpers selenium = new SeleniumHelpers(driver);

    @When("user input search with keyword {string}")
    public void user_input_search_keyword(String keyword) throws InterruptedException {
        searchbar.enterSearchKeyword(keyword);
    }

    @When("user input search with keyword {string} and click on search submit button")
    public void user_input_search_keyword_and_click(String keyword) throws InterruptedException {
        searchbar.enterSearchKeyword(keyword);
        searchbar.clickOnSubmitSearch();
    }

    @Then("verify search result with keyword {string}")
    public void verify_search_result(String keyword) {
        Assert.assertTrue(productlist.verifySearchResultWithKeyword(keyword));
    }
}