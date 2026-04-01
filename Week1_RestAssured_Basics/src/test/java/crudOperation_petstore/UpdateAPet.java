package crudOperation_petstore;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class UpdateAPet {
	public static void main (String [] args){

	    //pre-condition
	    RestAssured.given()
	        .contentType(ContentType.JSON)
	        .body("{\r\n"
	        		+ "  \"id\": 9223372036854775807,\r\n"
	        		+ "  \"category\": {\r\n"
	        		+ "    \"id\": 0,\r\n"
	        		+ "    \"name\": \"string\"\r\n"
	        		+ "  },\r\n"
	        		+ "  \"name\": \"daisy\",\r\n"
	        		+ "  \"photoUrls\": [\r\n"
	        		+ "    \"string\"\r\n"
	        		+ "  ],\r\n"
	        		+ "  \"tags\": [\r\n"
	        		+ "    {\r\n"
	        		+ "      \"id\": 0,\r\n"
	        		+ "      \"name\": \"string\"\r\n"
	        		+ "    }\r\n"
	        		+ "  ],\r\n"
	        		+ "  \"status\": \"available\"\r\n"
	        		+ "}")

	    //HTTP Method
	    .when()
	        .put("https://petstore.swagger.io/v2/pet")

	    // Response section
	    .then()
	        .log().all();
	}
}
