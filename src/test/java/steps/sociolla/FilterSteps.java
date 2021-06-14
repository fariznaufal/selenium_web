package steps.sociolla;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pageobject.sociolla.ProductListPO;
import utilities.SeleniumHelpers;
import utilities.ThreadManager;

public class FilterSteps {

    private WebDriver driver = ThreadManager.getDriver();
    private ProductListPO ProductList = new ProductListPO(driver);
    private SeleniumHelpers selenium = new SeleniumHelpers(driver);

    @And("user click Brand Avoskin and click apply button")
    public void user_click_masuk_button() throws InterruptedException {
        ProductList.clickOnBrandFilterCheckbox();
        ProductList.clickOnFilterApplyButton();
    }

    @Then("verify filter sociolla")
    public boolean verify_filter_sociolla() {
        return ProductList.verifyFilterBrand();
    }
}
