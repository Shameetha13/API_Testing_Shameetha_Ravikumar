package stepDefinition;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class NinzaSteps {

    Response response;
    static String projectId; 

    @Given("Base URI is set to {string}")
    public void set_base_uri(String url) {
        RestAssured.baseURI = url;
    }

    @When("I send POST request to {string} with project name {string} and status {string}")
    public void create_project(String endpoint, String name, String status) {
 
        response = given()
        		.contentType(ContentType.JSON)
        		.body("{\r\n"
        				+ "  \"createdBy\": \"shamee_123\",\r\n"
        				+ "  \"projectName\": \""+ name + "\",\r\n"
        				+ "  \"status\": \""+status+"\",\r\n"
        				+ "  \"teamSize\": 0\r\n"
        				+ "}")
        		.when()
        		.post(endpoint);

        projectId = response.jsonPath().get("projectId");
        System.out.println("DEBUG: Captured Project ID -> " + projectId);
    }

    @When("I get GET request to {string}")
    public void getProject(String endpoint) {
        
        String finalUrl = endpoint.replace("{projectId}", projectId);
        response = when().get(finalUrl);
    }

    @When("I send PUT request to {string}")
    public void updateProject(String endpoint) {
        String finalUrl = endpoint.replace("{projectId}", projectId);
       
        
        response = given()
        		.contentType(ContentType.JSON)
        		.body("{\r\n"
        				+ "  \"createdBy\": \"shamee_1243\",\r\n"
        				+ "  \"projectName\": \"shamee_1243\",\r\n"
        				+ "  \"status\": \"Ongoing\",\r\n"
        				+ "  \"teamSize\": 0\r\n"
        				+ "}")
        		.when()
        		.put(finalUrl);
    }

    @When("I send DELETE request to {string}")
    public void deleteProject(String endpoint) {
        String finalUrl = endpoint.replace("{projectId}", projectId);
        response = when().delete(finalUrl);
    }

    @Then("response status should be {int}")
    public void validate_status(int code) {
        response.then().log().all().statusCode(code);
    }

    @Then("response should contain {string}")
    public void validate_body(String key) {
        response.then().body(key, notNullValue());
    }
}