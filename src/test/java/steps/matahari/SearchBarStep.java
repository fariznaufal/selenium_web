package steps.matahari;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageobject.matahari.ProductListPO;
import pageobject.matahari.SearchBarPO;
import utilities.SeleniumHelpers;
import utilities.ThreadManager;

import java.util.List;
import java.util.Locale;


public class SearchBarStep {
    private WebDriver driver = ThreadManager.getDriver();
    private SeleniumHelpers selenium = new SeleniumHelpers(driver);
    private SearchBarPO SearchB = new SearchBarPO(driver);
    private ProductListPO list = new ProductListPO(driver);

    @Given("user input search bar {string}")
    public void user_input_search_bar(String SB) {
        SearchB.inputSearch(SB);
    }

    @And("user click search Button")
    public void user_click_search_Button() throws InterruptedException {
      SearchB.ClickbuttonSearch();
    }
    @Then("verify search result with keyword matahari {string}")
    public void verify_search_result(String keyword)  {
        List<WebElement> itemnames = driver.findElements(By.xpath("//*[@id=\"amasty-shopby-product-list\"]/div[2]/ol/li/div/div/strong/a"));
        WebElement itemName;
        String lowercaseName;
        for (int i = 0; i < 9; i++){
            itemName = itemnames.get(i);
            System.out.println(itemName.getText());
            lowercaseName = itemName.getText().toLowerCase(Locale.ROOT);
            keyword = keyword.toLowerCase(Locale.ROOT);
            Assert.assertTrue(lowercaseName.contains(keyword));

        }
    }

}
