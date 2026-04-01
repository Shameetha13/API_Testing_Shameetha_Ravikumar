package tasks.com.fakerestapi.books;

import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;
public class GetBook {
	@Test
	public void getBookTest() {
		given()
		
		.when()
		.get("https://fakerestapi.azurewebsites.net/api/v1/Books")
		
		.then()
		.log().all()
		.assertThat()
			.statusCode(200)
			.statusLine(containsString("HTTP"))
			.header("Content-Type", containsString("application/json"))
			.time(lessThan(5000L));
	}
	}

