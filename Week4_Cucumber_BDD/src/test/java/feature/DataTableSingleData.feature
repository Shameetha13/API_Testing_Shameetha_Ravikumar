#Author Shamee


Feature:CRUD ops on data table

Background:
Given Base URI is set for single data table

Scenario: Creating project with data table

 When I send POST request with following project details
    | createdBy |  projectName | status |teamSize  |
    | sam  | Prrrroj11       | Created | 0    |
  Then response status code should be 201 for data