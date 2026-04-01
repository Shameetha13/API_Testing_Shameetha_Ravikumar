package dummyRestAPI;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;


public class UpdateEmployee {
	public static void main (String [] args){
		//pre-condition
	    RestAssured.given()
	    .contentType(ContentType.JSON)
	    .body("	{\r\n"
	    		+ "        \"name\":\"testsamnew\",\r\n"
	    		+ "        \"salary\":\"123\",\r\n"
	    		+ "        \"age\":\"24\"\r\n"
	    		+ "        }")


	    //HTTP Method
	    .when()
	        .put("https://dummy.restapiexample.com/api/v1/update/21")

	    // Response section
	    .then()
	        .log().all();
	}
}
