package stepDefinition;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;


public class PostSteps {

    static Response response;
    
    static long petId;

    @Given("Base URI is set")
    public void setBase() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
    }

    @When("I send POST request with name scooby")
    public void createPet() {
        
      
        
        String body = "{\n"
                + "  \"id\": 0,\n"
                + "  \"category\": {\n"
                + "    \"id\": 0,\n"
                + "    \"name\": \"Shamee\"\n"
                + "  },\n"
                + "  \"name\": \"scooby\",\n"
                + "  \"photoUrls\": [\n"
                + "    \"string\"\n"
                + "  ],\n"
                + "  \"tags\": [\n"
                + "    {\n"
                + "      \"id\": 0,\n"
                + "      \"name\": \"deeps\"\n"
                + "    }\n"
                + "  ],\n"
                + "  \"status\": \"available\"\n"
                + "}";

        response = given()
                    .contentType(ContentType.JSON)
                    .body(body)
                  .when()
                    .post("/pet");

       
        petId = response.jsonPath().getLong("id");
        System.out.println("Created Pet ID: " + petId);
    }

    @Then("response statuscode should be {int}")
    public void validStatusCode(int code) {
        response.then().log().all().statusCode(code);
    }

    @When("I send GET request for created pet")
    public void getAPet() {
        response = given()
                    .pathParam("petId", petId)
                  .when()
                    .get("/pet/{petId}");
    }

    @When("I send PUT request for created pet")
    public void updateAPet() {
        String body = "{\n"
                + "  \"id\": " + petId + ",\n"
                + "  \"name\": \"scooby-updated\",\n"
                + "  \"status\": \"sold\"\n"
                + "}";

        response = given()
                    .contentType(ContentType.JSON)
                    .body(body)
                  .when()
                    .put("/pet");
    }

    @When("I send DELETE request for created pet")
    public void deleteAPet() {
        response = given()
                    .pathParam("petId", petId)
                  .when()
                    .delete("/pet/{petId}");
    }
    
}