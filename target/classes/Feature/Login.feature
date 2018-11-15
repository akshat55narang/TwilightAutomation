Feature: Login to application with valid users

  Background:
    When I click on the "My Account" button
    And I click on the "Login" link
    Then I should be on the "Login" Page

  Scenario Outline: Verify whether valid users are able to access the application
    When I enter valid "<email>" and "<password>"
    Then I should be able to login
    Examples:
      | email                 | password |
      | test_user@outlook.com | qwerty_1 |

  Scenario Outline: Verify whether invalid users are not authorized to login to application
    When I enter invalid "<user>" or "<pwd>"
    Then I should be able to see the message " Warning: No match for E-Mail Address and/or Password."
    Examples:
      | user                    | pwd      |
      | test_user@outlook.com   | tester   |
      | test_user_1@outlook.com | qwerty_1 |