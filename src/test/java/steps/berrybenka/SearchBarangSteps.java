package steps.berrybenka;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageobject.berrybenka.SearchBarangPO;
import utilities.SeleniumHelpers;
import utilities.ThreadManager;
import java.util.List;
import java.util.Locale;

public class SearchBarangSteps {
    private WebDriver driver = ThreadManager.getDriver();
    private SearchBarangPO search = new SearchBarangPO(driver);
    private SeleniumHelpers selenium = new SeleniumHelpers(driver);

    @Then("user click the search button")
    public void user_click_the_search_button() throws InterruptedException{
        search.clickOnSearch();
    }

    @And("user input search barang {string} and click enter")
    public void user_click_input_search_barang(String searchBarang) throws InterruptedException{
        search.InputSearchBarang(searchBarang);
        search.enterSearchBarang();
    }

    @Then("verify the barang search {string}")
    public void verifyTheBarangSearch(String searchBarang) {
        List<WebElement> productName = driver.findElements(By.xpath("//*[@id=\"li-catalog\"]/a/div[2]/div[1]/h1"));
        WebElement productname;
        String LowerCaseName;
        for (int i = 0; i < 9; i++){
            productname = productName.get(i);
            System.out.println(productname.getText());
            LowerCaseName = productname.getText().toLowerCase(Locale.ROOT);
            searchBarang = searchBarang.toLowerCase(Locale.ROOT);
            Assert.assertTrue(LowerCaseName.contains(searchBarang));
        }
    }
}
