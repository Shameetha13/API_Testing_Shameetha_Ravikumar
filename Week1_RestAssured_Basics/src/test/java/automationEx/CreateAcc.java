package automationEx;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;



public class CreateAcc {
	@Test
	public void createAccTest() {

	    //pre-condition
	    RestAssured.given()
	    .contentType(ContentType.URLENC)
	    .formParam("name", "Test User")
	    .formParam("email", "abcdef212334abx@gmail.com")
	    .formParam("password", "testing123")
	    .formParam("title", "Mrs")
	    .formParam("birth_date", "11")
	    .formParam("birth_month", "May")
	    .formParam("birth_year", "1898")
	    .formParam("firstname", "Test")
	    .formParam("lastname", "User")
	    .formParam("company", "ABC Pvt Ltd")
	    .formParam("address1", "123 Street")
	    .formParam("address2", "Near Mall")
	    .formParam("country", "India")
	    .formParam("zipcode", "600001")
	    .formParam("state", "Tamil Nadu")
	    .formParam("city", "Chennai")
	    .formParam("mobile_number", "9876663210")
	        

	    //HTTP Method
	    .when()
	        .post("https://automationexercise.com/api/createAccount")

	    // Response section
	    .then()
	        .log().all();
	}
}
