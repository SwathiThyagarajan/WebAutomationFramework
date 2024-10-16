package com.thetestingacademy.Tests;

import com.thetestingacademy.base.commonToAllTests;
import com.thetestingacademy.pages.PageFactory.LoginPage_PageFactory;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import static com.thetestingacademy.driver.DriverManager.driver;

public class TestVWOLogin_PF_DM extends commonToAllTests {

    private static final Logger logger = LogManager.getLogger(TestVWOLogin_PF_DM.class);

    // this is page factory with driver manager
    @Test
    public void testLoginVWONegative() throws FileNotFoundException {
        logger.info("Starting Test");

        // driver initialization is the 1st function which will be executed before running any testcase
        LoginPage_PageFactory loginPage_pageFactory = new LoginPage_PageFactory(driver);
        logger.info("Opening the URL");
        loginPage_pageFactory.openVWOLoginURL("url");
        String error_msg = loginPage_pageFactory.loginToVWO_InvalidCreds();
        logger.info("Verifying the Result");
        Assert.assertEquals(error_msg,"Your email, password, IP address or location did not match");
        driver.quit();

    }
}
