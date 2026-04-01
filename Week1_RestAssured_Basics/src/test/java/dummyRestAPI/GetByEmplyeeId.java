package dummyRestAPI;

import io.restassured.RestAssured;


public class GetByEmplyeeId {
	public static void main (String [] args){
		//pre-condition
	    RestAssured.given()
	  

	    //HTTP Method
	    .when()
	        .get("https://dummy.restapiexample.com/api/v1/employee/13")

	    // Response section
	    .then()
	        .log().all();
	}
}
