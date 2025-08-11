Feature: Passenger Service API

  Background:
    Given I have a valid access token

  Scenario: Add a passenger and verify retrieval by id
    When I add passenger with id 9 name "Matilda" mobile "9898765654" gender "Female" aadhaar "1239876765Y" address "Chennai"
    Then the response status should be 200
    And the passenger with id 9 should have name "Matilda"

  Scenario: View passenger list and verify contains id 9
    When I fetch passenger list
    Then the response status should be 200
    And the list should contain passenger id 9

  Scenario: View passenger by name and mobile
    When I fetch passenger by name "Rakesh" and mobile "1234567890"
    Then the response status should be 200

  Scenario: Delete passenger by id
    When I delete passenger with id 1
    Then the response status should be 200