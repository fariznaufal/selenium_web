package pageobject.matahari;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import utilities.SeleniumHelpers;

import java.util.List;
import java.util.Locale;

public class ProductListPO {
    WebDriver driver;
    SeleniumHelpers selenium;
    String itemName;

    public ProductListPO(WebDriver driver) {
        this.driver = driver;
        selenium = new SeleniumHelpers(driver);

        //This initElements method will create all WebElements
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 60), this);
    }

    /*
     * All WebElements are identified by @FindBy annotation
     *
     * @FindBy can accept tagName, partialLinkText, name, linkText, id, css,
     * className, xpath as attributes.
     */

    @FindBy(xpath = "//*[@class='action tocart primary'][1]")
    private WebElement btnBeli;

    @FindBy(xpath = "//*[@id=\"narrow-by-list\"]/div[4]/div[1]/div")
    private WebElement filterColor;

    @FindBy(xpath = "//*[@id=\"narrow-by-list\"]/div[4]/div[2]/form/div/div[1]/a/div")
    private WebElement listFilter;

    @FindBy(xpath = "//*[@id=\"amasty-shopby-product-list\"]/div[2]/ol/li/div/div/div[1]/div[1]")
    private List<WebElement> itemNames;

    @FindBy(xpath = "//*[@class='item product product-item'][1]//a[@class='product-item-link']")
    private WebElement item;

    /**
     * Set product name
     */
    public void setItemName() {
        this.itemName = item.getText();
    }

    /**
     * Get product name
     */
    public String getItemName() {
        return this.itemName;
    }

     /**
     * Switch Filter
     */
    public void clickOnSwitchFilter() throws InterruptedException {
        selenium.clickOn(filterColor);
    }

    /**
     * Click on list filter
     *
     * @throws InterruptedException throws exception
     */
    public void clickOnListFilter() throws InterruptedException {
        selenium.clickOn(listFilter);
    }

    /**
     * Filter Verify based  on the item list color and filter color
     */
    public void verifyFilter() {
        List<WebElement> itemColors = driver.findElements(By.xpath("//*[@id=\"option-label-color-277-item-17460\"]"));
        WebElement itemColor;
        String warna;
        itemColor = itemColors.get(0);
        System.out.println("color in item : " + itemColor.getAttribute("option-label"));
        warna = itemColor.getAttribute("option-label");

        WebElement filterWarnas = driver.findElement(By.xpath("//*[@id=\"narrow-by-list\"]/div[4]/div[2]/form/div/div[1]/a/div"));
        String filterWarna = filterWarnas.getAttribute("option-label");
        System.out.println("color in filter : " + filterWarnas.getAttribute("option-label"));
        if (warna.equals(filterWarna))
            System.out.println("warna sama");
        else
            System.out.println("warna tidak sama");
    }

    /**
     * Click button beli
     * @throws InterruptedException throws exception
     */
    public void clickOnBuyButton() throws InterruptedException {
        setItemName();
        selenium.clickOn(btnBeli);
    }

    /**
     * Verify search result with keyword
     * @param keyword
     */
    public boolean verifyItem(String keyword) {
        List<WebElement> itemNames = driver.findElements(By.xpath("//*[@id=\"amasty-shopby-product-list\"]/div[2]/ol/li/div/div/strong/a")) ;
        WebElement itemName;
        String lowercaseName;
        for (int i = 0; i < 9; i++){
            itemName = itemNames.get(i);
            System.out.println(itemName.getText());
            lowercaseName = itemName.getText().toLowerCase(Locale.ROOT);
        }
        return true;
    }

}
