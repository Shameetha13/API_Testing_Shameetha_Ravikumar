package ninzaHRM;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class UpdateProject {
	public static void main (String [] args){

	    //pre-condition
	    RestAssured.given()
	        .contentType(ContentType.JSON)
	        .body("{\r\n"
	        		+ "    \"createdBy\":\"shameetha\",\r\n"
	        		+ "    \"projectName\":\"Project1002\",\r\n"
	        		+ "    \"status\":\"Created\",\r\n"
	        		+ "    \"teamSize\":0\r\n"
	        		+ "}")

	    //HTTP Method
	    .when()
	        .put("http://49.249.28.218:8091/project/NH_PROJ_2962")

	    // Response section
	    .then()
	        .log().all();
	}
}
