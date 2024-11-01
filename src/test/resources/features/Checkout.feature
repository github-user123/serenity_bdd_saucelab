Feature: Checkout

  Background: success logged in with valid user
    Given I am already logged in

  Scenario: Checkout one item
    When I select item "item_4_title_link"
    And I click on ADD TO CART button
    Then Add to Cart button change to be Remove Button
    And I click on cart button
    Then "item_4_title_link" with "Sauce Labs Backpack" is on the cart list
    When I click checkout button
    Then I am directed to checkout page
    When I input firstname with "Test"
    And I input lastname with "sauce"
    And I input postal code with "123456"
    And I click on continue button
    Then Checkout "item_4_title_link" description appears as "Sauce Labs Backpack"
    When I click finish button
    Then checkout process completed


  Scenario Outline: Checkout multiple items
    Given I am already logged in
    When I select item "<Item>"
    And I click on ADD TO CART button
    Then Add to Cart button change to be Remove Button
    And I click on cart button
    Then "<Item>" with "<ProductName>" is on the cart list
    When I click checkout button
    Then I am directed to checkout page
    When I input firstname with "demo"
    And I input lastname with "test"
    And I input postal code with "54321"
    And I click on continue button
    Then Checkout "<Item>" description appears as "<ProductName>"
    When I click finish button
    Then checkout process completed

    Examples:
      |Item|ProductName|
      |item_4_title_link|Sauce Labs Backpack|
      |item_0_title_link|Sauce Labs Bike Light|
      |item_2_title_link|Sauce Labs Onesie|
      |item_5_title_link|Sauce Labs Fleece Jacket|





