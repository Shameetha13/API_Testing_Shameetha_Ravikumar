package tasks.com.fakerestapi.books;

import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;
public class CreateBook {
	@Test
	public void createBookTest() {
		given()
		.contentType(ContentType.JSON)
		.body("{\r\n"
				+ "  \"id\": 0,\r\n"
				+ "  \"title\": \"newtitle\",\r\n"
				+ "  \"description\": \"string\",\r\n"
				+ "  \"pageCount\": 0,\r\n"
				+ "  \"excerpt\": \"string\",\r\n"
				+ "  \"publishDate\": \"2026-03-12T03:57:02.057Z\"\r\n"
				+ "}")
		.when()
		.post("https://fakerestapi.azurewebsites.net/api/v1/Books")
		
		.then()
		.log().all()
		.assertThat()
			.statusCode(200)
			.statusLine(containsString("HTTP"))
			.header("Content-Type", containsString("application/json"))
			.body("title", containsString("newtitle"))
			.time(lessThan(5000L));
	}
	}

