package com.android.ebay.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

import com.android.ebay.config.ScrollElement;

/**
 * This class describes location the elements on search result page and add it to the cart
 * @author sourabh.g
 *
 */
public class AddProductToCart {
    AndroidDriver driver;
    public AddProductToCart(AndroidDriver ldriver)
    {
        this.driver=ldriver;
    }

    @AndroidFindBy(id = "com.ebay.mobile:id/search_box")
    public WebElement SearchBox;

    @AndroidFindBy(id="com.ebay.mobile:id/search_src_text")
    public WebElement SearchInText;

    @AndroidFindBy(xpath = ".//*[@text='Samsung QN65Q70RAFXZA Flat 65-Inch QLED 4K Q70 Series Ultra HD Smart TV with HDR']")
    private WebElement Product;

    @AndroidFindBy(id="com.ebay.mobile:id/button_add_to_cart")
    public WebElement AddToCartButton;

    @AndroidFindBy(id="com.ebay.mobile:id/fragmentContainer")
    public MobileElement ProductContainer;

    @AndroidFindBy(id="com.ebay.mobile:id/top_scrollview_content")
    public MobileElement ScrollinProductPage;

    String str="ADD TO CART";
    String Item="65 inch TV";


    public void SearchBox()
    {
        System.out.println("Click button or tap on screen");
        try {
            Thread.sleep(3000);
            SearchBox.click();
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Search button clicked");
    }

    public void SearchItemFromSearchBox()
    {
        System.out.println("In search bar searching the Item for purchase");
        SearchInText.sendKeys("65 inch TV");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.pressKeyCode(AndroidKeyCode.KEYCODE_PAGE_DOWN);
        driver.pressKeyCode(AndroidKeyCode.ENTER);
    }

    public boolean SelectProduct()
    {
        System.out.println("In select product");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        MobileElement ProductFromList=ScrollElement.scrollToExactElement(ProductContainer,Item);
        ProductFromList.click();
        System.out.println("In product buy page");
        MobileElement AddToCartID=ScrollElement.ScrollToElement(ScrollinProductPage,str);
        AddToCartID.click();
        System.out.println("Product Added to cart succesfully");
        return true;

    }



}
