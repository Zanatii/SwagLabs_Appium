package Tests;

import Pages.LoginPage;
import com.shaft.driver.SHAFT;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class LoginTests {
    WebDriver driver;
    SHAFT.TestData.JSON testData;

    /**
     * Before class method for setting the desired capabilities.
     * @throws MalformedURLException
     */
    @BeforeMethod
    public void setupDevice() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("appium:deviceName", "Android Emulator");
        caps.setCapability(  "appium:appWaitActivity", "com.swaglabsmobileapp.MainActivity");
        caps.setCapability("appium:app", "C:\\Users\\MohsenM5\\Downloads\\Android.SauceLabs.Mobile.Sample.app.2.2.0.apk");
        caps.setCapability("appium:platformVersion", "11.0");
        caps.setCapability("appium:automationName", "UiAutomator2");
        driver = new AndroidDriver(new URL("http://localhost:4723/"), caps);
        testData = new SHAFT.TestData.JSON("src/test/resources/testDataFiles/testData.json");
    }

    /**
     * Test case Login with Valid Email and password and validate that login is performed successfully.
     * get the username from the test data json file and insert it in the username field.
     * get the password from the test data json file and insert it in the password field.
     * click login button and get redirect to the homepage.
     * assert that the PRODUCTS title exists (which is on the homepage).
     */
    @Test
    public void validateLoginSuccess(){
        String text = new LoginPage(driver)
                .enterUserName(testData.getTestData("username"))
                .enterPassword(testData.getTestData("password"))
                .clickLogin()
                .getProductsText();
        Assert.assertEquals(text,"PRODUCTS");
    }
    /**
     * Test case Login with invalid Email or password and validate the error message.
     * get the username from the test data json file and insert it in the username field.
     * get the invalid password from the test data json file and insert it in the password field.
     * click login button and get the error message.
     * assert that the error message is equal to the expected message.
     */
    @Test
    public void validateInvalidLoginMessage(){
        new LoginPage(driver)
                .enterUserName(testData.getTestData("username"))
                .enterPassword(testData.getTestData("invalidPassword"))
                .clickLogin();
        String text = new LoginPage(driver).getErrorMessage();
        Assert.assertEquals(text,"Username and password do not match any user in this service.");
    }
}
