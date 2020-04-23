package com.android.ebay.tests;

import com.android.ebay.config.DriverManager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.appium.java_client.AppiumDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import java.io.IOException;


public class BaseClass {
    public AppiumDriver driver;
  
    @BeforeClass
    public void setup(){
    
        try {
            driver= DriverManager.getDriver();
        }catch (IOException e){
            System.out.print(e.getMessage());
        }
    }
    @AfterClass
    public void tearDown()
    {
        driver.quit();
     }


}
