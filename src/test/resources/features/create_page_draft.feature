Feature: This is a draft feature file to show how we can create a Wiki page

  Scenario: Create a Wiki page access token
    Given I have "valid" access token
    When  I create a new Wiki page with the following details
      | title    | this is test title   |
      | content  | this is test content |
      | source   | this is test source  |
      | project  | QA                   |
      | language | en                   |
    Then validate that HTTP status code is 201
    And  The Wiki page should be created successfully

  Scenario: Invalid access token should give 401
    Given I have "invalid" access token
    When  I create a new Wiki page with the following details
      | title    | this is test title   |
      | content  | this is test content |
      | source   | this is test source  |
      | project  | QA                   |
      | language | en                   |
    Then validate that HTTP status code is 401