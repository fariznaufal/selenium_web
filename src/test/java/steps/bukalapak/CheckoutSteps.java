package steps.bukalapak;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import pageobject.bukalapak.*;
import utilities.SeleniumHelpers;
import utilities.ThreadManager;

import java.util.List;
import java.util.Locale;

public class CheckoutSteps {
    private WebDriver driver = ThreadManager.getDriver();
    private ProductListPO productlist = new ProductListPO(driver);
    private SearchbarPO searchbar = new SearchbarPO(driver);
    private ProductPO product = new ProductPO(driver);
    private CheckoutPO checkout = new CheckoutPO(driver);
    private CartPO cart = new CartPO(driver);
    private SeleniumHelpers selenium = new SeleniumHelpers(driver);

    @When("user click on item")
    public void user_click_first_item() {
        productlist.clickOnFirstItem();
    }

    @When("user click on buy now button")
    public void user_click_buy_now() throws InterruptedException {
        product.clickOnBuyNowButton();
    }

    @When("user search and add multiple item to cart")
    public void user_add_multiple_item_to_cart(List<String> items) throws InterruptedException {
        for (String item : items) {
            searchbar.enterSearchKeyword(item);
            searchbar.clickOnSubmitSearch();
            productlist.addProductName();
            productlist.clickAddToCart();
        }
        List<String> savednames = productlist.getProductNames();
    }

    @When("user remove all items in cart")
    public void remove_all_items_in_cart() throws InterruptedException {
        cart.clickOnSelectAll();
        cart.clickOnDeleteAll();
    }

    @And("verify product name on checkout")
    public void verify_item_name_on_checkout() {
        checkout.setProductName();
        String productnameonlist = productlist.getProductName().toLowerCase(Locale.ROOT);
        String productnameoncheckout = checkout.getProductName().toLowerCase(Locale.ROOT);
        Assert.assertEquals(productnameoncheckout, productnameonlist);
    }

    @And("verify all product name on checkout")
    public void verify_all_product_name_on_checkout() {
        Assert.assertTrue(cart.verifyItemNames(productlist.getProductNames()));
    }

}
