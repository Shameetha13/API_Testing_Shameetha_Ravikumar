package tasks.com.fakerestapi.activities;

import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.*;
public class DeleteActivity {
	@Test
	public void deleteActivityIdTest() {
		given()
		.pathParam("id", "3")
		.when()
		.delete("https://fakerestapi.azurewebsites.net/api/v1/Activities/{id}")
		
		.then()
		.log().all()
		.assertThat()
			.statusCode(200)
			.statusLine(containsString("HTTP"))
			.time(lessThan(5000L));
	}
	}

