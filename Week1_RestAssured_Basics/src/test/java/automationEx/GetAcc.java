package automationEx;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
public class GetAcc {
	@Test
public void getAccTest(){

		    //pre-condition
		    RestAssured.given()
		    .queryParam("email", "abcdef212334abx@gmail.com")
		    //HTTP Method
		    .when()
		        .get("https://automationexercise.com/api/getUserDetailByEmail")

		    // Response section
		    .then()
		        .log().all();
		}
	}

