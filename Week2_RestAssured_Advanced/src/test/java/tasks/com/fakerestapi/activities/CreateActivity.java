package tasks.com.fakerestapi.activities;

import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;
public class CreateActivity {
	@Test
	public void createActivitiesTest() {
		given()
		.contentType(ContentType.JSON)
		.body("{\r\n"
				+ "  \"id\": 23456789,\r\n"
				+ "  \"title\": \"newtitle12\",\r\n"
				+ "  \"dueDate\": \"2026-03-12T03:07:01.093Z\",\r\n"
				+ "  \"completed\": true\r\n"
				+ "}")
		.when()
		.post("https://fakerestapi.azurewebsites.net/api/v1/Activities")
		
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

