Feature: Login to application with valid users

  Background:
    Given I am on the Home Page
    When I click on the "My Account" button
    And I click on the "Login" button
    Then I should be redirected to the Login Page

  Scenario Outline: Verify whether valid users authorized users are able to access the application
    When I enter valid "<email>" and "<password>"
    Then I should "be able" to login
    Examples:
      | email | password |
      |       |          |

  Scenario Outline: Verify whether invalid users are not authorized to login to application
    Examples: I enter invalid "<username>" or "<password>"
    Then I should "not be able" to Login
      | email | password |
      |       |          |