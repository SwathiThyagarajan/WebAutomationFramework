package com.thetestingacademy.pages.PageFactory;

import com.thetestingacademy.base.commonToAllPage;
import com.thetestingacademy.utils.propertyReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileNotFoundException;
import java.time.Duration;

// public class LoginPage_PageFactory {// this is before creating commonToAll Base test

public class LoginPage_PageFactory extends commonToAllPage {// this login page extends commonToAll function

    // every login page will get everything from the common to all page this is a concept of single inheritence

    WebDriver driver;

    // the below is a constructor it is called the moment we create an object
    // so create an TestVWOLogin_PageFactory class under test and create an object
    // the moment I create the object new LoginPage_PageFactory(driver); this will call the constructor
    // LoginPage_PageFactory and PageFactory will initialize all the elements

    // the below is the constructor
    public LoginPage_PageFactory(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    // Page Factory will initialize all the elements, Page Factory has something called as FindBy elements
    // Page Locators
    @FindBy(id = "login-username")
    private WebElement username;

    @FindBy(id = "login-password")
    private WebElement password;

    @FindBy(id = "js-login-btn")
    private WebElement SignInButton;

    @FindBy(xpath = "//div[@class='notification-box-description']")
    private WebElement error_message;

    //     2. Page Actions
    // The Page Actions that we need is Login with invalid credentials

    public String loginToVWO_InvalidCreds() throws FileNotFoundException {
//        username.sendKeys("admin@admin.com");
//        password.sendKeys("password123");
//        SignInButton.click();

        // now instead of using the above commented part we can use the below directly
        // since we have extended commonToAllPage class

//        enterInput(username, "admin@admin.com");
//        enterInput(password,"password123");
//        clickElement(SignInButton);

        // since we have created propertyReader we can use them instead of hardcoding the invalid login credentials
        enterInput(username, propertyReader.readKey("invalid_username"));
        try {
            enterInput(password, propertyReader.readKey("invalid_password"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        clickElement(SignInButton);




        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(error_message)); // Wait until the error message is visible

        // Now return the text of the error message
        return error_message.getText();


    }


}
