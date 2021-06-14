package steps.hijabenka;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pageobject.hijabenka.NewArrivalHijabenkaPO;
import pageobject.hijabenka.ShoppingCartPopUpHijabenkaPO;
import utilities.SeleniumHelpers;
import utilities.ThreadManager;

public class AddItemHijabenkaSteps {
    private WebDriver driver = ThreadManager.getDriver();
    private NewArrivalHijabenkaPO newArrivalHijabenkaPO = new NewArrivalHijabenkaPO(driver);
    private ShoppingCartPopUpHijabenkaPO shoppingCartPopUpHijabenkaPO = new ShoppingCartPopUpHijabenkaPO(driver);
    private SeleniumHelpers selenium = new SeleniumHelpers(driver);

    @And("Add the barang and checkout")
    public void Add_the_barang_and_checkout() throws InterruptedException{
        newArrivalHijabenkaPO.clickOnAddItem();
        newArrivalHijabenkaPO.clickOnSize();
        newArrivalHijabenkaPO.clickOnOrderNow();
    }

    @Then("verify the item Checkout")
    public void verify_the_item_Checkout()throws InterruptedException{
        shoppingCartPopUpHijabenkaPO.verifyItem();
    }
}
