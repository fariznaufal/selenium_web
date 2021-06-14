package pageobject.hijabenka;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import utilities.SeleniumHelpers;
import java.util.Locale;

public class ProductListHijabenkaPO {
    WebDriver driver;
    SeleniumHelpers selenium;
    String sortingType;

    public ProductListHijabenkaPO(WebDriver driver){
        this.driver = driver;
        selenium = new SeleniumHelpers(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 60), this);
    }

    @FindBy(xpath = "//*[@id=\"ul-category\"]/li[2]")
    private WebElement btn_filter;

    @FindBy(xpath = "//*[@id='sort-by']")
    private WebElement btn_sort;

    @FindBy(xpath = "//*[@id='sort-by']/option[4]")
    private WebElement btn_lowprice;

    @FindBy(xpath = "//*[@class='detail-right']/p[2]")
    private WebElement shoes_product;

    /**
     * Click filter item
     * @throws InterruptedException throws exception
     */
    public void inputFilter()throws InterruptedException{
        selenium.click(btn_filter);
    }

    /**
     * select sorting item
     * @param sorting
     */
    public void selectItemSorting(String sorting)throws InterruptedException{
        selenium.clickOn(btn_sort);
        sorting = sorting.toLowerCase(Locale.ROOT);
        this.setSortingType(sorting);
        WebElement option = null;
        switch (sorting){
            case "termurah":
                option = driver.findElement(By.xpath("//*[@id='sort-by']/option[4]"));
                break;
            case "termahal":
                option = driver.findElement(By.xpath("//*[@id='sort-by']/option[5]"));
                break;
        }
        selenium.clickOn(option);
    }

    /**
     * Set sorting item
     * @param sorting
     */
    private void setSortingType(String sorting) {
        this.sortingType = sorting;
    }

    /**
     * Get sorting type
     *
     */
    public String getSortingType() {
        return this.sortingType;
    }
}
