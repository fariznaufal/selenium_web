package steps.hijabenka;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageobject.hijabenka.ProductListHijabenkaPO;
import utilities.SeleniumHelpers;
import utilities.ThreadManager;
import java.util.List;
import java.util.Locale;

public class FilterItemHijabenkaSteps {
    private WebDriver driver = ThreadManager.getDriver();
    private ProductListHijabenkaPO productListHijabenkaPO = new ProductListHijabenkaPO(driver);
    private SeleniumHelpers selenium = new SeleniumHelpers(driver);

    @And("user click on item filter button")
    public void user_click_on_item_filter_button() throws InterruptedException{
        productListHijabenkaPO.inputFilter();
    }

    @Then("verify the filter")
    public void verify_the_filter() {
        List<WebElement> catalogName = driver.findElements(By.xpath("//*[@class='detail-left']/h1"));
        WebElement  filter= driver.findElement(By.xpath("//*[@id=\"ul-category\"]/li[2]/label"));
        WebElement catalogname;
        String lowercaseName;
        String lowerName;

        for (int i=1; i<=9; i++){
            catalogname = catalogName.get(i);
            System.out.println(catalogname.getText());
            lowercaseName = catalogname.getText().toLowerCase(Locale.ROOT);
            lowerName = filter.getText().toLowerCase(Locale.ROOT);
            System.out.println(lowerName);
            Assert.assertTrue(lowercaseName.contains(lowerName));
        }
    }
}
