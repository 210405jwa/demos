Feature: Login

Background:
Given We have a WebDriver instantiated and configured
And We have instantiated the LoginPage and LandingPage

Scenario: Successful Login
Given User is at the login page
When User enters username "user" and password "password"
And User presses login
Then User should see a landing page with the header Successfully logged in as

Scenario: Fake scenario to demonstrate Data Tables
Given I am just doing a fake scenario
When I provide this data in the form of a table
|FirstName |LastName |Email |
|John      |Doe      |johndoe@gmail.com |
|Jane      |Doe      |janedoe@gmail.com |
Then We're not really going to do anything but print it out

Scenario Outline: Test multiple invalid logins
Given User is on the login page
When User enters invalid username <Username> and invalid password <password>
Then "Invalid login!" is displayed

Examples:
|Username|password|
|invaliduser|invalidpassword|
|user|pass|
|dfdf|password|
