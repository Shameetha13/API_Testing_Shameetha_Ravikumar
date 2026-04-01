package crudOperationUsingTestNG;
import org.testng.annotations.Test;
import io.restassured.RestAssured;

public class GetAllDetails {
	@Test
	public void getPetsTest() {
		 //pre-condition
	    RestAssured.given()
	        
	    //HTTP Method
	    .when()
	        .post("https://petstore.swagger.io/v2/pet/1")

	    // Response section
	    .then()
	        .log().all();
	}
	
}
