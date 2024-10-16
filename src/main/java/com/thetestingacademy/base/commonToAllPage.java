package com.thetestingacademy.base;

import com.thetestingacademy.utils.propertyReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileNotFoundException;
import java.time.Duration;

import static com.thetestingacademy.driver.DriverManager.getDriver;

public class commonToAllPage {

    // If you want to call something before every page object class, then put the logic here in this class
    // this commonToAll is created in such a way that it is supported for page factory and page object model also

    // open a file, open database connection you can write code here


    // Generate an empty constructor
    public commonToAllPage() {
    }

    // write down / put all the common functions

    // make the open URL function as a generic function by adding String url in the ()
    public void openVWOLoginURL(String url){
        // if I want to open a URL I must use driver.get  using DriverManager directly I can use
//        getDriver().get("https://app.vwo.com");
        // above get URL is hardcoded, so instead of hardcoding we can create a utility - property reader class
        // instead of hardcoding I can get url it like below
        try {
            // if url contains qa then I will use qa url if not I will use default
            switch (url){
                case "qa":
                    getDriver().get(propertyReader.readKey("qa_url"));
                    break;
                case "PreProduction":
                    getDriver().get(propertyReader.readKey("uat_url"));
                    break;
                default:
                    getDriver().get(propertyReader.readKey("url"));
                    break;
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }


    }

    // The below is concept related to Method overloading in polymorphism in OOPs concept
    // - same name different argument
    // click functions - 2 types
    // below click function is created in such a way that it is supported for page factory and page object model also
    // so in future if in one of the testcase you want to use page object model and in another testcase u want to use
    // page factory then this will be helpful

   // click function this can be used in page object model
    public void clickElement(By by){
        getDriver().findElement(by).click();
    }
    // click function this can be used in page factory 
    public void clickElement(WebElement by){
        by.click();
    }

    // enterInput- for page object model
    public void enterInput(By by, String key){
        getDriver().findElement(by).sendKeys(key);
    }


    // enterInput- for page factory
    public void enterInput(WebElement element, String key){

    }

    // Explicit waits

    public WebElement presenceOfElement(By elementLocation){
        return new WebDriverWait(getDriver(), Duration.ofSeconds(20))
                .until(ExpectedConditions.presenceOfElementLocated(elementLocation));
    }

    public WebElement visibilityOfElement(By elementLocation){
        return new WebDriverWait(getDriver(),Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOfElementLocated(elementLocation));
    }

    public WebElement getElement(By key){
        return getDriver().findElement(key);
    }

    public WebElement getElement(WebElement element){
        return element;
    }
}
