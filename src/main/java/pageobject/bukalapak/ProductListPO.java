package pageobject.bukalapak;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import utilities.SeleniumHelpers;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ProductListPO {
    WebDriver driver;
    SeleniumHelpers selenium;
    String productName;
    String sortingType;
    List<String> productNames = new ArrayList<>();

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

    @FindBy(xpath = "//p[@class='bl-dropdown__label bl-text bl-text--body-default bl-text--ellipsis__1']")
    private WebElement dropdownSorting;

    @FindBy(xpath = "//div[@class='bl-flex-container flex-wrap is-gutter-16']/div[1]/div/div/div[3]/div/button")
    private WebElement addToCartButton;

    @FindBy(xpath = "//div[@class='bl-flex-container flex-wrap is-gutter-16']/div[1]/div")
    private WebElement productCard;

    @FindBy(xpath = "//div[@class='bl-flex-item mb-8'][1]//div[@class='bl-product-card__description-name']//a")
    private WebElement product;

    @FindBy(xpath = "//div[@class='ml-4 bl-emblem bl-emblem--bukamall_icon te-bukamall_icon']")
    private WebElement iconBukamall;

    /**
     * Select sorting
     * @param type sorting type. available options: termurah, termahal, terlaris
     * @throws InterruptedException throws exception
     */
    public void selectSorting(String type) throws InterruptedException {
        selenium.clickOn(dropdownSorting);
        type = type.toLowerCase(Locale.ROOT);
        this.setSortingType(type);
        WebElement sortingOption = null;
        switch (type) {
            case "termurah":
                sortingOption = driver.findElement(By.xpath("//p[@class='bl-text bl-text--body-default bl-text--ellipsis__1'][contains(text(),'Termurah')]"));
                break;
            case "termahal":
                sortingOption = driver.findElement(By.xpath("//p[@class='bl-text bl-text--body-default bl-text--ellipsis__1'][contains(text(),'Termahal')]"));
                break;
            case "terlaris":
                sortingOption = driver.findElement(By.xpath("//p[@class='bl-text bl-text--body-default bl-text--ellipsis__1'][contains(text(),'Terlaris')]"));
                break;
        }
        selenium.clickOn(sortingOption);
    }

    /**
     * Hover product
     */
    public void hoverProduct() {
        selenium.hoverElement(productCard);
    }

    /**
     * Click on the first item
     */
    public void clickOnFirstItem() {
        setProductName();
        WebElement productLink = driver.findElement(By.xpath("//div[@class='bl-flex-item mb-8'][1]/*//p/a"));
        productLink.click();
    }

    /**
     * Click add to cart button
     * @throws InterruptedException throws exception
     */
    public void clickAddToCart() throws InterruptedException {
        hoverProduct();
        selenium.clickOn(addToCartButton);
        setProductName();
    }

    /**
     * Set sorting type
     * @param type sorting type
     */
    public void setSortingType(String type) {
        this.sortingType = type;
    }

    /**
     * Get sorting type
     */
    public String getSortingType() {
        return this.sortingType;
    }

    /**
     * Set product name
     */
    public void setProductName() {
        this.productName = product.getText();
    }

    /**
     * Get product name
     */
    public String getProductName() {
        return this.productName;
    }

    /**
     * Add product name
     */
    public void addProductName(){
        this.productNames.add(product.getText());
    }

    /**
     * Get product name array
     */
    public List<String> getProductNames(){
        return productNames;
    }

    /**
     * Verify icon Bukamall is displayed
     */
    public boolean verifyIconBukamall() {
        return selenium.isElementAppeared(iconBukamall);
    }

    /**
     * Verify search result with keyword
     * @param keyword search input keyword
     */
    public boolean verifySearchResultWithKeyword(String keyword) {
        List<WebElement> productnames = driver.findElements(By.xpath("//div[@class='bl-flex-container flex-wrap is-gutter-16']/div//div[@class='bl-product-card__description-name']//a"));
        WebElement productName;
        String lowercaseName;
        for (int i = 0; i < 9; i++) {
            productName = productnames.get(i);
            System.out.println(productName.getText());
            lowercaseName = productName.getText().toLowerCase(Locale.ROOT);
            keyword = keyword.toLowerCase(Locale.ROOT);
            if(!lowercaseName.contains(keyword)){
                return false;
            }
//            Assert.assertTrue(lowercaseName.contains(keyword));
        }
        return true;
    }

    /**
     * Verify product sorting
     */
    public boolean verifyProductSorting() {
        String type = this.getSortingType();
        List<WebElement> products;
        int cmp1, cmp2, flag=0;
        switch (type) {
            case "termurah":
                products = driver.findElements(By.xpath("//div[@class='bl-flex-item mb-8']/*//p[@class='bl-text bl-text--subheading-2 bl-text--semi-bold bl-text--ellipsis__1']"));
                for (int i = 0; i < products.size() - 1; i++) {
                    if (!products.get(i).getText().equals(products.get(i + 1).getText())) {
                        cmp1 = Integer.parseInt(products.get(i).getText().trim().substring(2).replace(".", ""));
                        cmp2 = Integer.parseInt(products.get(i + 1).getText().trim().substring(2).replace(".", ""));
                        if (cmp1 > cmp2) {
                            flag = 1;
//                            Assert.fail();
                        }
                    }
                }
                break;
            case "termahal":
                products = driver.findElements(By.xpath("//div[@class='bl-flex-item mb-8']/*//p[@class='bl-text bl-text--subheading-2 bl-text--semi-bold bl-text--ellipsis__1']"));
                for (int i = 0; i < products.size() - 1; i++) {
                    if (!products.get(i).getText().equals(products.get(i + 1).getText())) {
                        cmp1 = Integer.parseInt(products.get(i).getText().trim().substring(2).replace(".", ""));
                        cmp2 = Integer.parseInt(products.get(i + 1).getText().trim().substring(2).replace(".", ""));
                        if (cmp1 < cmp2) {
                            flag = 1;
//                            Assert.fail();
                        }
                    }
                }
                break;
            case "terlaris":
                products = driver.findElements(By.xpath("//div[@class='bl-flex-item mb-8']//div[2]/div/p[contains(text(), 'Terjual')]"));
                for (int i = 0; i < products.size() - 1; i++) {
                    if (!products.get(i).getText().equals(products.get(i + 1).getText())) {
                        cmp1 = Integer.parseInt(products.get(i).getText().trim().substring(8));
                        cmp2 = Integer.parseInt(products.get(i + 1).getText().trim().substring(8));
                        if (cmp1 < cmp2) {
                            flag = 1;
//                            Assert.fail();
                        }
                    }
                }
                break;
        }
        return flag != 1;
    }
}
