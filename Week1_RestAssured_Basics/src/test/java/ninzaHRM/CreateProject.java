package ninzaHRM;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class CreateProject {
	public static void main (String [] args){

	    //pre-condition
	    RestAssured.given()
	        .contentType(ContentType.JSON)
	        .body("{\r\n"
	        		+ "    \"createdBy\":\"shamee\",\r\n"
	        		+ "    \"projectName\":\"Project1003\",\r\n"
	        		+ "    \"status\":\"Created\",\r\n"
	        		+ "    \"teamSize\":0\r\n"
	        		+ "}")

	    //HTTP Method
	    .when()
	        .post("http://49.249.28.218:8091/addProject")

	    // Response section
	    .then()
	        .log().all();
	}
}
