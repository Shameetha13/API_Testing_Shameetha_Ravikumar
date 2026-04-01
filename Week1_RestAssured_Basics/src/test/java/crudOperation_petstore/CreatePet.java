package crudOperation_petstore;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class CreatePet {
	public static void main (String [] args){

	    //pre-condition
	    RestAssured.given()
	        .contentType(ContentType.JSON)
	        .body("{\n" +
	            "  \"id\": 0,\n" +
	            "  \"category\": {\n" +
	            "    \"id\": 0,\n" +
	            "    \"name\": \"string\"\n" +
	            "  },\n" +
	            "  \"name\": \"Scooby\",\n" +
	            "  \"photoUrls\": [\n" +
	            "    \"string\"\n" +
	            "  ],\n" +
	            "  \"tags\": [\n" +
	            "    {\n" +
	            "      \"id\": 0,\n" +
	            "      \"name\": \"string\"\n" +
	            "    }\n" +
	            "  ],\n" +
	            "  \"status\": \"InStock\"\n" +
	            "}")

	    //HTTP Method
	    .when()
	        .post("https://petstore.swagger.io/v2/pet")

	    // Response section
	    .then()
	        .log().all();
	}
}
