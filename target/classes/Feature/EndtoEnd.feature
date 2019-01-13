Feature: End To End Test from adding a product to cart till submitting order


  Background:
    Given I am on the Home Page
    When I click on the "My Account" button
    And I click on the "Login" link
    Then I should be on the "Login" Page
    When I enter valid "test_user@outlook.com" and "qwerty_1"
    Then I should be able to login

  @e2e
  Scenario: Verify whether is user is able to purchase a Desktop
    When I select select the option "MAC" from the tab "Desktops"
    Then I should be able to view the items related to the option ""




