Feature: Add to Cart
  Scenario: add one product to cart
    Given I am already logged in
    When I select item "item_4_title_link"
    And I click on ADD TO CART button
    Then Add to Cart button change to be Remove Button
    And I click on cart button
    And "item_4_title_link" with "Sauce Labs Backpack" is on the cart list

