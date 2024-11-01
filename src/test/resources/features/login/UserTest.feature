Feature: User login/logout

  Background: success logged in with valid user
    Given I am on the login page
    When I entered a valid "standard_user" "secret_sauce"
    And I click login button
    Then I am directed to inventory page


    Scenario Outline: Successful login and logout with valid user
      Given I am on the login page
      When I entered a valid "<Username>" "<Password>"
      And I click login button
      Then I am directed to inventory page

      Examples:
        |Username|Password|
        |standard_user|secret_sauce|
        |problem_user|secret_sauce|
        |performance_glitch_user|secret_sauce|

    Scenario: Successful logout and logout with valid user
      Given I am already logged in
      When I navigate to logout
      And I click logout button
      Then I am directed to the login page


  Scenario Outline: Failed login and error message displayed for invalid user
    Given I am on the login page
    When I entered a valid "<Username>" "<Password>"
    And I click login button
    Then I see user locked out error message displayed

    Examples:
      |Username|Password|
      |locked_out_user|secret_sauce|