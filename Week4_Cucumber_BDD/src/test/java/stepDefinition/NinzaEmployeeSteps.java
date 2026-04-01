package stepDefinition;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static io.restassured.RestAssured.*;

public class NinzaEmployeeSteps {

    static Response response;
   
    static String globalEmpId; 

    @Given("BaseURL is set")
    public void set_base_uri() {
        RestAssured.baseURI = "http://49.249.28.218:8091";
    }

    @When("I send POST request to create employee with {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, and {string}")
    public void create_employee_and_extract_id(String designation, String dob, String email, 
                                               String empName, String experience, String mobileNo, 
                                               String project, String role, String username) {
    	String uniqueUsername = username + new Random().nextInt(10000);
        Map<String, Object> body = new HashMap<>();
        body.put("designation", designation);
        body.put("dob", dob);
        body.put("email", email);
        body.put("empName", empName);
        body.put("experience", experience);
        body.put("mobileNo", mobileNo);
        body.put("project", project);
        body.put("role", role);
        body.put("username", uniqueUsername);

        response = given()
                    .contentType(ContentType.JSON)
                    .body(body)
                  .when()
                    .post("/employees");
        
       
        globalEmpId = response.jsonPath().getString("employeeId");
        System.out.println("Captured Employee ID: " + globalEmpId);
        
        response.then().log().all();
    }

    @When("I send PUT request to update employee {string} with {string}, {string}, {string}, {string}, {string}, {string}, {string}, and {string}")
    public void update_employee_using_global_id(String username, String designation, String dob, String email, 
                                                String empName, String experience, String mobileNo, 
                                                String project, String role) {
    	Assert.assertNotNull(globalEmpId, "Test Failed: globalEmpId is null because POST failed!");
        Map<String, Object> updateBody = new HashMap<>();
        updateBody.put("designation", designation);
        updateBody.put("dob", dob);
        updateBody.put("email", email);
        updateBody.put("employeeName", empName);
        updateBody.put("experience", experience);
        updateBody.put("mobileNo", mobileNo);
        updateBody.put("project", project);
        updateBody.put("role", role);
        updateBody.put("username", username);

       
        response = given()
                    .contentType(ContentType.JSON)
                    .pathParam("eid", globalEmpId) 
                    .body(updateBody)
                  .when()
                    .put("/employees/{eid}");
        
        response.then().log().all();
    }

    @Then("the statuscode should be {int}")
    public void verify_status_code(int scode) {
        response.then().statusCode(scode);
    }

    @And("employee {string} should be visible in the system")
    public void verify_visibility(String empName) {
       
        String actualName = response.jsonPath().getString("employeeName");
        Assert.assertEquals(actualName, empName);
    }

    @When("I send GET request to fetch all employees")
    public void fetch_all_employees() {
        response = given().when().get("/all-employees");
        response.then().log().all();
    }

    @And("employee profile for {string} should show designation as {string}")
    public void verify_update_designation(String username, String expectedDesg) {
        String actualDesg = response.jsonPath().getString("designation");
        Assert.assertEquals(actualDesg, expectedDesg);
    }

    @And("employee profile for {string} should show experience as {string}")
    public void verify_update_experience(String username, String expectedExp) {
    	Object actualExp = response.jsonPath().get("experience");
        String actualExpStr = String.valueOf(actualExp);
        Assert.assertTrue(actualExpStr.startsWith(expectedExp), 
                "Expected experience to start with " + expectedExp + " but found " + actualExpStr);
        
    }
    //delete not working
    @When("I send DELETE request for the employee")
    public void delete_employee() {
        
        response = given()
                    .pathParam("empId", globalEmpId)
                  .when()
                    .delete("/employee/{empId}");
        
        response.then().log().all();
    }

    @And("searching for the employee should return {int}")
    public void verify_deletion_status(int expectedStatusCode) {
        
        given()
            .pathParam("empId", globalEmpId)
        .when()
            .get("/employees/{empId}")
        .then()
            .statusCode(expectedStatusCode)
            .log().status();
    }
}