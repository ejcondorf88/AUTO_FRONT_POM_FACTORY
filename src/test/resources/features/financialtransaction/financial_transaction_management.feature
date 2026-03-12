# language: en
Feature: Financial transaction management
  As a new user
  I want to record my income and expense transactions
  So that I can keep track of my spending

  Scenario Outline: E2E-CP - Complete transaction registration flow
    Given the visitor registers with name "<name>", email "<email>", and password "<password>"
    When the user logs in with email "<email>" and password "<password>"
    And accesses the transactions module
    And registers a "<type>" transaction with description "<description>" for an amount of <amount> and date "<date>"
    Then the user should see the transaction "<description>" with amount <amount> in the list

    Examples:
      | name  | email          | password | type    | description       | amount | date       |
      | Elian | elianm@test.com | Pigo0173!     | income  | Initial Salary    | 2000   | 2025-01-15 |
      | Juan  | juan  @test.com  | Pigo0173!     | expense | Rent Payment      | 800    | 2025-01-20 |