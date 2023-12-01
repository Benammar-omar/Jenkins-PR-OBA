@Login
Feature: Login
  As admin I want to log in talen academy

  Scenario Outline: Check login with valid credentials
    Given the admin is on the home page
    When the admin clicks on connexion
    And the admin enters <email> and <password>
    And the admin clicks on login button
    Then the admin is on the dashboard page

    Examples: 
      | email                 | password |
      | mouna.makni@talan.com | Admin09$ |
