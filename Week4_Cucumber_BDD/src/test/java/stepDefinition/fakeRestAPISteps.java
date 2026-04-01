package stepDefinition;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class fakeRestAPISteps {

	Response res;
	static int activityId;
	
	@Given("Base URL is set for Activities")
	public void baseurl() {
		RestAssured.baseURI="https://fakerestapi.azurewebsites.net";
	}
	
	
	@When("I send post request with title {string}")
	public void post_Activities(String title) {
	
		String body = "{\r\n"
				+ "  \"id\": 0,\r\n"
				+ "  \"title\": \"" + title + "\",\r\n"
				+ "  \"dueDate\": \"2026-03-24T07:28:36.009Z\",\r\n"
				+ "  \"completed\": false\r\n"
				+ "}";
		
		res=RestAssured.given().contentType(ContentType.JSON).body(body)
				.when().post("/api/v1/Activities");
		
		activityId=res.jsonPath().getInt("id");
		System.out.println("Created Activity ID: " + activityId);
	}
	

	@When("I send get request to fetch all activites")
	public void get_Activities() {
		res=RestAssured.given()
				.when().get("/api/v1/Activities");
	}
	
	@When("I send get request to fetch activity by id")
	public void get_Activity_byId() {
		res=RestAssured.given()
				.when().get("/api/v1/Activities/2");
	}
	
	
	@When("I send put request with title {string}")
	public void put_Activity(String title) {
		String body="{\r\n"
				 + "  \"id\": " + activityId + ",\r\n"
		        + "  \"title\": \"" + title + "\",\r\n"
		        + "  \"dueDate\": \"2026-03-24T07:28:36.009Z\",\r\n"
		        + "  \"completed\": true\r\n"
		        + "}";
		
		res=RestAssured.given().pathParam("id",activityId)
				.contentType(ContentType.JSON).body(body)
				.when().put("/api/v1/Activities/{id}");
	}
	

	@When("I send delete request with id to delete activity")
	public void delete_Activity() {
		res=RestAssured.given()
				.when().delete("/api/v1/Activities/2");
	}
	
	
	
	@Then("validate status code as 200")
	public void verify_statusCode() {
		res.then().statusCode(200);
	}
	
	
}