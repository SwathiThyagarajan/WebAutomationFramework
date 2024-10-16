package com.thetestingacademy.base;

import com.thetestingacademy.driver.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class commonToAllTests {

    // we will use the above commonToAllTest for
    // 1. To call the Start the Webdriver
    // 2. Down the WebDriver
    // 3. Start Webdirver

    // before any method or test starts we want to do a setup of driver
    @BeforeMethod
    public void setUp(){
        DriverManager.init();// this will start the driver before any method

    }

    // after any method I want to tearDown/ close the driver
    @AfterMethod
    public void tearDown(){
        DriverManager.down();
    }
}
