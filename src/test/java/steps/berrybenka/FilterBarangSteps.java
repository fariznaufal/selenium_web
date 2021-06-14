package steps.berrybenka;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageobject.berrybenka.FilterBarangPO;
import utilities.SeleniumHelpers;
import utilities.ThreadManager;
import java.util.List;
import java.util.Locale;

public class FilterBarangSteps {
    private WebDriver driver = ThreadManager.getDriver();
    private FilterBarangPO filter = new FilterBarangPO(driver);
    private SeleniumHelpers selenium = new SeleniumHelpers(driver);

    @And("user input search barang {string} click enter")
    public void user_input_search_barang_click_enter(String searchFilterBarang) throws InterruptedException {
        filter.InputSearchFilterBarang(searchFilterBarang);
        filter.enterSearchFilterBarang();
    }

    @And("user click filter checkbutton item ")
    public void user_click_filter_check_button_item() throws InterruptedException{
        filter.clickOnCategory();
    }

    @Then("verify the filter success")
    public void verify_the_filter_success() {
        List<WebElement> catalogName = driver.findElements(By.xpath("//*[@id=\"li-catalog\"]/a/div[2]/div[1]/h1"));
        String filterName = driver.findElement(By.xpath("/html/body/div[4]/div/div[1]/h1")).getText();
        WebElement catalogname;
        String lowercaseName;

        for (int i=1; i<=9; i++){
            catalogname = catalogName.get(i);
            System.out.println(catalogname.getText());
            lowercaseName = catalogname.getText().toLowerCase(Locale.ROOT);
            filterName = filterName.toLowerCase(Locale.ROOT);
            System.out.println(filterName);
            Assert.assertTrue(lowercaseName.contains(filterName));
        }
    }
}
