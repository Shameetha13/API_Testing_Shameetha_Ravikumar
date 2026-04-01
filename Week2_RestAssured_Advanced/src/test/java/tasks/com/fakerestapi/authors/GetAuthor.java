package tasks.com.fakerestapi.authors;

import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;
public class GetAuthor {
	@Test
	public void getAuthorsTest() {
		given()
		
		.get("https://fakerestapi.azurewebsites.net/api/v1/Authors")
		
		.then()
		.log().all()
		.assertThat()
			.statusCode(200)
			.statusLine(containsString("HTTP"))
			.header("Content-Type", containsString("application/json"))
			.time(lessThan(5000L));
	}
	}

