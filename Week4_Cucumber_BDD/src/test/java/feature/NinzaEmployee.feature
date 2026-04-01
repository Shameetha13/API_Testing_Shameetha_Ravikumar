Feature: Ninza HRM Employee API CRUD Operations

Background:
  Given BaseURL is set

Scenario Outline: Create a new employee
  When I send POST request to create employee with "<designation>", "<dob>", "<email>", "<empName>", "<experience>", "<mobileNo>", "<project>", "<role>", and "<username>"
  Then the statuscode should be 201
  And employee "<empName>" should be visible in the system

  Examples:
    | designation | dob        | email                 | empName      | experience | mobileNo   | project           | role          | username  |
    | dev         | 12/03/2000 | samworail@gmail.com   | sahxcfmeeta  | 4          | 1234567890 | HRM               | ROLE_EMPLOYEE | samhtharr |
    | test        | 13/04/2000 | shmee@gmail.com       | sahxcmfitha  | 3          | 4323484593 | Employee Tracker  | ROLE_EMPLOYEE | sumtharr  |
    
  Scenario: Fetch all employees from the system
  When I send GET request to fetch all employees
  Then the statuscode should be 200
 
 Scenario Outline: Update an existing employee completely
  When I send PUT request to update employee "<username>" with "<designation>", "<dob>", "<email>", "<empName>", "<experience>", "<mobileNo>", "<project>", and "<role>"
  Then the statuscode should be 200
  And employee profile for "<username>" should show designation as "<designation>"
  And employee profile for "<username>" should show experience as "<experience>"

  Examples:
    | designation | dob        | email                 | empName   | experience | mobileNo   | project          | role          | username  |
    | sr_dev      | 12/03/2000 | samworkmail@gmail.com | sahhmeeta | 5          | 1234567890 | HRM              | ROLE_EMPLOYEE | samhtharr |
    | lead_test   | 13/04/2000 | shamee@gmail.com      | sahhmitha | 4          | 4323484593 | Employee Tracker | ROLE_EMPLOYEE | sumtharr  |
    
    Scenario: Remove the created employee from the system
  When I send DELETE request for the employee
  Then the statuscode should be 204
  And searching for the employee should return 404