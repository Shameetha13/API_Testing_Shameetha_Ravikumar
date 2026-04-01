package tasks.com.fakerestapi.activities;

import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.*;
public class GetActivity {
	@Test
	public void getActivitiesTest() {
		given()
		
		.when()
		.get("https://fakerestapi.azurewebsites.net/api/v1/Activities")
		
		.then()
		.log().all()
		.assertThat()
			.statusCode(200)
			.statusLine(containsString("HTTP"))
			.header("Content-Type", containsString("application/json"))
			.body("title", containsString("newtitle1"))
			.time(lessThan(5000L));
	}
	}

