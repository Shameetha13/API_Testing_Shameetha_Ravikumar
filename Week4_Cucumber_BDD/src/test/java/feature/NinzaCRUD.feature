Feature: Ninza HRM Project CRUD Operations

Background:
  Given Base URI is set to "http://49.249.28.218:8091"

Scenario: Create a new project (POST)
  When I send POST request to "/addProject" with project name "Shamee_808" and status "Created"
  Then response status should be 201
  And response should contain "projectId"

Scenario: Read project details (GET)
  When I get GET request to "/project/{projectId}"
  Then response status should be 200
  And response should contain "projectName"

Scenario: Update project details (PUT)
   When I send PUT request to "/project/{projectId}"
  Then response status should be 200
  And response should contain "status"

Scenario: Delete project (DELETE)
  When I send DELETE request to "/project/{projectId}"
  Then response status should be 204