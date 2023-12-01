@addLesson
Feature: Add lessons to module
  As an admin, I want to add lessons to a module.

  Background: 
    Given the admin is on the home page
    When the admin clicks on connexion
    And the admin enters mouna.makni@talan.com and Admin09$
    And the admin clicks on login button

  @validLessonAddition
  Scenario: Add lesson with valid credentials
    When the admin clicks on cursus button
    And the admin clicks on edit cursus button
    And the admin clicks on edit module button
    And the interface for adding a lesson appears
    And the admin types "LeconTest" and "Test00" as title and status of the lesson
    Then the add button becomes enabled

  @invalidLessonAddition
  Scenario Outline: Add lesson with invalid credentials
    When the admin clicks on cursus button
    And the admin clicks on edit cursus button
    And the admin clicks on edit module button
    And the interface for adding a lesson appears
    And the admin types <title> and <status> of the lesson
    Then the add button does not become enabled

    Examples: 
      | title     | status |
      | ""        | Test00 |
      | LeconTest | ""     |
      | " "       | " "    |

  @verifyAddLesson
  Scenario: Check that the lesson has been added
    When the admin clicks on cursus button
    And the admin clicks on edit cursus button
    And the admin enters the module info
    Then the lesson has been added
