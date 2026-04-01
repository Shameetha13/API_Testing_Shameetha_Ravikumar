package tasks.com.fakerestapi.activities;

import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.*;
public class GetActivityById {
	@Test
	public void getActivitiesIdTest() {
		given()
		.pathParam("id", "30")
		.when()
		.get("https://fakerestapi.azurewebsites.net/api/v1/Activities/{id}")
		
		.then()
		.log().all()
		.assertThat()
			.statusCode(200)
			.statusLine(containsString("HTTP"))
			.time(lessThan(5000L));
	}
	}

