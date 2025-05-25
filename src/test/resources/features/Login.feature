Feature: Login Functionality

@Sanity @Regression
Scenario Outline: Login with valid credentials
Given User navigates to login page
When User enters valid email address <username> into the email field
And User enters valid password <password> into the password field
And User clicks on the Login button
Then User should get successfully logged in
Examples:
|username						|password			|
|jackdoe@email.com	|jackdoe@123	|
|janedoe@email.com	|janedoe@123	|
|jennydoe@email.com	|jennydoe@123	|

@Regression
Scenario: Login with invalid credentials
Given User navigates to login page
When User enters invalid email address "johndoex@email.com" into the email field
And User enters invalid password "123456x" into the password field
And User clicks on the Login button
Then User should get warning message about invalid credentials

@Regression
Scenario: Login with valid email and invalid password
Given User navigates to login page
When User enters valid email address "johndoe@email.com" into the email field
And User enters invalid password "123456x" into the password field
And User clicks on the Login button
Then User should get warning message about invalid credentials

@Regression
Scenario: Login with invalid email and valid password
Given User navigates to login page
When User enters invalid email address "johndoex@email.com" into the email field
And User enters valid password "johndoe@123" into the password field
And User clicks on the Login button
Then User should get warning message about invalid credentials

@Sanity @Regression
Scenario: Login without entering credentials
Given User navigates to login page
When User has not entered any email address into the email field
And User has not entered any password into the password field
And User clicks on the Login button
Then User should get warning message about invalid credentials
