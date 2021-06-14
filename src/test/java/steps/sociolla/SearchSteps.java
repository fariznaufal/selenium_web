package steps.sociolla;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageobject.sociolla.NavbarPO;
import utilities.SeleniumHelpers;
import utilities.ThreadManager;

public class SearchSteps {

    private WebDriver driver = ThreadManager.getDriver();
    private NavbarPO Navbar = new NavbarPO(driver);
    private SeleniumHelpers selenium = new SeleniumHelpers(driver);

    @And("user input barang {string} and enter")
    public void user_input_barang(String barang)throws InterruptedException{
        Navbar.inputSearchAndEnter(barang);
    }
    @Then("verify product name by keyword {string}")
    public void verify_product_name_by_keyword(String keyword) {
        for(int i= 1; i<11; i++) {
            String element = driver.findElement(By.xpath("(//*[@class='product__name'])["+i+"]")).getText();
            System.out.println(element);
        }
    }
}
