@displayCandidatures
Feature: Displaying candidates in the table
  As an admin, I want to ensure that all candidature details are correctly displayed and formatted in the candidatures section.

  Background: 
    Given the admin is on the home page
    When the admin clicks on connexion
    And the admin enters mouna.makni@talan.com and Admin09$
    And the admin clicks on login button
    And the admin navigates to the candidature section

  @detailCandidatures
  Scenario: Verifying the display of all required candidature details
    Then a valid full name should be displayed for each candidature
    And a valid date format should be displayed for each candidature
    And a valid cursus should be displayed for each candidature
    And a valid email should be displayed for each candidature
    And a valid phone number should be displayed for each candidature
    And a valid status should be displayed for each candidature

  @actionButton
  Scenario: Verifying the display of action buttons for each candidature
    Then an information button should be displayed for each candidature
    And a download CV button should be displayed for each candidature
    And a candidature treatment action should be displayed only for candidatures with the status Accepted or In process
