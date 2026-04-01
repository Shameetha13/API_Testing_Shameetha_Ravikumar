package automationEx;
import org.testng.annotations.Test;

import io.restassured.RestAssured;


public class GetAllProducts {
	@Test
	public void getProductsTest(){

	    //pre-condition
	    RestAssured.given()
	    
	    //HTTP Method
	    .when()
	        .get("https://automationexercise.com/api/brandsList")

	    // Response section
	    .then()
	        .log().all();
	}
}
