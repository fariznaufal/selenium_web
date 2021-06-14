package steps.hijabenka;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageobject.hijabenka.HeaderHijabenkaPO;
import utilities.SeleniumHelpers;
import utilities.ThreadManager;
import java.util.List;
import java.util.Locale;

public class SearchHijabenkaSteps {
    private WebDriver driver = ThreadManager.getDriver();
    private HeaderHijabenkaPO headerHijabenkaPO = new HeaderHijabenkaPO(driver);
    private SeleniumHelpers selenium = new SeleniumHelpers(driver);

    @And("user click on search button")
    public void user_click_on_search_button()throws InterruptedException{
        headerHijabenkaPO.clickOnSearch();
    }

    @And("user input search item {string} and click enter")
    public void user_input_search_item_and_click_enter(String item) {
        headerHijabenkaPO.inputSearchItem(item);
        headerHijabenkaPO.enterSearchItem();
    }

    @Then("verify the item search {string}")
    public void verify_the_item_search(String item) {
        List<WebElement> catalogName = driver.findElements(By.xpath("//*[@class='detail-left']/h1"));
        WebElement catalogname;
        String lowercaseName;
        for (int i=0; i<=9; i++){
            catalogname = catalogName.get(i);
            System.out.println(catalogname.getText());
            lowercaseName = catalogname.getText().toLowerCase(Locale.ROOT);
            item = item.toLowerCase(Locale.ROOT);
            Assert.assertTrue(lowercaseName.contains(item));
        }
    }
}
