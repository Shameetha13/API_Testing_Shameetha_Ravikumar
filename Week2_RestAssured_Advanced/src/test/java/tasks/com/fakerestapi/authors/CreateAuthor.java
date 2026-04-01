package tasks.com.fakerestapi.authors;

import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;
public class CreateAuthor {
	@Test
	public void createAuthorTest() {
		given()
		.contentType(ContentType.JSON)
		.body("{\r\n"
				+ "  \"id\": 21,\r\n"
				+ "  \"idBook\": 12,\r\n"
				+ "  \"firstName\": \"sam\",\r\n"
				+ "  \"lastName\": \"sam\"\r\n"
				+ "}")
		.when()
		.post("https://fakerestapi.azurewebsites.net/api/v1/Authors")
		
		.then()
		.log().all()
		.assertThat()
			.statusCode(200)
			.statusLine(containsString("HTTP"))
			.header("Content-Type", containsString("application/json"))
			.body("firstName", containsString("sam"))
			.body("lastName", containsString("sam"))
			.time(lessThan(5000L));
	}
	}

