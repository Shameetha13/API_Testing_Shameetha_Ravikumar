package tasks.com.fakerestapi.authors;

import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;
public class GetAuthorByBookId {
	@Test
	public void getAuthorsBookIdTest() {
		given()
		.pathParam("idBook",199)
		
		.when()
		.get("https://fakerestapi.azurewebsites.net/api/v1/Authors/authors/books/{idBook}")
		
		.then()
		.log().all()
		.assertThat()
			.statusCode(200)
			.statusLine(containsString("HTTP"))
			.header("Content-Type", containsString("application/json"))
			.time(lessThan(5000L));
	}
	}

