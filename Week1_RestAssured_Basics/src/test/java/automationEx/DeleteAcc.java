package automationEx;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;


public class DeleteAcc {
	@Test
	public void deleteAcc(){

	    //pre-condition
	    RestAssured.given()
	    .contentType(ContentType.URLENC)
	    .formParam("email", "abcdef212334@gmail.com")
	    .formParam("password", "testing123")
	    
	    //HTTP Method
	    .when()
	        .delete("https://automationexercise.com/api/deleteAccount")

	    // Response section
	    .then()
	        .log().all();
	}
}
