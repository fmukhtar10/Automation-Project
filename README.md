# Automation-Project

Web and API Automation done by Fahad
Just import this project into Eclipse and run it.
I have used Eclipse IDE and Project type is maven.
Every dependency is added in the POM file.
Selenium Webdriver with java and TestNG framework for Web.
Rest Assured and Tesng framework for API automation.
Hamcrest Matchmakers is used for the validation of body data.
Test priorities are added with each test case.
Test suite is made where all Test classes are listed in sequence in the 'AllTestCases.xml file'
Just right click on 'AllTestCases.xml file' and run as Test suite.

# Web Automation

You need to download chrome or firefox driver and give local path in the configuration class.
I have added chrome driver in the project too. You can use that as well.
Configuration class is used for setting up local dependencies and calling browsers.
Locators contains all the xpaths which are used, I make a seperate class for xpath and called them in the test case class.
'SeleniumTestCases' contains all test cases and browser will be closed automatically after the test cases execution
Final page validation is done by getting the title and compared it with the expected title.

# API Automation

Used the REST API at: https://gorest.co.in/ and created a personal access token
Created a new user, post, comment and todos.
'APITests' class is used for all post method scenarios
'GetAPIs' class is used for all get method scenarios.
Status code validation is done for all post methods
Status code and body validation is done for all get methods.
logged the response 
Token authorization is also done.
Already used email creating a user tested.
Mandatory fields validation.
Wrong format email validation is also done.
Post the data and compared it with the get data APIs
You need to add new email for createuser test case otherwise it will gets fail.

# Others
We can also verify other parts of API response like Content header.
API automation can also be done using Postman and Test feature.
