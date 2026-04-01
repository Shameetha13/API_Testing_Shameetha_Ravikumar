package dummyRestAPI;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class CreateRecord {
	public static void main (String [] args){
		//pre-condition
	    RestAssured.given()
	    .contentType(ContentType.JSON)
	    .body("	{\r\n"
	    		+ "        \"name\":\"testsam\",\r\n"
	    		+ "        \"salary\":\"123\",\r\n"
	    		+ "        \"age\":\"23\"\r\n"
	    		+ "        }")

	    //HTTP Method
	    .when()
	        .post("https://dummy.restapiexample.com/api/v1/create")

	    // Response section
	    .then()
	        .log().all();
	}
}
