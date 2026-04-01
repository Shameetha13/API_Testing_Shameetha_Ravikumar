package tasks.com.fakerestapi.coverphotos;

import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;
public class DeleteCoverPhoto {
	@Test
	public void deleteBookbyIdTest() {
		given()
		.pathParam("id", 195)
		.when()
		.delete("https://fakerestapi.azurewebsites.net/api/v1/CoverPhotos/{id}")
		
		.then()
		.log().all()
		.assertThat()
			.statusCode(200)
			.statusLine(containsString("HTTP"))
			.time(lessThan(5000L));
	}
	}

