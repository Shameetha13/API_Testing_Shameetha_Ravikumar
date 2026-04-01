package tasks.com.fakerestapi.authors;

import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;
public class DeleteAuthor {
	@Test
	public void deleteAuthorTest() {
		given()
		.pathParam("id", "21")
		
		.when()
		.delete("https://fakerestapi.azurewebsites.net/api/v1/Authors/{id}")
		
		.then()
		.log().all()
		.assertThat()
			.statusCode(200)
			.statusLine(containsString("HTTP"))
			.time(lessThan(5000L));
	}
	}

