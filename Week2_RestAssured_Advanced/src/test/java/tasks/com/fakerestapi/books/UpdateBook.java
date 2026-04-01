package tasks.com.fakerestapi.books;

import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;
public class UpdateBook {
	@Test
	public void updateBookTest() {
		given()
		.pathParam("id", 0)
		.contentType(ContentType.JSON)
		.body("{\r\n"
				+ "  \"id\": 0,\r\n"
				+ "  \"title\": \"newtitleupdate\",\r\n"
				+ "  \"description\": \"updated\",\r\n"
				+ "  \"pageCount\": 0,\r\n"
				+ "  \"excerpt\": \"string\",\r\n"
				+ "  \"publishDate\": \"2026-03-12T03:57:02.057Z\"\r\n"
				+ "}")
		.when()
		.put("https://fakerestapi.azurewebsites.net/api/v1/Books/{id}")
		
		.then()
		.log().all()
		.assertThat()
			.statusCode(200)
			.statusLine(containsString("HTTP"))
			.header("Content-Type", containsString("application/json"))
			.body("title", containsString("newtitleupdate"))
			.time(lessThan(5000L));
	}
	}

