package com.thetestingacademy.pages.pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage_POM {

/*  Login Page under Page Object Model contains 2 things
 1. Page Locators
 2. Page Actions

 In the Login Page the no. of elements we have is 4
 if positive enter email, enter password, submit button
 if negative positive enter email, enter password, submit button and error message box

 so to keep them we will create a constructor
*/

    WebDriver driver;

    public LoginPage_POM(WebDriver driver) {
        this.driver = driver;

    }


//  1. Page Locators
    private By username = By.id("login-username");
    private By password = By.id("login-password");
    private By SignInButton = By.id("js-login-btn");
    private By error_message = By.id("js-notification-box-msg");
    // all of the above are private because of encapsulation nobody should use them until we tell them how to use
    // they are protected
    // they can only be used by using getter setters


//     2. Page Actions
    // the actions are like - Login


    public String loginToVWO_InvalidCreds(String userName, String passWord){

        driver.navigate().to("https://app.vwo.com");
        driver.findElement(username).sendKeys(userName);
        driver.findElement(password).sendKeys(passWord);
        driver.findElement(SignInButton).click();


        // I can use this instead of Thread.sleep
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
//        WebElement error_msg = wait.until(ExpectedConditions.visibilityOfElementLocated(error_message));
//        return error_msg.getText();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement error_msg = driver.findElement(By.className("notification-box-description"));
        String error_msg_text  = error_msg.getText();
        String error_msg_attribute_dataqa  = error_msg.getAttribute("data-qa");
        return error_msg_text;

        // This type of creation is not recommended  just for example

        // using this class we can create a testcase under tests as TestVWOLogin_POM
    }
}
