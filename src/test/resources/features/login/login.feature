# language: en

Feature: Secure Login to OrangeHRM
  As a regular user
  I want to access my dashboard using my credentials
  To manage human resources tasks

  @SuccessfulLogin
  Scenario: Successful login and logout
    Given the user is on the login page
    When the user authenticates with valid credentials
    Then the user should see the application dashboard
    When the user decides to logout
    Then the user is on the login page
