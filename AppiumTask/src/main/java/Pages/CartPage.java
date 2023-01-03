package Pages;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.App;

import java.time.Duration;

public class CartPage {
    private WebDriver driver;
    WebDriverWait driverWait;
    private By addedItemPrice_text = AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"test-Price\"]/android.widget.TextView");
    private By addedItemTitle_text = AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"test-Description\"]/android.widget.TextView[1]");
    private By remove_button = AppiumBy.accessibilityId("test-REMOVE");
    private By cartItemsIcon_icon = AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"test-Cart\"]/android.view.ViewGroup/android.view.ViewGroup");
    private By checkout_button = AppiumBy.accessibilityId("test-CHECKOUT");

    /**
     * CartPage constructor
     * @param driver
     */

    public CartPage(WebDriver driver){
        this.driver=driver;
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    /**
     * This method returns the first item title in the cart to validate on its title later on.
     * Also waits 5 seconds or until the element(text) is visible.
     * @return a string of the element text (item title).
     */
    public String getAddedItemTitle(){
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(addedItemTitle_text));
        return driver.findElement(addedItemTitle_text).getText();
    }

    /**
     * This method returns the first item price in the cart to validate on its price later on.
     * Also waits 5 seconds or until the element(text) is visible.
     * @return a string of the element text (added item price).
     */
    public String getAddedItemPrice(){
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(addedItemPrice_text));
        return driver.findElement(addedItemPrice_text).getText();
    }
    /**
     * This method removes the first added item in the cart.
     * Also waits 5 seconds or until the element(button) is clickable.
     * @return an object of CartPage class.
     */
    public CartPage clickRemove(){
        driverWait.until(ExpectedConditions.elementToBeClickable(remove_button));
        driver.findElement(remove_button).click();
        return this;
    }
    /**
     * This method returns 0 if the added item name in the cart doesn't exist to validate on removing the item later on.
     * Also waits 5 seconds or until the element(locator) is invisible.
     * @return an int of the element size.
     */
    public int itemNameRemoved(){
        driverWait.until(ExpectedConditions.invisibilityOfElementLocated(addedItemTitle_text));
        return driver.findElements(addedItemTitle_text).size();
    }
    /**
     * This method returns 0 if the cart icon doesn't contain any numbers to validate that the cart is empty later on.
     * Also waits 5 seconds or until the element(locator) is invisible.
     * @return an int of the element size.
     */
    public int cartItemsIconEmpty()
    {
        driverWait.until(ExpectedConditions.invisibilityOfElementLocated(cartItemsIcon_icon));
        return driver.findElements(cartItemsIcon_icon).size();
    }

    /**
     * This method is redirect us to the CheckoutInformation Page by clicking on the checkout button.
     * Also waits 5 seconds or until the element(button) is clickable.
     * @return an object of the checkoutInformationPage
     */
    public CheckoutInformationPage clickCheckout(){
        driver.findElement(checkout_button).click();
        return new CheckoutInformationPage(driver);
    }
}
