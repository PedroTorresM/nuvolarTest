package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.*;

import java.util.concurrent.TimeUnit;

public class AmznCartTest {

    // Config parameters
    private String PATHDRIVER = "src/test/resources/drivers/";
    private String baseURL = "https://www.amazon.com/";
    WebDriver driver;

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver",PATHDRIVER+"chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--incognito");
        driver = new ChromeDriver(options);
    }
    @Test
    public void amazonCartTest() throws InterruptedException {
        //initialize variables
        double product1Quantity = 2;
        double product2Quantity = 1;
        //Create page objects
        FrontPage frontPage = new FrontPage(driver);
        ProductList productList = new ProductList(driver);
        ProductPage productpage = new ProductPage(driver);
        addToCartConfirmation addtocartconfirmation = new addToCartConfirmation(driver);
        cartPage cartpage = new cartPage(driver);


        //1. Go to https://www.amazon.com
        driver.get(baseURL);

        //2. Search for "hats for men"
        frontPage.newsearch("hats for men");
        Assert.assertTrue(productList.isPageOpened("Amazon.com : hats for men"));

        //3. Add first hat to Cart with quantity 2
        productList.clickResult();
        double priceProduct1 = productpage.catchPrice();
        double finalPrice1 = priceProduct1 * product1Quantity;
        productpage.addToCart();

        //4. Open cart and assert total price and quantity are correct
        addtocartconfirmation.goToCart();
        Assert.assertEquals(cartpage.catchProduct1Price(),priceProduct1,0);
        Assert.assertEquals(cartpage.catchTotalPrice(),finalPrice1,0);

        //5. Search for "hats for women"
        cartpage.newsearch("hats for women");

        //6. Add first hat to Cart with quantity 1
        productList.clickResult();
        double priceProduct2 = productpage.catchPrice();
        double finalPrice2 = finalPrice1 + priceProduct2;
        productpage.addToCartSimple();

        //7. Open cart and assert total price and quantity are correct
        addtocartconfirmation.goToCart();
        Assert.assertEquals(cartpage.catchProduct1Price(),priceProduct2,0);
        Assert.assertEquals(cartpage.catchTotalPrice(),finalPrice2,0);

        //8. Change the quantity for item selected at step 3 from 2 to 1 item in Cart
        cartpage.modifyQuantityProduct1();
        TimeUnit.SECONDS.sleep(2); //adding some time to render the new price

        //9. Assert total price and quantity are changed correctly
        double finalPrice3 = finalPrice2 - priceProduct1;
        Assert.assertEquals(cartpage.catchTotalPrice(),finalPrice3,0);

    }
    @After
    public void close(){
        driver.close();
    }
}