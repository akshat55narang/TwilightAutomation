Feature: Register a new user

  Background:
    When I click on the "My Account" button
    And I click on the "Register" link
    Then I should be on the "Register" Page

    @reg
    Scenario Outline:
    Given I enter the "<placeholder>" as "<text>"
      Examples:
        | placeholder | text |
        | First Name | test |
