package automationEx;


import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;


public class VerifyLogin {
@Test
	public void verifyLoginTest(){

	    //pre-condition
	    RestAssured.given()
	    .contentType(ContentType.URLENC)
	    .formParam("email", "shameetha1302@gmail.com")
	    .formParam("password", "Sam@123")

	        

	    //HTTP Method
	    .when()
	        .post("https://automationexercise.com/api/verifyLogin")

	    // Response section
	    .then()
	        .log().all();
	}
}
