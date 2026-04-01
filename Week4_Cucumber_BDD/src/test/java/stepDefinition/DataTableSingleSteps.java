package stepDefinition;


import java.util.List;
import java.util.Map;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class DataTableSingleSteps {
	Response response;
	static String projectId;
	
	@Given("Base URI is set for single data table")
	public void setURINinza() {
		RestAssured.baseURI="http://49.249.28.218:8091";
	}

	@When("I send POST request with following project details")
	public void create(DataTable dataTable) {
		List<Map<String, String>> data=dataTable.asMaps(String.class,String.class);
		
		String createdBy=data.get(0).get("createdBy");
		String projectName=data.get(0).get("projectName");
		String status=data.get(0).get("status");
		int teamSize=Integer.parseInt(data.get(0).get("teamSize"));
		
		 String body = "{\n" +
                 "  \"createdBy\": \"" + createdBy + "\",\n" +
                 "  \"projectName\": \"" + projectName + "\",\n" +
                 "  \"status\": \"" + status + "\",\n" +
                 "  \"teamSize\": " + teamSize + "\n" +
                 "}";

         response = RestAssured.given()
                 .contentType(ContentType.JSON)
                 .body(body)
                 .post("/addProject");

         System.out.println(response.asPrettyString());

	}
	
	@Then("response status code should be {int} for data")
	public void validateStatusCode(int code) {
		response.then().statusCode(code);
	}
}