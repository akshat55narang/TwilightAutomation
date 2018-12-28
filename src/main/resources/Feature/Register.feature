Feature: Register a new user

  Background:
    When I click on the "My Account" button
    And I click on the "Register" link
    Then I should be on the "Register" Page

  @reg
  Scenario:
    When I fill all the mandatory values
    And I agree to the Privacy Policy
    And I subscribe to the Newsletter
    And I click on "Continue" to complete registration
    Then I should receive a message "Congratulations! Your new account has been successfully created!"

  @reg1
  Scenario Outline:
    When I do not enter the mandatory values in the "<fields>"
    Examples:
      | fields           |
      | First Name       |
      | Last Name        |
      | E-Mail           |
      | Telephone        |
      | Password         |
      | Password Confirm |

