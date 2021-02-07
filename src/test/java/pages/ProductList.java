package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.locators.RelativeLocator;

public class ProductList {
    private WebDriver driver;


    //Locators

    @FindBy(how = How.ID,using = "twotabsearchtextbox")
    WebElement searchBox;

    @FindBy(how = How.ID,using = "nav-search-submit-button")
    WebElement searchButton;

   // @FindBy (how = How.XPATH,using = "//div[@data-index='1']/div/span/div/div/span/a/div/img")
    //WebElement productResult;
    @FindBy (how = How.XPATH,using = "//*[@data-image-index='2']")
    WebElement productResult;



    //Constructor

    public ProductList(WebDriver driver) {
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
    public void clickResult(){
        clickOnElement(productResult);

    }

    public void newsearch(String search){
        clickOnElement(searchBox);
        sendText(searchBox,search);
        clickOnElement(searchButton);
    }


    public boolean isPageOpened(String title){
        return driver.getTitle().contains(title);
    }
}
