@logout
Feature: logout
  Scenario: success logged out after logged in with valid user
    Given I am already logged in
    And I am on the inventory page
    When I navigate to logout
    And I click logout button
    Then I am directed to the login page
