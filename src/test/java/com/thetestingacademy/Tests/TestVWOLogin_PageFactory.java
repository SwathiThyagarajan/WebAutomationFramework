package com.thetestingacademy.Tests;

import com.thetestingacademy.pages.PageFactory.LoginPage_PageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.time.Duration;

public class TestVWOLogin_PageFactory {


    @Test
    public void testLoginVWONegative() throws FileNotFoundException {

        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // the above is not required now because now we have a commonToAll class
        // and the above will be done by driver manager
        // In test also we will create a base to keep all the common testcases
        // to understand this better we will create another class TestVWOLogin_PageFactory_DriverManager

        LoginPage_PageFactory loginPage_pageFactory = new LoginPage_PageFactory(driver);
        driver.navigate().to("https://app.vwo.com");
        // the moment I create the object new LoginPage_PageFactory(driver); this will call the constructor
       // LoginPage_PageFactory and PageFactory will initialize all the elements in LoginPage_PageFactory class under

        String error_msg = loginPage_pageFactory.loginToVWO_InvalidCreds();
        System.out.println("Actual error message: " + error_msg);
        Assert.assertEquals(error_msg,"Your email, password, IP address or location did not match");
        driver.quit();

    }

}
