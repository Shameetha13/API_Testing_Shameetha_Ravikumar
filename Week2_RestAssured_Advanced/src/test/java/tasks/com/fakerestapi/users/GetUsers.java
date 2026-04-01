package tasks.com.fakerestapi.users;

import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;
public class GetUsers {
	@Test
	public void getUserTest() {
		given()
		
		.when()
		.get("https://fakerestapi.azurewebsites.net/api/v1/Users")
		
		.then()
		.log().all()
		.assertThat()
			.statusCode(200)
			.statusLine(containsString("HTTP"))
			.header("Content-Type", containsString("application/json"))
			.time(lessThan(5000L));
	}
	}

