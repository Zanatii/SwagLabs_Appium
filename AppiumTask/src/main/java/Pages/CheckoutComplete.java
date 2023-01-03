package Pages;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutComplete {
    WebDriver driver;
    WebDriverWait driverWait;
    private By thankYou_text = AppiumBy.xpath("//android.widget.TextView[@text=\"THANK YOU FOR YOU ORDER\"]");

    /**
     * CheckoutComplete constructor
     * @param driver
     */
    public CheckoutComplete(WebDriver driver){
        this.driver = driver;
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    /**
     * This method returns the string of the order confirmation message to validate on the successful order later on.
     * Also waits 5 seconds or until the element(text) is visible.
     * @return a string of the element text (Thank you)
     */
    public String getOrderConfirmation(){
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(thankYou_text));
        return driver.findElement(thankYou_text).getText();
    }
}
