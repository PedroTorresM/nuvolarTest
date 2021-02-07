package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

public class cartPage {
    private WebDriver driver;


    //Locators

    @FindBy(how = How.ID,using = "twotabsearchtextbox")
    WebElement searchBox;

    @FindBy(how = How.ID,using = "nav-search-submit-button")
    WebElement searchButton;

    @FindBy (how = How.XPATH,using = "//span[@id='a-autoid-2-announce']")
    WebElement product1quantityDropdown;

    @FindBy (how = How.XPATH,using = "//span[@id='a-autoid-0-announce']")
    WebElement product2quantityDropdown;

    @FindBy (how = How.XPATH,using = "//a[@id='sc-update-quantity-select_1']")
    WebElement product1quantity1Selector;

    @FindBy (how = How.XPATH,using = "//span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap sc-product-price a-text-bold']")
    WebElement product1Price;

    @FindBy (how = How.XPATH,using = "//div[@id='sc-item-C2b020214-354f-4017-b50f-c4d9b02b4ed7']/div[@class='sc-list-item-content' and 4]/div[@class='a-row a-spacing-base a-spacing-top-base' and 1]/div[2]/p[@class='a-spacing-small' and 1]/span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap sc-product-price a-text-bold' and 1]")
    WebElement product2Price;

    @FindBy (how = How.ID,using = "sc-subtotal-amount-activecart")
    WebElement totalPrice;
    //Constructor

    public cartPage(WebDriver driver) {
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
    public double catchProduct1Price(){
        String unformattedPrice = savePrice(product1Price);
        double price = convertPrice(unformattedPrice);
        return  price;
    }
    public double catchProduct2Price(){
        String unformattedPrice = savePrice(product2Price);
        double price = convertPrice(unformattedPrice);
        return  price;
    }

    public double catchTotalPrice(){
        String unformattedPrice = savePrice(totalPrice);
        double price = convertPrice(unformattedPrice);
        return  price;
    }

    public void modifyQuantityProduct1(){

            clickOnElement(product1quantityDropdown);
            clickOnElement(product1quantity1Selector);
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
