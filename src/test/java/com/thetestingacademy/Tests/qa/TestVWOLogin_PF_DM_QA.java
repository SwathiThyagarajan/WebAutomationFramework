package com.thetestingacademy.Tests.qa;

import com.thetestingacademy.base.commonToAllTests;
import com.thetestingacademy.pages.PageFactory.LoginPage_PageFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.Assertions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

import static com.thetestingacademy.driver.DriverManager.driver;

public class TestVWOLogin_PF_DM_QA extends commonToAllTests {

    private static final Logger logger = LogManager.getLogger(TestVWOLogin_PF_DM_QA.class);

    // this is page factory with driver manager
    @Test
    public void testLoginVWONegative() throws FileNotFoundException {
        logger.info("Starting Test in QA Environment");

        // driver initialization is the 1st function which will be executed before running any testcase
        LoginPage_PageFactory loginPage_pageFactory = new LoginPage_PageFactory(driver);
        logger.info("Opening the URL");
        loginPage_pageFactory.openVWOLoginURL("qa");
        String error_msg = loginPage_pageFactory.loginToVWO_InvalidCreds();
        logger.info("Verifying the Result");
        Assert.assertEquals(error_msg,"Your email, password, IP address or location did not match");

        // I can add more assertions also by using AssertJ
        Assertions.assertThat(error_msg).isNotNull().isNotEmpty();

        driver.quit();
    }
}
