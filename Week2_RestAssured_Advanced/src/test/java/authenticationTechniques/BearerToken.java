package authenticationTechniques;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class BearerToken {
	@Test
public void usingBearerToken() {
	given()
	.header("Authorization", "Bearer 12345")
//	.auth().oauth2("hello123")
	.log().all()
	
	.when()
	.get("https://httpbin.org/bearer")
	
	.then()
	.log().all();
}
}
