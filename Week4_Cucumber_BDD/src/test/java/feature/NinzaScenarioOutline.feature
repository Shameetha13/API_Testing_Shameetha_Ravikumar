# Author Shamee

Feature: Create Multiple Projects in Ninza12 HRM

  Background:
    Given Base URI is set for Ninza12

  Scenario Outline: Create project with different data
    When I send POST request with "<projectName>" "<createdBy>" "<status>" <teamSize>
    Then response status of Ninza12 should be 201
    And ninza12 response should contain "<projectName>"

    Examples:
      | projectName   | createdBy | status     | teamSize |
      | Ninza_Project6| Shamee    | Created    | 0        |
      | Ninza_Project7| Shamee    | Ongoing    | 0        |
      | Ninza_Project8| Shamee    | Completed  | 0        |
      | Ninza_Project9| Shamee    | Created    | 0        |
      | Ninza_Project0| Shamee    | Ongoing    | 0        |