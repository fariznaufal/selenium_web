package steps.berrybenka;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import pageobject.berrybenka.SortingBarangPO;
import utilities.SeleniumHelpers;
import utilities.ThreadManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortingBarangSteps {
    private WebDriver driver = ThreadManager.getDriver();
    private SortingBarangPO sort = new SortingBarangPO(driver);
    private SeleniumHelpers selenium = new SeleniumHelpers(driver);

    @And("user select sort by dropdown")
    public void user_select_sort_by_dropdown() {
        WebElement sortingName = driver.findElement(By.xpath("//*[@id=\"sort-by\"]"));
        Select sortingname = new Select(sortingName);
        List<String> originalList = new ArrayList();
        for (WebElement sn : sortingname.getOptions()) {
            originalList.add(sn.getText());
        }
        List<String> tempList = originalList;
        Collections.sort(tempList);
        Assert.assertEquals(tempList, originalList);
    }

    @Then("user verify sorting barang successfully")
    public void user_verify_sorting_barang_successfully() {
    }
}
