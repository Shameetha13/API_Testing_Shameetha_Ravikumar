package ParameterCRUD;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class uploadImage {

		@Test
		public void uploadImageTest() {
			File fileupload = new File("./src/test/java/ParameterCRUD/getParticularProject.java");
			RestAssured.given()
			.contentType(ContentType.MULTIPART)
			.pathParam("petId", "9223372036854775807")
			.formParam("additionalMetadata", "sam")
			.multiPart("file", fileupload)
			.when()
			.post("https://petstore.swagger.io/v2/pet/{petId}/uploadImage")
			.then()
			.log().all();
		}
	}

