Feature: Create a Jira Project

  Background:
    Given a project with name "test" doesnot exist

  @project
  Scenario: Verify whether user is able to create a new project
    Then api call to create a new project with name "test" should be successful
