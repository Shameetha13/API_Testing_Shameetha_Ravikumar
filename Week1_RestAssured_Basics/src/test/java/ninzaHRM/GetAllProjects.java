package ninzaHRM;

import io.restassured.RestAssured;


public class GetAllProjects {
	public static void main (String [] args){

	    //pre-condition
	    RestAssured.given()
	        

	    //HTTP Method
	    .when()
	        .get("http://49.249.28.218:8091/projects")

	    // Response section
	    .then()
	        .log().all();
	}
}
