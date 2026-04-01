package stepDefinition;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoClasses.NinzaPojo;
import io.cucumber.java.en.*;

public class NinzaScenarioOutlineSteps {

    Response response;
    String uniqueProjectName;

    
    @Given("Base URI is set for Ninza12")
    public void setBaseURI() {
        baseURI = "http://49.249.28.218:8091";
    }

   
    @When("I send POST request with {string} {string} {string} {int}")
    public void sendPostRequest(String projectName, String createdBy, String status, int teamSize) {

      
        uniqueProjectName = projectName + System.currentTimeMillis();

        NinzaPojo body = new NinzaPojo();
        body.setCreatedBy(createdBy);
        body.setProjectName(uniqueProjectName);
        body.setStatus(status);
        body.setTeamSize(teamSize);
        
        response = given()
                    .contentType(ContentType.JSON)
                    .body(body)
                  .when()
                    .post("/addProject");

       
        System.out.println("Created Project: " + uniqueProjectName);
    }

   
    @Then("response status of Ninza12 should be {int}")
    public void validateStatusCode(int statusCode) {
        response.then().assertThat().statusCode(statusCode);
    }

    
    @Then("ninza12 response should contain {string}")
    public void validateResponse(String projectName) {
        response.then().assertThat().body("projectName", equalTo(uniqueProjectName));
    }
}