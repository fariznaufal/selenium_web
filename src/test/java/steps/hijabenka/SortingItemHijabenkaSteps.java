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

public class SortingItemHijabenkaSteps {
    private WebDriver driver = ThreadManager.getDriver();
    private ProductListHijabenkaPO productListHijabenkaPO = new ProductListHijabenkaPO(driver);
    private SeleniumHelpers selenium = new SeleniumHelpers(driver);

    @And("user select sorting {string}")
    public void user_select_sorting(String sorting) throws InterruptedException{
        productListHijabenkaPO.selectItemSorting(sorting);
    }

    @Then("verify the sorting")
    public void verify_the_sorting() throws InterruptedException {
        String sorting = productListHijabenkaPO.getSortingType();
        List<WebElement> items;
        int itm1, itm2;
        switch (sorting){
            case "termurah":
                items = driver.findElements(By.xpath("//*[@class='detail-right']/p[2]"));
                for (int i=0; i<items.size()-1; i++){
                    if(!items.get(i).getText().equals(items.get(i+1).getText())){
                        itm1 = Integer.parseInt(items.get(i).getText().replaceAll("[^0-9]",""));
                        itm2 = Integer.parseInt(items.get(i+1).getText().replaceAll("[^0-9]",""));
                        System.out.println(itm1);
                        System.out.println(itm2);
                        if(itm1>itm2){
                            Assert.fail();
                        }
                    }
                }
                break;
            case "termahal" :
                items = driver.findElements(By.xpath("//*[@class='detail-right']/p[2]"));
                for (int i=0; i<items.size()-1; i++){
                    if(!items.get(i).getText().equals(items.get(i+1).getText())){
                        itm1 = Integer.parseInt(items.get(i).getText().replaceAll("[^0-9]",""));
                        itm2 = Integer.parseInt(items.get(i+1).getText().replaceAll("[^0-9]",""));
                        if(itm1<itm2){
                            Assert.fail();
                        }
                    }
                }
                break;
        }
    }
}
