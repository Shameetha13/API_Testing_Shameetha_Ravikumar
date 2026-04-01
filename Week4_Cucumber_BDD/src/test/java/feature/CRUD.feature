#Author: Shameetha Ravikumar
Feature: CRUD operations on petstore

  Background:
    Given Base URI is set

  Scenario: Create a pet
    When I send POST request with name scooby
    Then response statuscode should be 200

  Scenario: Get pet details
    When I send GET request for created pet
    Then response statuscode should be 200

  Scenario: Update pet details 
    When I send PUT request for created pet
    Then response statuscode should be 200

  Scenario: Delete pet details
    When I send DELETE request for created pet
    Then response statuscode should be 200