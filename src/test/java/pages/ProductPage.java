package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.math.BigDecimal;

public class ProductPage {
    private WebDriver driver;


    //Locators

    @FindBy(how = How.ID,using = "twotabsearchtextbox")
    WebElement searchBox;

    @FindBy(how = How.ID,using = "nav-search-submit-button")
    WebElement searchButton;

    @FindBy (how = How.XPATH,using = "//span[@id='a-autoid-9-announce']")
    WebElement quantityDropdown;

    @FindBy (how = How.XPATH,using = "//a[@id='quantity_1']")
    WebElement quantity2Selector;

    @FindBy (how = How.XPATH,using = "//input[@id='add-to-cart-button']")
    WebElement addToCartButton;

    @FindBy (how = How.XPATH,using = "//span[@id='priceblock_ourprice']")
    WebElement productPrice;

    //Constructor

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void clickOnElement(WebElement element){
        element.click();
    }

    public void sendText(WebElement element,String text){
        element.clear();
        element.sendKeys(text);
    }

    public void newsearch(String search){
        clickOnElement(searchBox);
        sendText(searchBox,search);
        clickOnElement(searchButton);
    }

    public boolean isPageOpened(String title){
        return driver.getTitle().contains(title);
    }

    public String savePrice(WebElement element){
        String savedPrice = "";
        savedPrice = element.getText();
        return savedPrice;
    }
    public double catchPrice(){
        String unformattedPrice = savePrice(productPrice);
        double price = convertPrice(unformattedPrice);
        return  price;
    }
    public void addToCart(){
        clickOnElement(quantityDropdown);
        clickOnElement(quantity2Selector);
        clickOnElement(addToCartButton);
    }

    public void addToCartSimple(){
        clickOnElement(addToCartButton);
    }


    public double convertPrice(String unformattedPrice){
        String salePrice = unformattedPrice;
        String price = salePrice.replace("$","");
        //price = salePrice.replace(" ","");
        BigDecimal sPrice = new BigDecimal(price);
        double dPrice = sPrice.doubleValue();
        return dPrice;
    }
}
