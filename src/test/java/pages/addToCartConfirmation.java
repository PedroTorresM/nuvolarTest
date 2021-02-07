package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class addToCartConfirmation {
    private WebDriver driver;


    //Locators

    @FindBy(how = How.ID,using = "twotabsearchtextbox")
    WebElement searchBox;

    @FindBy(how = How.ID,using = "nav-search-submit-button")
    WebElement searchButton;

    @FindBy(how = How.ID,using = "hlb-view-cart-announce")
    WebElement confirmationButton;

    //Constructor

    public addToCartConfirmation(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void newsearch(String search){
        clickOnElement(searchBox);
        sendText(searchBox,search);
        clickOnElement(searchButton);
    }

    public void clickOnElement(WebElement element){
        element.click();
    }

    public void sendText(WebElement element,String text){
        element.clear();
        element.sendKeys(text);
    }
    public void goToCart(){
        clickOnElement(confirmationButton);
    }
}
