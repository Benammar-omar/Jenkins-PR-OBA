@paginationCandidatures
Feature: Pagination on the Candidature Interface
  As an admin, I want to use pagination on the candidature interface to navigate between pages of applications.

  Background: 
    Given the admin is on the home page
    When the admin clicks on connexion
    And the admin enters mouna.makni@talan.com and Admin09$
    And the admin clicks on login button
    And the admin navigates to the candidature section

  @nextPage
  Scenario: Navigate to the third page using the next page button
    When the admin is on the second page of candidatures
    And the admin clicks on the next page button
    Then the third page of candidatures should be displayed

  @previousPage
  Scenario: Navigate to the first page using the previous page button from the second page
    When the admin is on the second page of candidatures
    And the admin clicks on the previous page button
    Then the first page of candidatures should be displayed

  @finalPage
  Scenario: Navigate to the final page using the final page button
    When the admin is on the second page of candidatures
    And the admin clicks on the final page button
    Then the last page of candidatures should be displayed

  @firstPage
  Scenario: Navigate to the first page using the first page button from the second page
    When the admin is on the second page of candidatures
    And the admin clicks on the first page button
    Then the first page of candidatures should be displayed
