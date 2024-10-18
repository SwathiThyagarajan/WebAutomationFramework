package com.thetestingacademy;

public class Intro_Frameworks {

/*
     what is a Framework ??
  *** A Framework is a structured approach to organising and designing automated test scripts

A Framework is a concept in software development same can be used in software testing also
A framework is a foundational structure that provides a set of reusable components.
It is kind of a Template that a Developer or an Automation Tester can build upon.
It will reduce the effort, the components can be reused therefore they don't have to start from scratch.
It is more efficient in nature.
so Framework is nothing but set of reusable components. How efficient you can write a code
so that other people who wants to communicate they can do it very easily

Key Characteristics of a Framework

1. Reusable components:- framework must contain components which are reusable in nature.
 suppose when you're creating RestAssured testcase then utilities are something that are reusable
   suppose we have  utilities like Excel file, json schema utility it can be used by any no. of testcase.
2. pre-defined structure:- A Framework also has a pre-defined structure, a framework gives you a
   proper folder structure / layered structure that u can add.

we are learning framework because we want toa keep our code in such a way that any team member
 can keep the testcase very easily. Focus should be more into writing the testcases

Types of  Frameworks
1.Modular Framework
2.Keyword Driven
3.Data Driven
4.Hybrid-Hybrid framework which is a mixture of Modular + DataDriven 70-80% of the companies use this. so pay attention to this
5.BDD - 10-15% only used
Test Driven-is mostly used for development purpose. here testcases are written first then the code is written

Playwright enables reliable end-to-end testing for web apps. it is like a node library

Topics related to Framework
TestNG is a Testing Framework:- when u add this framework to your source code.
1. You can write Testcases
2. Maintain the Testcases
3.Execute the testcase based on group wise, depends upon etc...

1.Modular Framework:- Modular framework means we will divide everything into modules or functions.
ex: in a e-commerce website we  have different modules.
 Registration, Login, Add to cart, Order page, checkout, payments
all the different modules we will create separate testcases for them.
They are independent testcases not dependent on each other

2.Data Driven:- running a single testcase multiple times by using an external data source.
 Data is used in the test scripts using parameterization. You will give to the Driver Script.
It will run under application under Test and you can compare the expected result with the actual result

  Data ie; ex: username and password can be in different formats like csv, Excel, Json, text file, YAML, My SQL.
The Data in any of the above format is injected to the Test Script using (Selenium, Test NG, Maven, Allure Report).
Data Driven Testing it separates the test data from test scripts,
allows the testcase to run multiple times with the data ex: login scenario, registration scenario

   Data Driven Testing (DDT) is a software testing methodology where test data is stored outside the test scripts,
typically in external files like Excel spreadsheets, CSV files, or databases. The key idea is to separate
the test logic from the test data, allowing the same test logic to be executed with multiple sets of data.
This approach increases test coverage and efficiency, especially when dealing with a large volume of test cases.

3.  Keyword Driven:- Keyword Driven means every keyword has a meaning. It is very famous in the Robot framework.
 I will write everything in keywords and every keyword has a definition attached to it.
 ex: of few keywords and their definition.
  * openBrowser --> write selenium commands to go to a particular URL like - driver.get("https://www.app.vwo.com")
  * getTitle -> driver.getTitle()
  * verifyTitle -> Assert verify title

4. BDD- Behaviour Driven - in the external file then there is a glue you will write your testcase logic here

5.Hybrid - Hybrid framework which is a mixture of Modular + Data driven + keyword driven (in future)
 -> they can be converted into BDD also using few steps.
  70-80% of the companies use Hybrid framework.
 so pay attention to this. Hybrid means mixing of the multiple frameworks into one.


        Difference between a library and a framework :---
Library is basically your code you call the library.
whereas framework will call you like TestNG. TestNG will call your testcases and run them
RestAssured is a library we add them into your testcase. our code will call the RestAssured library
and create the testcase.

Good Practices How to
create a Framework:--
Framework components very important question
1. Every framework will have to know how to manage the dependency.
In java, we can use maven or gradle-> is faster than maven apart from this gradle is exact copy of maven.
If u want to create framework in any other language, python use -pip. Node.js -npm. c#-Nuget
2. In the framework we need to manage the data using the Apache POI, and Fillo Excel.
3. To manage payload and Endpoints we can use Strings, HashMap or we can keep them in POJO's.
 we can serialize and deserialize we can use Gson or Jackson for the same.
4. To Manage Tests we can use testng and to see the reports we use allure for
this)(precondition/ post condition/set/config/ tear down/steps,description,priority,severity/execution)
5. For Reuse Components I use OOPs concept ->(Keywords, Abstraction, Inheritance, Generics, Configs. Specs. setups/helpers)
6.For Logger-Report Loggers we use (Testng. allure), text loggers(log4J)
7. For Reports-Test summary, percentage, steps, description, failure reason,  logs we can use -allure
8. For Utils-String manipulators, Json Manipulators, Data Manipulators, Readers/Writers/custom code/tools
 - we can use - Faker js
9. For CI/CT-Version Controlling we can use -GitHub/git,
 For Continuous Integration and Testing we can use -jenkins/teamcity/travisci- Jenkins File + GIT+ Github.

Now we can do the framework, In the framework we can do one Integration scenario that we are going to automate.
 This framework that we are creating we can use it for spotify, GitHub api etc...
In the framework project does not matter which api you're using if it is an api ur framework will automate,
 therefore framework is very generic in nature.

What type of Tech-stack you are using??
We Use the following:
1. Java - is our programming language, Rest Assured - is a library which help us make http request.
2. Selenium - is used for user Interactions and Browser Automation
3. Maven - will be used for managing our dependencies and managing our build,
4. TestNG - is used testing framework for managing our Testcases, AssertJ is used for Assertions.
5. Data Driven Testing - To Read Params Properties , Excel - we use Apache POI, Fillo. we use them for reading data.
   We use Excel Sheet for Test Data -> Data Provider
6· For Payload management - we use - POJO - Gson, Jackson API
7. Allure Report - For Reporting we use Allure Report
8. SonarLint for Linting mechanism, JDK greater than Java > 17 is required . we are using java 21 latest release 22.
SonarLint is advanced Linter to clean our code, it is a plugin once we install it,
 in our testcases what ever unused items are there it will prompt you to remove them.
 when we arite framework we generally use SonarLint so, it helps us to write a clean code.
9. Logs - logs.4j
10. CI/CD - Git and Jenkins
11. To Run Remote Selenium Grid - we can use Cloud Grid or selenoid.

// Interview Question also -> Difference between main and test folder
Now we can create our folder structure:-
 How we are going to keep everything where we will keep what
1. In the main folder -> this will only contain folder which don't have any relation with the Testcases.
       - like utils.
2. In the tests --> we will keep Folders or class who have direct relation with Testcases.






we can write our custom Hybrid framework
1. create a new project select maven archetype
2. Give the name of the project as API_AUTOMATION
3.select create a GitHub repository
4. JDK select 22
5.catalogue - internal
6.Archetype select quickstart
7.Advanced setting - group id com.swathi
8.Artifact-id project name
9.click on create

10. In pom.xml remove the j-unit
11. Delete app and app.test from main and test folder
12.Right click and add Readme.md file
what is the use of readme file
13. Add dependency Rest assured etc...
14. In main create the following packages -> pages, base, driver
15.u can create utils package in com.swathi
16. create Resources under main

base - base contains things which is common to all the pages
driver - is how to handle all the drivers

Structure

1. First Driver Manager will be created (helps to initialize the driver)
2. then I have created commonToAllPages, commonToAllPages is common to both Login and Dashboard page.
3. next I have created Login page and Dashboard page.

4. Then we created commonToAllTests - the responsibility of commonToAllTests is to call and start the webdriver.
   commonToAllTests is common to all the LoginTest.
5. LoginTest - LoginTest will also call openURL from commonToAllPages
   loginVWO is coming from LoginPage.
   The main responsibility of logintest is to only do Assertions
6. I have created propertyReader under utils under main. this will give hardcoded strings
 like url invalid username etc. this is mostly used by common to all pages or assertions
 7. we can add log4j logging mechanism - for this go to maven repository search as log4j core
 log4j always has some vulnerabilities so make sure you are using the version which has no vulnerabilities
  because of the vulnerabilities people have stopped using log4j in the overall frameworks.
  alternate for log4j is still not found . so check if the vulnerability does not affect then use log4j
  add the dependency  just like log4j core u can add log4j api also

log4j is a logging mechanism to capture the logs, it is a widely used logging framework for java applications
it is developed by Apache foundation it is open source '
it acts as a listener previously we used to add testng listener they are complex, nowadays, you can just add
it will log the logs in the console as a text file
log4j it is good to go
   log4j file should be created in resource folder name it as log4j2.xml
   in log4j2.xml add the configuration file
   any testcase file u create u must just create the log manager
   there are different types of logs available
   In Log4j, the main log levels are:

1. **FATAL**: Critical errors causing the application to abort.
2. **ERROR**: Serious issues, but the app can continue.
3. **WARN**: Potential problems needing attention.
4. **INFO**: General application events and progress.   90% of the time people use this.
5. **DEBUG**: Detailed debugging information.
6. **TRACE**: Most granular level for fine-grained events.
7. **OFF**: Disables logging.

These levels help control the detail and importance of log messages.

     a log is a record of events, activities, or messages generated by software applications, systems, or devices.
  Logs are typically used to capture information about the operation, performance, errors, or actions
  taken within a system.
They help developers, administrators, and security personnel
monitor the system's behavior and troubleshoot issues.


 A YAML Reader is a tool or library that reads YAML (YAML Ain't Markup Language) files,
 which are designed to be human-readable and can represent complex data structures.
 YAML files typically have a `.yaml` or `.yml` extension.
 it is a key value pair

 If u have 5 environment how will u run it
 for this purpose u will create multiple testng file.
 ex: testng_qa.xml, testng_uat.xml
 if u want to run same testcase in different environment then create a package as QA and copy-paste the test case
 and rename it as TestVWOLogin_PF_DM_QA and make few changes in the common to All class
 make openVWOLoginURL as a generic function


 which file is the best property Reader or Excel reader or Yaml reader

The choice between **Property Reader**, **Excel Reader**, and **YAML Reader** depends on the context of your use case and the structure of your data. Here's a comparison to help you decide which is best for your needs:

### 1. **Property Reader**
   - **File type**: Typically `.properties` files, used to store key-value pairs.
   - **Use cases**: Commonly used for configuration settings in Java applications (e.g., `config.properties`).
   - **Advantages**:
     - Simple and lightweight.
     - Easy to parse in most programming languages, especially in Java.
     - Suitable for straightforward key-value pairs.
   - **Disadvantages**:
     - Limited to simple data structures (no nested structures).
     - Harder to maintain for large configurations.

   - **Best for**: Simple configurations, settings with key-value pairs, especially for Java-based projects.

### 2. **Excel Reader**
   - **File type**: `.xls` or `.xlsx`.
   - **Use cases**: Ideal for tabular data or complex datasets with multiple sheets and formulas.
   - **Advantages**:
     - Great for structured data in rows and columns.
     - Supports multiple sheets, cell formatting, and formulas.
     - Widely used in business and financial contexts.
   - **Disadvantages**:
     - Parsing Excel files can be more complex and resource-intensive.
     - Not suitable for configuration settings or hierarchical data.

   - **Best for**: Working with structured, tabular data, such as reports, logs, or datasets that require analysis or calculations.

### 3. **YAML Reader**
   - **File type**: `.yaml` or `.yml`.
   - **Use cases**: Commonly used for configurations, especially in cloud-native applications (e.g., Docker, Kubernetes).
   - **Advantages**:
     - Human-readable and easy to edit.
     - Supports nested data structures (arrays, lists, dictionaries).
     - More flexible than JSON for configuration purposes.
   - **Disadvantages**:
     - Whitespace-sensitive, which can cause issues if not properly handled.
     - Not suitable for large datasets or numerical data analysis.

   - **Best for**: Complex configurations, hierarchical data, and when readability is important.

### Summary:
- **Use Property Reader**: If you need to work with simple key-value configuration files.
- **Use Excel Reader**: If you're handling structured, tabular data or need to work with spreadsheets.
- **Use YAML Reader**: If you're managing complex configurations with nested structures.

Let me know if you need help deciding based on your specific project!







*/



}
