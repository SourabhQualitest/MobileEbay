package com.android.ebay.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import static com.android.ebay.config.DriverManager.prop;

/**
 * This class contains the login functionality elements and methods to login
 * @author sourabh.g
 *
 */
public class LoginPage {

    AndroidDriver driver;

    public  LoginPage(AndroidDriver driver)
    {
        this.driver=driver;
    }

    @AndroidFindBy(id="com.ebay.mobile:id/edit_text_username")
    private WebElement username;

    @AndroidFindBy(id="com.ebay.mobile:id/edit_text_password")
    private WebElement password;

    @AndroidFindBy(id="com.ebay.mobile:id/button_sign_in")
    private WebElement SignInButton;

    public AddProductToCart LoginInApp()
    {
        System.out.println("In Sign in Frame");
        driver.hideKeyboard();
        System.out.println("Entering Username");
        username.sendKeys(prop.getProperty("Username"));
        System.out.println("Entering password");
        password.sendKeys(prop.getProperty("Password"));
        SignInButton.click();
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.pressKeyCode(AndroidKeyCode.KEYCODE_DPAD_DOWN);
        System.out.println("Keypad down pressed");
        driver.pressKeyCode(AndroidKeyCode.ENTER);
        System.out.println("Clicked Enter");
        System.out.println("Signed succesfully in app");
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new AddProductToCart(driver);
    }
}
