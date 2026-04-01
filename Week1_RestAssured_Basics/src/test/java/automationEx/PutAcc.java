package automationEx;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PutAcc {
	@Test
	public void putAccTest() {

	    //pre-condition
	    RestAssured.given()
	    .contentType(ContentType.URLENC)
	    .formParam("name", "Test User1")
	    .formParam("email", "abcdef212334abx@gmail.com")
	    .formParam("password", "testing123")
	    .formParam("title", "Mr")
	    .formParam("birth_date", "12")
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
	        .put("https://automationexercise.com/api/updateAccount")

	    // Response section
	    .then()
	        .log().all();
	}
}
