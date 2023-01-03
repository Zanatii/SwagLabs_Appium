
# SwagLabs Mobile Test

Automed test on several test cases to validate SwagLabs app functionalities 
## Test Cases

- TC#1 Login with Valid Email and password and validate that login is performed successfully.
- TC#2 Login with invalid email or password and validate the error message.
- TC#3 Add Any Item to the cart and validate that Title and price of the Item at Home page equals the item and price at the cart.
- TC#4 Validate Removing Items from the cart and validate that the cart is empty.
- TC#5 Online Ordering and complete the flow from adding element to cart till the checkout, Also Validate the price and success purchase.



## Emulator Capabilities

 - "platformName", "Android";
  -   "appium:deviceName", "Android Emulator";
   -  "appium:appWaitActivity", "com.swaglabsmobileapp.MainActivity";
   -   "appium:platformVersion", "11.0";
   -   "appium:automationName", "UiAutomator2";
## Required Enviroments/Installation

 - Andriod Studio 
 -   Node.js
 - Appium Server
 - Appium Inspector
