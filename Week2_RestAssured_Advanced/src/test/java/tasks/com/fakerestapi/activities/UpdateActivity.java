package tasks.com.fakerestapi.activities;

import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;
public class UpdateActivity {
	@Test
	public void updateActivitiesTest() {
		given()
		.contentType(ContentType.JSON)
		.body("{\r\n"
				+ "  \"id\": 23456789,\r\n"
				+ "  \"title\": \"newtitle123\",\r\n"
				+ "  \"dueDate\": \"2026-03-12T03:07:01.093Z\",\r\n"
				+ "  \"completed\": false\r\n"
				+ "}")
		.pathParam("id", "23456789")
		.when()
		.put("https://fakerestapi.azurewebsites.net/api/v1/Activities/{id}")
		
		.then()
		.log().all()
		.assertThat()
			.statusCode(200)
			.statusLine(containsString("HTTP"))
			.header("Content-Type", containsString("application/json"))
			.body("title", containsString("newtitle123"))
			.time(lessThan(5000L));
	}
	}

