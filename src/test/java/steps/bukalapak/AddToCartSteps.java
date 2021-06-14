package steps.bukalapak;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageobject.bukalapak.CartPO;
import pageobject.bukalapak.HeaderPO;
import pageobject.bukalapak.ProductListPO;
import utilities.SeleniumHelpers;
import utilities.ThreadManager;

import java.util.Locale;


public class AddToCartSteps {
    private WebDriver driver = ThreadManager.getDriver();
    private HeaderPO header = new HeaderPO(driver);
    private CartPO cart = new CartPO(driver);
    private ProductListPO productlist = new ProductListPO(driver);
    private SeleniumHelpers selenium = new SeleniumHelpers(driver);

    @When("user hover product")
    public void user_hover_product() {
        productlist.hoverProduct();
    }

    @When("user click on add to cart button")
    public void user_click_add_to_cart() throws InterruptedException {
        productlist.clickAddToCart();
    }

    @When("user click on view cart")
    public void user_click_view_cart() throws InterruptedException {
        header.clickOnViewCart();
    }

    @Then("verify product name on cart")
    public void verify_product_name_on_cart() {
        cart.setProductName();
        String productnameonlist = productlist.getProductName().toLowerCase(Locale.ROOT);
        String productnameoncart = cart.getProductName().toLowerCase(Locale.ROOT);
        Assert.assertEquals(productnameoncart, productnameonlist);
    }
}
