Feature: Search Functionality

@Regression
Scenario: User searches for the valid product
Given User navigates to homepage
And User enters valid product "HP" in the search box
And User clicks on the search button
Then User should get the valid product "HP" in the search result

@Regression
Scenario: User searches for the invalid product
Given User navigates to homepage
And User enters invalid product "Honda" in the search box
And User clicks on the search button
Then User should get a message about no product matching

@Regression
Scenario: User searches without any product
Given User navigates to homepage
And User enters no product in the search box
And User clicks on the search button
Then User should get a message about no product matching