@extractCandidaturesData
Feature: Extraction and Filtering of Candidate Data
  As an admin, I want to extract and filter all candidature data

  Scenario: Extracting Candidate data
    Given the admin is on the home page
    When the admin clicks on connexion
    And the admin enters mouna.makni@talan.com and Admin09$
    And the admin clicks on login button
    And the admin navigates to the candidature section
    When the admin download data from multiple pages
    Then data of all candidatures should be extracted
