package tasks.com.fakerestapi.books;

import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;
public class DeleteBook {
	@Test
	public void deleteBookTest() {
		given()
		.pathParam("id", 0)
		.when()
		.delete("https://fakerestapi.azurewebsites.net/api/v1/Books/{id}")
		
		.then()
		.log().all()
		.assertThat()
			.statusCode(200)
			.statusLine(containsString("HTTP"))
			.time(lessThan(5000L));
	}
	}

