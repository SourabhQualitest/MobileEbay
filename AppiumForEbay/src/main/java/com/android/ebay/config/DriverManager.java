package com.android.ebay.config;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

import org.openqa.selenium.remote.DesiredCapabilities;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;


/**
 * This calls sets the capabilities for android device and return driver instance
 * @author sourabh.g
 *
 */
public class DriverManager {


    public static AndroidDriver driver;
    public static Properties prop = new Properties();
    static InputStream input = null;
   

    public static AndroidDriver getDriver() throws IOException {
    	input = new FileInputStream("property/android.properties");
    	prop.load(input);
    	androidSetup();

    	return driver;
    }

    public static AndroidDriver androidSetup() throws MalformedURLException {
        System.out.println("Setting Android Driver");
        DesiredCapabilities caps = new DesiredCapabilities();
    	caps.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel_2_API_29");
		caps.setCapability(MobileCapabilityType.APP, "C:\\Users\\sourabh.g\\Downloads\\original.apk");
        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        System.out.println("Android Driver set succesfully");
        return driver;
    }
 

}
