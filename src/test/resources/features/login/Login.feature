@login
Feature:  I want to login into the Saucedemo website with valid and invalid data
  Scenario: Login as an existing used with valid credentials
    Given I am on the login page
    And I verify swag lab logo is displayed
    When I entered a valid "standard_user" "secret_sauce"
    And I click login button
    Then I am directed to inventory page
