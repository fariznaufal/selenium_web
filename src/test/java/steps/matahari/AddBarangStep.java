package steps.matahari;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageobject.matahari.PopUpAddToCartPO;
import pageobject.matahari.HeaderPO;
import pageobject.matahari.ProductListPO;
import utilities.SeleniumHelpers;
import utilities.ThreadManager;

import java.util.Locale;


public class AddBarangStep {
    private WebDriver driver = ThreadManager.getDriver();
    private SeleniumHelpers selenium = new SeleniumHelpers(driver);
    private PopUpAddToCartPO Add = new PopUpAddToCartPO(driver);
    private HeaderPO header = new HeaderPO(driver);
    private ProductListPO list = new ProductListPO(driver);

    @Given("user click button beli")
    public void user_click_button_beli() throws InterruptedException {
     list.clickOnBuyButton();
    }

    @When("user chose size")
    public void user_chose_size()throws InterruptedException  {
        Add.clickOnChoseSize();
    }

    @When("user chose color")
    public void user_chose_color() throws InterruptedException {
        Add.clickOnChoseColor();
    }
    @When("user klik add to cart")
    public void user_klik_add_to_cart() throws InterruptedException {
     Add.clickOnAddToCart();
    }

    @When("user click keranjang")
    public void user_click_keranjang() throws InterruptedException {
       header.clickOnShowCart();
    }

    @Then("verify item name on keranjang")
    public void verify_item_name_on_keranjang() throws InterruptedException  {
        header.setItemName();
        String productNameList = list.getItemName().toLowerCase(Locale.ROOT);
        String productnamecart = header.getItemName().toLowerCase(Locale.ROOT);
        Assert.assertEquals(productnamecart, productNameList);
    }



}