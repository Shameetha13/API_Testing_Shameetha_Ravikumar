package ninzaHRM;

import io.restassured.RestAssured;


public class GetSingleProject {
	public static void main (String [] args){

	    //pre-condition
	    RestAssured.given()
	        

	    //HTTP Method
	    .when()
	        .get("http://49.249.28.218:8091/project/NH_PROJ_2962")

	    // Response section
	    .then()
	        .log().all();
	}
}
