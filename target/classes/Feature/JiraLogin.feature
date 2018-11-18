Feature: Login to application with valid users

  Background:
    Given a user with name "anarang" exists



  @api
  Scenario Outline: Verify whether invalid users are not authorized to receive a session key
    Then api call with "<username>" or "<password>" should not be successful
    Examples:
      | username                | password |
      | test_user@outlook.com   | tester   |
      | test_user_1@outlook.com | qwerty_1 |