package com.android.ebay.tests;

import org.testng.annotations.Test;

import com.android.ebay.config.DriverManager;
import com.android.ebay.pages.AddProductToCart;
import com.android.ebay.pages.LoginPage;
import com.android.ebay.pages.WelcomePage;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class EbayFlowTillAddCart extends BaseClass{

    DriverManager driverManager;
    WelcomePage welcomepage;
    LoginPage loginPage;
    AddProductToCart addProductToCart;
    AndroidDriver driver;
    boolean status=true;

    @Test
    public void SelectItems() throws InterruptedException, IOException
    {
        System.out.println("Add product TestLo gin and add product you cart");
        driver=DriverManager.getDriver();
        welcomepage = new WelcomePage(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver),welcomepage);
        System.out.println("Opening app on device");
        System.out.println("Waiting for app to load device");
        welcomepage.waitForAppToLoadLogo();
        System.out.println("Clicking on Sign in Button");
        welcomepage.ClickOnSignIn();
        //Assert.assertTrue(status);
       loginPage=new LoginPage(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver),loginPage);
        System.out.println("Performing login action");
        loginPage.LoginInApp();
        System.out.println("Login succesfull");
        addProductToCart=new AddProductToCart(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver),addProductToCart);
        System.out.println("Clicking on Search box for product search");
        addProductToCart.SearchBox();
        System.out.println("Searched Item in search box");
        addProductToCart.SearchItemFromSearchBox();
        System.out.println("Add product to cart");
        addProductToCart.SelectProduct();
        System.out.println("Product Added in Cart sucessfully");
    }

}
