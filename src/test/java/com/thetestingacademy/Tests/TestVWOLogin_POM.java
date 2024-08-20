package com.thetestingacademy.Tests;

import com.thetestingacademy.pages.pageObjectModel.LoginPage_POM;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestVWOLogin_POM {

    @Test
    public void testLoginVWONegative(){

        WebDriver driver = new EdgeDriver();
        LoginPage_POM loginPagePom1 = new LoginPage_POM(driver);

        // Attempt login with invalid credentials and verify error message
        String error_msg_text = loginPagePom1.loginToVWO_InvalidCreds("admin@gmail.com", "admin");
        Assert.assertEquals(error_msg_text,"Your email, password, IP address or location did not match");

        driver.quit();
    }

    // The advantage of Page Locators and Page Actions is I can create another testcase with just changing the argument
    @Test
    public void testLoginVWONegative2(){
        WebDriver driver = new EdgeDriver();
        LoginPage_POM loginPagePom1 = new LoginPage_POM(driver);
        String error_msg_text = loginPagePom1.loginToVWO_InvalidCreds("Promod@gmail.com", "admin");
        Assert.assertEquals(error_msg_text,"Your email, password, IP address or location did not match");

        driver.quit();


    }


}
