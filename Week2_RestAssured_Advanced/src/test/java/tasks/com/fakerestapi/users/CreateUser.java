package tasks.com.fakerestapi.users;

import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;
public class CreateUser {
	@Test
	public void createUserTest() {
		given()
		.contentType(ContentType.JSON)
		.body("{\r\n"
				+ "  \"id\": 0,\r\n"
				+ "  \"userName\": \"sam\",\r\n"
				+ "  \"password\": \"sam123\"\r\n"
				+ "}")
		.when()
		.post("https://fakerestapi.azurewebsites.net/api/v1/Users")
		
		.then()
		.log().all()
		.assertThat()
			.statusCode(200)
			.statusLine(containsString("HTTP"))
			.header("Content-Type", containsString("application/json"))
			.body("userName", containsString("sam"))
			.time(lessThan(5000L));
	}
	}

