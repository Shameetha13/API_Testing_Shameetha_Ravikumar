package crudOperation_petstore;

import io.restassured.RestAssured;

public class DeleteAPet {
	public static void main (String [] args){

	    //pre-condition
	    RestAssured.given()
	        
	    //HTTP Method
	    .when()
	        .delete("https://petstore.swagger.io/v2/pet/9223372036854775807")

	    // Response section
	    .then()
	        .log().all();
	}
}
