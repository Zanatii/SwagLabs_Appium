package Tests;

import Pages.CartPage;
import Pages.CheckoutOverview;
import Pages.LoginPage;
import com.shaft.driver.SHAFT;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.net.MalformedURLException;
import java.net.URL;

public class OnlineOrdering {
    WebDriver driver;
    SoftAssert softAssert;
    SHAFT.TestData.JSON testData;

    /**
     * Before class method for setting the desired capabilities and successful logging with valid credentials.
     * add the first homepage item to the cart and click on the cart icon.
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
        testData = new SHAFT.TestData.JSON("src/test/resources/testDataFiles/testData.json");
        softAssert = new SoftAssert();
        new LoginPage(driver)
                .enterUserName(testData.getTestData("username"))
                .enterPassword(testData.getTestData("password"))
                .clickLogin()
                .clickAddToCart()
                .clickCartIcon();
    }
    @Test
    /**
     * Online Ordering and complete the flow from adding element to cart till the checkout, Also Validate the price and success purchase.
     * put the added price into variable (price)
     * click checkout
     * get the firstname from the test data json file and insert it in the firstname field.
     * get the lastname from the test data json file and insert it in the lastname field.
     * get the zipcode from the test data json file and insert it in the zipcode field.
     * click continue
     * put the cart item price into variable (price2).
     * assert that price and price2 are equal.
     * click finish button and get redirected to the checkout complete page.
     * put the order confirmation in variable (orderConfirm).
     * assert that the orderConfirm contains the required data.
     */
    public void validateItemPriceSuccessPurchase()
    {
        String price = new CartPage(driver)
                .getAddedItemPrice();
        String price2 = new CartPage(driver)
                .clickCheckout()
                .enterFirstName(testData.getTestData("firstName"))
                .enterLastName(testData.getTestData("lastName"))
                .zipCode_edit(testData.getTestData("zipCode"))
                .clickContinue()
                .getItemPrice();
        softAssert.assertEquals(price,price2);
        String orderConfirm = new CheckoutOverview(driver)
                .clickFinish()
                .getOrderConfirmation();
        softAssert.assertEquals(orderConfirm,"THANK YOU FOR YOU ORDER");
        softAssert.assertAll();
    }
}
