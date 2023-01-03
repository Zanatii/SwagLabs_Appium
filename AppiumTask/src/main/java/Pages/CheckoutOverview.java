package Pages;

import Actions.MobileActions;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutOverview {
    WebDriver driver;
    WebDriverWait driverWait;
    private By itemPrice_text = AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"test-Price\"]/android.widget.TextView");
    private By finish_button = AppiumBy.accessibilityId("test-FINISH");

    /**
     * CheckoutOverview class constructor
     * @param driver
     */
    public CheckoutOverview(WebDriver driver){
        this.driver = driver;
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        new MobileActions(driver);
    }

    /**
     * This method returns the price of the first item in the checkout overview to validate on the price later on.
     * Also waits 5 seconds or until the element(text) is visible.
     * @return a string of the element text (item price).
     */
    public String getItemPrice(){
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(itemPrice_text));
        return driver.findElement(itemPrice_text).getText();
    }

    /**
     * This method scrolls down to the FINISH button and then redirect to the checkout complete page by clicking on finish button.
     * Also waits 5 seconds or until the element(button) is clickable.
     * @return an object of CheckoutComplete class
     */
    public CheckoutComplete clickFinish(){
        MobileActions.scrollDownToSpecificText("FINISH");
        driverWait.until(ExpectedConditions.elementToBeClickable(finish_button));
        driver.findElement(finish_button).click();
        return new CheckoutComplete(driver);
    }

}
