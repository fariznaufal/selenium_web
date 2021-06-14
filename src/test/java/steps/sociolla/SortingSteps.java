package steps.sociolla;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageobject.sociolla.ProductListPO;
import utilities.SeleniumHelpers;
import utilities.ThreadManager;
import java.util.List;

public class SortingSteps {

    private WebDriver driver = ThreadManager.getDriver();
    private ProductListPO ProductList = new ProductListPO(driver);
    private SeleniumHelpers selenium = new SeleniumHelpers(driver);

    @And("user click sorting harga sociolla")
    public void user_click_filter_harga_button() throws InterruptedException {
        ProductList.clickOnHargaButton();
    }

    @Then("verify sorting sociolla")
    public void verify_sorting_harga() {
        int item1,item2;
        List<WebElement> product = driver.findElements(By.xpath("//*[@class='product__price']"));
        for(int i=0; i < product.size() - 1; i++) {
            String price = product.get(i).getText();
            if(!product.get(i).getText().equals(product.get(i + 1).getText())){
                item1 = Integer.parseInt(product.get(i).getText().replaceAll("[^\\d]",""));
                item2 = Integer.parseInt(product.get(i + 1).getText().replaceAll("[^\\d]",""));
                System.out.println(item1);
                System.out.println(item2);
                if (item1 > item2){
                    Assert.fail();
                }
            }
        }
    }
}
