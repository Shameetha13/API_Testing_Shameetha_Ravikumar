package tasks.com.fakerestapi.coverphotos;

import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;
public class UpdateCoverPhoto {
	@Test
	public void updateBookTest() {
		given()
		.pathParam("id", 195)
		.contentType(ContentType.JSON)
		.body("{\r\n"
				+ "  \"id\": 195,\r\n"
				+ "  \"idBook\": 12,\r\n"
				+ "  \"url\": \"helloupdate\"\r\n"
				+ "}")
		.when()
		.put("https://fakerestapi.azurewebsites.net/api/v1/CoverPhotos/{id}")
		
		.then()
		.log().all()
		.assertThat()
			.statusCode(200)
			.statusLine(containsString("HTTP"))
			.header("Content-Type", containsString("application/json"))
			.body("url", containsString("hello"))
			.time(lessThan(5000L));
	}
	}

