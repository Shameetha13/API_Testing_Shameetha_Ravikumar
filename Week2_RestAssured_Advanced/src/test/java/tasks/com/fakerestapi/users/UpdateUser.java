package tasks.com.fakerestapi.users;

import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;
public class UpdateUser {
	@Test
	public void updateUserTest() {
		given()
		.pathParam("id", 0)
		.contentType(ContentType.JSON)
		.body("{\r\n"
				+ "  \"id\": 0,\r\n"
				+ "  \"userName\": \"samupdate\",\r\n"
				+ "  \"password\": \"sam123\"\r\n"
				+ "}")
		.when()
		.put("https://fakerestapi.azurewebsites.net/api/v1/Users/{id}")
		
		.then()
		.log().all()
		.assertThat()
			.statusCode(200)
			.statusLine(containsString("HTTP"))
			.header("Content-Type", containsString("application/json"))
			.body("userName", containsString("samupdate"))
			.time(lessThan(5000L));
	}
	}

