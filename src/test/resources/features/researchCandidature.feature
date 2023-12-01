@rechercheCandidature
Feature: Verify recherche field
  As admin I want to use recherche field for searching candidats

  Background: 
    Given the admin is on the home page
    When the admin clicks on connexion
    And the admin enters mouna.makni@talan.com and Admin09$
    And the admin clicks on login button

  @searchByName
  Scenario Outline: As an admin, I want to search for a candidat by name
    When the admin navigates to the candidature section
    And the admin types "<name>" in the search field
    Then the data of the candidat should appear

    Examples: 
      | name |
      | Sami |

  @searchByFullName
  Scenario Outline: As an admin, I want to search for a candidat by full name
    When the admin navigates to the candidature section
    And the admin types "<name> <lastName>" in the search field
    Then the data of the candidat should appear

    Examples: 
      | name | lastName |
      | Sami | Kammoun  |

  @searchByEmail
  Scenario Outline: As an admin, I want to search for a candidat by email
    When the admin navigates to the candidature section
    And the admin types "<email>" in the search field
    Then the data of the candidat should appear

    Examples: 
      | email                 |
      | samikammoun@gmail.com |

  @searchBySituation
  Scenario Outline: As an admin, I want to search for a candidat by situation
    When the admin navigates to the candidature section
    And the admin types "<situation>" in the search field
    Then no candidat data should appear

    Examples: 
      | situation                                 |
      | A la recherche d’une nouvelle opportunité |
