package Tests;

import Pages.CartPage;
import Pages.HomePage;
import Pages.LoginPage;
import com.shaft.driver.SHAFT;
import io.appium.java_client.android.AndroidDriver;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.net.MalformedURLException;
import java.net.URL;

public class AddRemoveItems {
    WebDriver driver;
    SoftAssert softAssert;
    SHAFT.TestData.JSON testData;

    /**
     * Before class method for setting the desired capabilities and successful logging with valid credentials.
     * @throws MalformedURLException
     */

    @BeforeClass
    public void setupDevice() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("appium:deviceName", "Android Emulator");
        caps.setCapability(  "appium:appWaitActivity", "com.swaglabsmobileapp.MainActivity");
        caps.setCapability("appium:app", "C:\\Users\\MohsenM5\\Downloads\\Android.SauceLabs.Mobile.Sample.app.2.2.0.apk");
        caps.setCapability("appium:platformVersion", "11.0");
        caps.setCapability("appium:automationName", "UiAutomator2");
        driver = new AndroidDriver(new URL("http://localhost:4723/"), caps);
        softAssert = new SoftAssert();
        testData = new SHAFT.TestData.JSON("src/test/resources/testDataFiles/testData.json");
        new LoginPage(driver)
                .enterUserName(testData.getTestData("username"))
                .enterPassword(testData.getTestData("password"))
                .clickLogin();
    }

    /**
     * test case for validating that Title and price of the Item at Home page equals the title and price at the cart.
     * add the first item to the cart and put the home page item title and price in two strings (title,price).
     * click on the cart icon and redirect to the cart page
     * put the first added cart item title and price in another two strings (title2, prices).
     * assert that title and title2 are equal.
     * assert that price and price2 are equal.
     */
    @Test
    public void validateItemAdded(){
        String title = new HomePage(driver)
                .clickAddToCart()
                .getItemTitle();
        String price = new HomePage(driver)
                .getItemPrice();
        String title2 = new HomePage(driver)
                .clickCartIcon()
                .getAddedItemTitle();
        String price2 = new CartPage(driver).getAddedItemPrice();
        softAssert.assertEquals(title,title2);
        softAssert.assertEquals(price,price2);
        softAssert.assertAll();
    }

    /**
     * test case for Validating on Removing Items from the cart and validate that the cart is empty
     * click remove button on the added item put the item name size (which is 0 if it doesn't exist) in removed variable.
     * put the cart icon number size (which is 0 if it doesn't exist) in empty variable.
     * assert that both variables contains 0.
     */
    @Test
    public void validateItemRemoved_EmptyCart(){
        int removed = new CartPage(driver).clickRemove().itemNameRemoved();
        int empty = new CartPage(driver).cartItemsIconEmpty();
        softAssert.assertEquals(removed,0);
        softAssert.assertEquals(empty,0);
        softAssert.assertAll();
    }
}
