package com.thetestingacademy;

public class Page_Object_Model {


/*
    Page Object Model
      we will introduce a Page Object Model to remove the duplicacy and arrange the testcases properly
   Page Object Model is a design pattern in selenium that creates an object repository for storing all web elements
    it helps reduce code duplication and improves testcase maintenance

  pom is a design pattern that creates an object repository for web UI elements

    Features:-
     pom is just a way of organising our code to achieve the below features
    1. code Reusability
    2. Improved Readability
    3. Separation of concerns - POM separates the test logic from the UI interactions.

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

    3. Testcase file should be a separate file where you can use the Page Classes(LoginPage class
    and Dashboard Page class) to achieve the scalability
*/

    /*    PAGE FACTORY

    1. Page Factory this is an extension to the Page Object Model
    2. Selenium will help you in Annotation for the element location
    3. Lazy Initialization - Page Factory supports Lazy Initialization
    4. Automatic Initialization - Page Factory also supports Automatic Initialization

 Lazy Initialization meaning:-
    The moment you create the Page Object Model immediately the elements are not loaded.
 ex: we have created login class ie; Login page until the test class(TestVWOLogin_POM) is created
 the login class elements are not loaded.
 In TestVWOLogin_POM if I do -> LoginPage_POM loginPagePom1 = new LoginPage_POM(driver);
 only when I call the function -> loginToVWO_InvalidCreds. the driver.find elements will be loaded / occuring

 so in POM until the Test logic calls the locators they are not initialized.

  Automation Initialization. - Instead of initializing each page object individually,
  Page Factory allows for all elements to be initialized at once using the initElements() method.

Page Factory is faster while compared But the Big problem is
 - it tries to initialize the elements early
 - if page changes ex: for SPA single page applications when u initialize the elements early
  there might be changes in the page, and it is very prone to exception -> Stale Element Exception.
  Stale Element Exception means to are trying to access an element when it does not exist.

  single page application are created in React, view JS, Angular JS

  A Single-Page Application (SPA) is a type of website or web app where everything happens on one page.
Instead of reloading or moving to new pages when you click links, the content on the page updates instantly.
 It feels faster and smoother, like using a mobile app or desktop software.

SPAs use JavaScript to load and display new information without making the whole page reload.
 Websites like Gmail or Facebook are examples of SPAs—when you click on something,
  only part of the page changes instead of loading a new page

In a traditional multi-page application, the browser reloads the entire page
whenever a user navigates to a new section. With SPAs, JavaScript frameworks like React, Angular, or Vue.js
handle routing and dynamically update the webpage content, reducing loading times and improving performance.

90% of the time we use page object model, even the created of selenium has told use pom and not page factory
     */
}
