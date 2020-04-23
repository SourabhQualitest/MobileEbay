package com.android.ebay.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.android.ebay.config.ScrollElement;

/**
 * This page contains welcome page details
 * @author sourabh.g
 *
 */
public class WelcomePage {
    AndroidDriver driver;
    ScrollElement scrollElement;
    public WelcomePage(AndroidDriver ldriver)
    {
        this.driver=ldriver;
    }

    @AndroidFindBy(id = "com.ebay.mobile:id/button_sign_in")
    public WebElement SignInWelcomePage;

    @AndroidFindBy(id="com.ebay.mobile:id/textview_deals")
    public  WebElement FeaturedDeals;


    public void waitForAppToLoadLogo()
    {
    	System.out.println("Waiting for App to load");
    	WebDriverWait wait = new WebDriverWait(driver, 30);
    	wait.until(ExpectedConditions.elementToBeClickable(FeaturedDeals));
    	try {
    		Thread.sleep(5000);
    	} catch (InterruptedException e) {
    		e.printStackTrace();
    	}
    	System.out.println("App to loaded successfully");

    }

    public LoginPage ClickOnSignIn()
    {
        System.out.println("Click on Sign in button");
        try {
            SignInWelcomePage.click();
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Clicked on Sign in button");
        return new LoginPage(driver);
    }


}
