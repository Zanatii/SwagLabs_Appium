package Pages;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private WebDriver driver;
    WebDriverWait driverWait;
    private By products_text = AppiumBy.xpath("//android.widget.TextView[@text=\"PRODUCTS\"]");
    private By addToCart_button = AppiumBy.xpath("(//android.view.ViewGroup[@content-desc=\"test-ADD TO CART\"])[1]");
    private By itemPrice_text = AppiumBy.xpath("(//android.widget.TextView[@content-desc=\"test-Price\"])[1]");
    private By itemTitle_text = AppiumBy.xpath("(//android.widget.TextView[@content-desc=\"test-Item title\"])[1]");
    private By cartIcon_button = AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"test-Cart\"]/android.view.ViewGroup/android.widget.ImageView");

    /**
     * HomePage class constructor.
     * @param driver an object of Webdriver class.
     */
    public HomePage(WebDriver driver){
        this.driver=driver;
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }
    /**
     * This method returns the element text used for validating the current page.
     * Also waits 5 seconds or until the element(text) is visible.
     * @return a string of the element text (PRODUCTS).
     */
    public String getProductsText(){
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(products_text));
        return  driver.findElement(products_text).getText();
    }

    /**
     * This method is for adding the first item in the homepage to the cart by clicking on add to cart.
     * Also waits 5 seconds or until the element(button) is clickable.
     * @return an object of HomePage class
     */
    public HomePage clickAddToCart(){
        driverWait.until(ExpectedConditions.elementToBeClickable(addToCart_button));
        driver.findElement(addToCart_button).click();
        return this;
    }

    /**
     * This method returns the first item price to validate on the price later on.
     * Also waits 5 seconds or until the element(text) is visible.
     * @return a string of the element text (item price).
     */
    public String getItemPrice(){
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(itemPrice_text));
        return driver.findElement(itemPrice_text).getText();
    }
    /**
     * This method returns the first item title to validate on the title later on.
     * Also waits 5 seconds or until the element(text) is visible.
     * @return a string of the element text (item title).
     */
    public String getItemTitle(){
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(itemTitle_text));
        return driver.findElement(itemTitle_text).getText();
    }

    /**
     * This method is for redirecting to the cart page by clicking on the cart icon.
     * Also waits 5 seconds or until the element(button) is clickable.
     * @return an object of the CartPage class
     */
    public CartPage clickCartIcon(){
        driverWait.until(ExpectedConditions.elementToBeClickable(cartIcon_button));
        driver.findElement(cartIcon_button).click();
        return new CartPage(driver);
    }
}
