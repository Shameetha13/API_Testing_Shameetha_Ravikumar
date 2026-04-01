package RequestBody;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class RequestBody_FromExternalFile {
	@Test
	public void createProject() {
		File jsonfile = new File("./src/test/resources/CreateProject_data.json");
		
		RestAssured.given()
		.contentType(ContentType.JSON)
		.body(jsonfile)
		
		.when()
		.post("http://49.249.28.218:8091/addProject")
		
		.then()
		.log().all();
	}
}
