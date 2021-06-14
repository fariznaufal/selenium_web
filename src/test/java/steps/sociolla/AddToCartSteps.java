package steps.sociolla;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pageobject.sociolla.ProductDetailPO;
import pageobject.sociolla.NavbarPO;
import pageobject.sociolla.ProductListPO;
import pageobject.sociolla.ShoppingBagPO;
import utilities.SeleniumHelpers;
import utilities.ThreadManager;

public class AddToCartSteps {

    private WebDriver driver = ThreadManager.getDriver();
    private ProductDetailPO ProductDetail = new ProductDetailPO(driver);
    private NavbarPO Navbar = new NavbarPO(driver);
    private ProductListPO ProductList = new ProductListPO(driver);
    private ShoppingBagPO ShoppingBag = new ShoppingBagPO(driver);
    private SeleniumHelpers selenium = new SeleniumHelpers(driver);

    @And("user click product name")
    public void user_click_shop_now_button() throws InterruptedException{
        ProductList.clickProductNameText();
    }

    @And("user click quantity")
    public void user_click_quantity_button() throws InterruptedException{
        ProductDetail.clickOnQuantityButton();
    }

    @And("user click buy now button")
    public void user_click_my_bag() throws InterruptedException{
        ProductDetail.clickOnBuyNowButton();
    }

    @And("user click checkout button")
    public void user_click_checkout_button() throws InterruptedException{
        ShoppingBag.clickOnCheckoutButton();
    }
    @Then("verify buy now sociolla")
    public boolean verify_buy_now_sociolla() {
        return ShoppingBag.verifyBuyNow();
    }
}
