Feature: GitHub Repository CRUD Operations
Background:
 Given GitHub Base URI is set
  Scenario Outline: Create repository with name and description
   
    When I create a repository with name "<repoName>" and description "<description>"
    Then the response status should be 201
    And the repository name should be "<repoName>"

    Examples:
      | repoName        | description        |
      | demo-repo-101   | First repo         |
      | demo-repo-102   | Second repo        |


  Scenario Outline: Get repository
 
    When I fetch repository "<repoName>"
    Then the response status should be 200

    Examples:
      | repoName        |
      | demo-repo-101   |
      | demo-repo-102   |


  Scenario Outline: Update repository description
   
    When I update repository "<repoName>" with description "<desc>"
    Then the response status should be 200

    Examples:
      | repoName        | desc              |
      | demo-repo-101   | Updated repo 1    |
      | demo-repo-102   | Updated repo 2    |


  Scenario Outline: Delete repository
   
    When I delete repository "<repoName>"
    Then the response status should be 204

    Examples:
      | repoName        |
      | demo-repo-101   |
      | demo-repo-102   |