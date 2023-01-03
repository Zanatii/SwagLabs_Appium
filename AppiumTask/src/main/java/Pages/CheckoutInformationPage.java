package Pages;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutInformationPage {
    WebDriver driver;
    WebDriverWait driverWait;
    private By firstName_edit = AppiumBy.accessibilityId("test-First Name");
    private By lastName_edit = AppiumBy.accessibilityId("test-Last Name");
    private By zipCode_edit = AppiumBy.accessibilityId("test-Zip/Postal Code");
    private By continue_button = AppiumBy.accessibilityId("test-CONTINUE");
    /**
     * CheckoutInformation class constructor
     * @param driver
     */
    public CheckoutInformationPage(WebDriver driver){
        this.driver = driver;
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }
    /**
     * This method sends the desired string to the first name edit field locator.
     * Also waits 5 seconds or until the element(edit field) is visible.
     * @param firstName The user's account password.
     * @return an object of CheckoutInformationPage class.
     */
    public CheckoutInformationPage enterFirstName(String firstName){
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(firstName_edit));
        driver.findElement(firstName_edit).sendKeys(firstName);
        return this;
    }
    /**
     * This method sends the desired string to the last name edit field locator.
     * Also waits 5 seconds or until the element(edit field) is visible.
     * @param lastName The user's account password.
     * @return an object of CheckoutInformationPage class.
     */
    public CheckoutInformationPage enterLastName(String lastName){
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(lastName_edit));
        driver.findElement(lastName_edit).sendKeys(lastName);
        return this;
    }
    /**
     * This method sends the desired string to the zip/postal code edit field locator.
     * Also waits 5 seconds or until the element(edit field) is visible.
     * @param zipCode The user's account password.
     * @return an object of CheckoutInformationPage class.
     */
    public CheckoutInformationPage zipCode_edit(String zipCode){
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(zipCode_edit));
        driver.findElement(zipCode_edit).sendKeys(zipCode);
        return this;
    }
    /**
     * This method is for clicking on the continue button after inserting the checkout information.
     * Also waits 5 seconds or until the element(button) is clickable.
     * @return an object of CheckoutOverview class.
     */
    public CheckoutOverview clickContinue(){
        driverWait.until(ExpectedConditions.elementToBeClickable(continue_button));
        driver.findElement(continue_button).click();
        return new CheckoutOverview(driver);
    }
}
