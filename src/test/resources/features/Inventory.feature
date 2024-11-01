@inventory
Feature: Inventory page testing on saucedemo.com
  Background:
    Given I am already logged in
    And I have already add one product on cart

  Scenario: Testing sort items DESC on inventory page and cart page
    Given I am on the inventory page
    When I sort the product by "Name (Z to A)"
    Then Sort menu show "Name (Z to A)"
    When I click add to cart button on the first product on the list
    And I click on cart button
    Then I am directed to cart page
    And The selected product appears in cart list
    When I click on remove button on the first product item added in the cart list
    #Then The first product item added on cart list is diappear
    And I click on continue shopping button
    Then I am redirected back to the inventory page


  Scenario: Testing sort items ASC on inventory page and cart page
    Given I am on the inventory page
    When I sort the product by "Name (A to Z)"
    Then Sort menu show "Name (A to Z)"
    When I click add to cart button on the first product on the list
    And I click on cart button
    Then I am directed to cart page
    And The selected product appears in cart list
    When I click on remove button on the first product item added in the cart list
    #Then The first product item added on cart list is diappear
    And I click on continue shopping button
    Then I am redirected back to the inventory page