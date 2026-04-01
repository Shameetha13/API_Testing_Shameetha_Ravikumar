package dummyRestAPI;

import io.restassured.RestAssured;

public class DeleteEmplyeeById {
	public static void main (String [] args){
		//pre-condition
	    RestAssured.given()
	
	    //HTTP Method
	    .when()
	        .delete("https://dummy.restapiexample.com/api/v1/delete/1")

	    // Response section
	    .then()
	        .log().all();
	}
}
