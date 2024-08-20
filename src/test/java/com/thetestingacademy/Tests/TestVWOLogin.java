package com.thetestingacademy.Tests;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestVWOLogin {


    //        **Project #1 - TC ( Negative) - Invalid username, pass - Error message**
//
//        1. Open the URL .app.vwo.com/#/login](https://app.vwo.com/#/login)
//        2. **Find the Email id** and enter the email as admin@admin.com
//        3. **Find the pass inputbox** and enter passwrod as admin.
//        4. Find and Click on the submit button
//        5. Verify that the error message is shown "Your email, password, IP address or location did not match"
//

    WebDriver driver;
    WebDriverWait wait;

    @BeforeTest
    public void openBrowser(){

        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--guest");
        edgeOptions.addArguments("--start-maximized");
        edgeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new EdgeDriver(edgeOptions);

        // Initialize WebDriverWait once
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }


    @Test(groups = "QA")
    @Description(" Testcase Description")
    public void testVerifyNegativeLoginVWO(){

        driver.navigate().to("https://app.vwo.com");
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(),"Login - VWO");
        Assert.assertEquals(driver.getCurrentUrl(), "https://app.vwo.com/#/login");

//        WebElement emailInputBox =  driver.findElement(By.id("login-username"));
//        emailInputBox.sendKeys("admin@admin.com");

        driver.findElement(By.id("login-username")).sendKeys("admin@admin.com");
        driver.findElement(By.id("login-password")).sendKeys("admin");
        driver.findElement(By.id("js-login-btn")).click();

//  1. Using a WebElement Variable (First Approach) vs 2. Direct Interaction (Second Approach):

//        Mix of Both: Most real-time projects use a mix of both approaches. For elements that are reused,
//     stored in a WebElement variable is common. For one time interactions, direct interaction is often preferred.
//        Team Conventions: Sometimes, teams adopt coding standards that prefer one approach over the other
//     for consistency, depending on their priorities like readability or performance.
//        Overall, using WebElement variables is more commonly seen in real-world projects
//     because it often aligns better with principles of clean, maintainable code, especially
//     in larger or more complex test cases.


        WebElement error_msg = driver.findElement(By.className("notification-box-description"));
        System.out.println(error_msg.getText());

        wait.until(ExpectedConditions.textToBePresentInElement(error_msg,"Your email, password, IP address or location did not match"));

        Assert.assertEquals(error_msg.getText(),"Your email, password, IP address or location did not match");

    }

    @AfterTest
    public void closeBrowser(){

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }
    // this is not an organized code because everything is kept in same file, if I want to create another testcase
    // I need to create a new file and copy-paste. This is not a scalable approach lot of duplicate codes.
    // So, that is why we will introduce a model to remove the duplicacy and arrange the testcases properly
    // The model is known as Page Object Model
}
