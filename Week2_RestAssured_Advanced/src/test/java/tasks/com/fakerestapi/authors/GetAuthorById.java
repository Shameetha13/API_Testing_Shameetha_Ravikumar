package tasks.com.fakerestapi.authors;

import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;
public class GetAuthorById {
	@Test
	public void getAuthorsIdTest() {
		given()
		.pathParam("id", "21")
		
		.when()
		.get("https://fakerestapi.azurewebsites.net/api/v1/Authors/{id}")
		
		.then()
		.log().all()
		.assertThat()
			.statusCode(200)
			.statusLine(containsString("HTTP"))
			.header("Content-Type", containsString("application/json"))
			.time(lessThan(5000L));
	}
	}

