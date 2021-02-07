# nuvolarTest

This repository covers the followning automation exercices proposed by Nuvolar:

Manual & Automation exercise

Specification 
Write test scenarios for Facebook sign up feature (new user registration) in text file using Gherkin language making sure to tackle all relevant test scenarios.

Automation exercise
Specification 

Create automation test for the following scenario using Selenium Webdriver and Java or whatever language you prefer:
1. Go to https://www.amazon.com
2. Search for "hats for men" 
3. Add first hat to Cart with quantity 2
4. Open cart and assert total price and quantity are correct
5. Search for "hats for women"
6. Add first hat to Cart with quantity 1
7. Open cart and assert total price and quantity are correct
8. Change the quantity for item selected at step 3 from 2 to 1 item in Cart
9. Assert total price and quantity are changed correctly

# How to:
1. The first excercise (FB sign up) can be found in the GherkinScenarios/Facebook.txt file. 
For this ecercise I have choosen a declarative approach with no specific granularity on the scenario (ie no "fill password with "xxx"") but instead a "Fill form" approach, in my opinion this allows for less specific but easier to maintain scenarios

2. For the second excercise I created a small framework using a PageObject / PageFactory approach. I have used Graddle as build tool, JUnit as test runner and Selenium.

Prerequisites:
  - Java JDK 1.8
  - Chrome v.88*
  - Windows machine*
 
 ** In case it has to be executed on a different OS / Chrome version you will have to download the specific chromedriver executable for your OS / Chrome version in your local machine and place it under the \src\test\resources\drivers folder 
  
Running the tests:
Tests can be executed by running the "gradlew tests" command. This will build and run the tests given all the pre-requisites are met.

Reporting:
Once the test is compiled and executed an HTML report will be generated under \build\reports\tests\test\index.html

Comments:
You may notice that the code is not clicking on the first item in the products list but instead on the second one, this is because I found that the first product is often reserved to "last unit available" or "flash sale" products, causing the test to fail by not having the option to purchase more than one item. I found that using the second element on the list gives more reliable results and reduces test logic and flackyness 
