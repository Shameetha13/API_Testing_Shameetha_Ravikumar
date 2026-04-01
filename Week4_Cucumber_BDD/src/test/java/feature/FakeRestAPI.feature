Feature: CRUD Operations on Activities

Scenario: Post request for Activities

Given Base URL is set for Activities
When I send post request with title "My Task" 
Then validate status code as 200


Scenario: Get request to fetch all Activities

Given Base URL is set for Activities
When I send get request to fetch all activites
Then validate status code as 200


Scenario: Get request to fetch particular activity

Given Base URL is set for Activities
When I send get request to fetch activity by id
Then validate status code as 200


Scenario: Put request to update Activity 

Given Base URL is set for Activities
When I send put request with title "My Task" 
Then validate status code as 200

Scenario: Delete request to delete activity 

Given Base URL is set for Activities
When I send delete request with id to delete activity
Then validate status code as 200