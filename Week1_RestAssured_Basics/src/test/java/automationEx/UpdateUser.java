package automationEx;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;


public class UpdateUser {
	public static void main (String [] args){

	    //pre-condition
	    RestAssured.given()
	    .contentType(ContentType.URLENC)
	    .formParam("name", "Test User")
	    .formParam("email", "rsdjfghvbyur213@gmail.com")
	    .formParam("password", "test123")
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
	        .put("https://automationexercise.com/api/updateAccount")

	    // Response section
	    .then()
	        .log().all();
	}
}
