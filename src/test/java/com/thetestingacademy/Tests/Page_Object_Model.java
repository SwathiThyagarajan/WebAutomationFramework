package com.thetestingacademy.Tests;

public class Page_Object_Model {


/*
    Page Object Model
      we will introduce a Page Object Model to remove the duplicacy and arrange the testcases properly
    Page Object Model is a design pattern in selenium that creates an object repository for storing all web elements
    it helps reduce code duplication and improves testcase maintenance

     Page Object Model says :--
     1. Don't write your locators within the Testcase file
     2. It is a Design Pattern - Design Pattern is how you organize your Testcase or locators
      driver.findElement(By --> this is the locator
      locators - finding of an element and assertions - verifying the element. these 2 things are different.
      if u combine both in a single file then there is no scalability. that is why we need to use page object model

        Ex: if you take app.vwo.com you can divide it into different pages
        (*)  Login page - keep your locators here. create a class in java where u can keep the Locators
            and their Actions ie; Page Locators and what Page Actions they can do.
            Locators + Actions --> Page Locators  --> Page Actions .

        (*) DashBoard Page - here also create a Page Class what is the Page Locators and Page Actions they can use

    3. Testcase file should be a separate file where you can use these Page Classes to achieve the scalability
*/

}
