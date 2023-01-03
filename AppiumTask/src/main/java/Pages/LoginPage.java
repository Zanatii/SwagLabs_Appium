package Pages;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    WebDriverWait driverWait;
    private By userName_edit = AppiumBy.accessibilityId("test-Username");
    private By password_edit = AppiumBy.accessibilityId("test-Password");
    private By login_button = AppiumBy.accessibilityId("test-LOGIN");
    private By errorMessage_text = AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"test-Error message\"]/android.widget.TextView");

    /**
     * LoginPage class constructor.
     * @param driver an object of Webdriver class.
     */
    public LoginPage(WebDriver driver){
        this.driver=driver;
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    /**
     * This method sends the desired string to the username edit field locator.
     * Also waits 5 seconds or until the element(edit field) is visible.
     * @param userName The user's account name.
     * @return an object of LoginPage class.
     */
    public LoginPage enterUserName(String userName){
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(userName_edit));
        driver.findElement(userName_edit).sendKeys(userName);
        return this;
    }

    /**
     * This method sends the desired string to the password edit field locator.
     * Also waits 5 seconds or until the element(edit field) is visible.
     * @param password The user's account password.
     * @return an object of LoginPage class.
     */
    public LoginPage enterPassword(String password){
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(password_edit));
        driver.findElement(password_edit).sendKeys(password);
        return this;
    }

    /**
     * This method is for clicking on the login button after inserting the user credentials.
     * Also waits 5 seconds or until the element(button) is clickable.
     * @return an object of HomePage class.
     */
    public HomePage clickLogin(){
        driverWait.until(ExpectedConditions.elementToBeClickable(login_button));
        driver.findElement(login_button).click();
        return new HomePage(driver);
    }

    /**
     * This method is for returning the error message after entering invalid credentials.
     * Also waits 5 seconds or until the element(message) is visible.
     * @return a string of the invalid credentials error message.
     */
    public String getErrorMessage(){
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage_text));
        return driver.findElement(errorMessage_text).getText();
    }
}
