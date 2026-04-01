package ParameterCRUD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class UpdatePetWithFormData {

	public class updatePetTest {
		@Test
		public void getParticularProjectById() {
			RestAssured.given()
			.contentType(ContentType.URLENC)
			.pathParam("petId", "9223372036854775807")
			.formParam("name", "sam")
			.formParam("status", "Ongoing")
			.when()
			.post("https://petstore.swagger.io/v2/pet/{petId}")
			.then()
			.log().all();
		}
	}

}
