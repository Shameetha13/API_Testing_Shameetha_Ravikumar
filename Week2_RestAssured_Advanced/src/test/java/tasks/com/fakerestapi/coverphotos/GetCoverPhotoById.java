package tasks.com.fakerestapi.coverphotos;

import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;
public class GetCoverPhotoById {
	@Test
	public void getBookbyIdTest() {
		given()
	.pathParam("id", 195)
		.when()
		.get("https://fakerestapi.azurewebsites.net/api/v1/CoverPhotos/{id}")
		
		.then()
		.log().all()
		.assertThat()
			.statusCode(200)
			.statusLine(containsString("HTTP"))
			.header("Content-Type", containsString("application/json"))
			.time(lessThan(5000L));
	}
	}

