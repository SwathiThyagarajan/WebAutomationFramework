package com.thetestingacademy.driver;

import com.thetestingacademy.utils.propertyReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.io.FileNotFoundException;

public class DriverManager {

    // Driver Manager makes sure what is happening with the driver
    // In our testcase we should not use the driver directly  this is not a good way
    // because it is not possible to change the driver or add new action items in future
    // so, we create a driver manager.
    // there are 2 types of driver manager - basic and thread safe

    // creating a basic webdriver manager.
    // we are creating static functions because we don't want to create object of this class.
    // we will use them directly
    public static WebDriver driver;

    // Generating a getter setter of driver


    public static WebDriver getDriver() {
        return driver;
    }

    // In setter of driver u can write a switch loop in future
    public static void setDriver(WebDriver driver) {
        DriverManager.driver = driver;
    }

    // initializing the driver
    // while initializing we can write a switch statement also to select which driver we want
    public static void init(){
        String browser = null;
        try {
            browser = propertyReader.readKey("browser");//get the browser from propertyReader using readkey
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        if(driver == null){ // if driver is == null then create edgeoptions
            switch (browser) {
                case "edge":
                    // if readkey is edge this below code will get executed
                    EdgeOptions edgeOptions = new EdgeOptions();
                    edgeOptions.addArguments("--start-maximized");
                    edgeOptions.addArguments("--guest");
                    driver = new EdgeDriver(edgeOptions);
                    break;
                // if it is chrome this code will get executed
                case "chrome":
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--start-maximized");
                    //             chromeOptions.addArguments("--guest"); this is not allowed in chrome
                    driver = new ChromeDriver(chromeOptions);
                    break;
                default:
                    System.out.println("No browser found!!");

            }



        }

    }

    // down the driver when /if driver is not equal to null
    public static void down(){
        if(driver != null ){
            driver.quit();
            driver = null;

        }
    }
}
