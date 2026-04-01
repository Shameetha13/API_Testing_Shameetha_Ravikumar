package dummyRestAPI;

import io.restassured.RestAssured;


public class GetAllEmployees {
	public static void main (String [] args){
		//pre-condition
	    RestAssured.given()
	  

	    //HTTP Method
	    .when()
	        .get("https://dummy.restapiexample.com/api/v1/employees")

	    // Response section
	    .then()
	        .log().all();
	}
}
