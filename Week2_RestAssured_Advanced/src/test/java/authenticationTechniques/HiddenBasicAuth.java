package authenticationTechniques;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class HiddenBasicAuth {
	@Test
public void usingHiddenBasicAuth() {
	given()
	.pathParam("user", "admin")
	.pathParam("passwd", "password123")
	.auth().preemptive().basic("admin","password123")
	.log().all()
	
	.when()
	.get("https://httpbin.org/hidden-basic-auth/{user}/{passwd}")
	
	.then()
	.log().all();
}
}
