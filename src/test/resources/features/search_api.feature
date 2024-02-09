@search
Feature: Scenarios to test 'search/page' API

  I want search a page by a keyword and validate that results are relevant. Also, I want
  to validate that the queried page has timestamp after a certain date.

  Background: Search for a keyword
    Given A client of the search API
    When  A search for pages containing for "furry rabbits" is executed

  Scenario: Search response should have a related page to the keyword
    Then  A page with the title "Sesame Street" is found
    And   validate that HTTP status code is 200

  Scenario: Page details should have an expected timestamp
    Then  A page with the title "Sesame Street" is found
    When  The page details for "Sesame_Street" are requested
    Then  It has a latest timestamp after "2023-08-17"