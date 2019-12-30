Feature: Login into Application

Scenario: Positive test validation login
Given initilize the browser with chrome
And Navigate to "QaClickAcademy" site
And Click on Login link in home page to land on sign in page 
When User enters "username" and "password" and logs in
Then Home page is populated
And Cards are displayed

Scenario: Home page default login
Given User is on NetBanking landing page
When User login into application with "john" and "12345"
Then Home page is populated
And Cards are displayed