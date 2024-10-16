package com.thetestingacademy.Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class StaleElementException {
    public static void main(String[] args) {


        WebDriver driver = new EdgeDriver();
        driver.navigate().to("https://google.com");
        // Trying to enter something in the search bar
        WebElement searchBar = driver.findElement(By.name("q"));
        // now refresh the page
         driver.navigate().refresh();
         searchBar.sendKeys("The Testing Academy");

         // when I do the refresh, the searchBar element may or may not be found by the webdriver.
        // when u do a refresh u need to again find the element
    }
}
