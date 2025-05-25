Feature: Register Functionality

@Sanity @Regression
Scenario: User creates an account with only mandatory fields
Given User has navigated to register page
When User enters details in the below fields
|firstName	|	John								|
|lastName		|	Doe									|
|email 			|	johndoe02@email.com	|
|password		|	johndoe@123					|
And User selects Privacy policy
And User clicks on the Continue button
Then Account should get created successfully

@Regression
Scenario: User creates an account with only mandatory fields
Given User has navigated to register page
When User enters details in the below fields
|firstName	|	Jane03							|
|lastName		|	Doe									|
|email 			|	janedoe03@email.com	|
|password		|	janedoe@123					|
And User selects Privacy policy
And User clicks on the Continue button
Then Account should get created successfully

@Regression
Scenario: User creates an account with only mandatory fields
Given User has navigated to register page
When User enters details in the below fields
|firstName	|	Jenny02								|
|lastName		|	Doe										|
|email 			|	jennyDoe02@email.com	|
|password		|	jennydoe@123					|
And User selects Privacy policy
And User clicks on the Continue button
Then Account should get created successfully

@Regression
Scenario: User creates an account with the all the field
Given User has navigated to register page
When User enters details in the below fields
|firstName	|	John03							|
|lastName		|	Doe									|
|email 			|	johndoe03@email.com	|
|password		|	johndoe@123					|
And User selects Subscribe option
And User selects Privacy policy
And User clicks on the Continue button
Then Account should get created successfully

@Sanity @Regression
Scenario: User creates an account with duplicate email
Given User has navigated to register page
When User enters details in the below fields
|firstName	|	John								|
|lastName		|	Doe									|
|email 			|	johndoe@email.com		|
|password		|	johndoe@123					|
And User selects Subscribe option
And User selects Privacy policy
And User clicks on the Continue button
Then Account should get warning message about duplicate email

@Sanity @Regression
Scenario: User creates an account without entering data in any fields
Given User has navigated to register page
When User does not enter any data into the fields
And User clicks on the Continue button
Then Account should get proper warning messages for all the mandatory fields