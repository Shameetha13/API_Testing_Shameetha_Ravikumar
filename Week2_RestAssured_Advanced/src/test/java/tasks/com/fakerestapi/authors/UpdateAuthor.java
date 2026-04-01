package tasks.com.fakerestapi.authors;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;
public class UpdateAuthor {
	@Test
	public void updateAuthorsIdTest() {
		given()
		.pathParam("id", "21")
		.contentType(ContentType.JSON)
		.body("{\r\n"
				+ "  \"id\": 21,\r\n"
				+ "  \"idBook\": 12,\r\n"
				+ "  \"firstName\": \"sam1\",\r\n"
				+ "  \"lastName\": \"sam\"\r\n"
				+ "}")
		.when()
		.put("https://fakerestapi.azurewebsites.net/api/v1/Authors/{id}")
		
		.then()
		.log().all()
		.assertThat()
			.statusCode(200)
			.statusLine(containsString("HTTP"))
			.body("firstName", containsString("sam1"))
			.body("lastName", containsString("sam"))
			.header("Content-Type", containsString("application/json"))
			.time(lessThan(5000L));
	}
	}

