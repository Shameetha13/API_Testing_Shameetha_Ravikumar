package tasks.com.fakerestapi.users;

import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;
public class DeleteUser {
	@Test
	public void deleteUserTest() {
		given()
		.pathParam("id", 1)
		.when()
		.get("https://fakerestapi.azurewebsites.net/api/v1/Users/{id}")
		
		.then()
		.log().all()
		.assertThat()
			.statusCode(200)
			.statusLine(containsString("HTTP"))
			.time(lessThan(5000L));
	}
	}

