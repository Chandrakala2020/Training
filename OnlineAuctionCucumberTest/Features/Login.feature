Feature: Validate seller Login
     As a seller want to enter credentials

Scenario : In order to verify the login
Given user navigates to app 
And user clicks on Seller link

When user enters username
And user enters password
And user clicks on submit button

Then user should succesfully login
And Create Product page must be visible