package responseValidation;

import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class postProduct {
@Test
public void postSingleProject() {
	given()
	.contentType(ContentType.JSON)
	.body("{\r\n"
			+ "  \"createdBy\": \"string1234x678yz\",\r\n"
			+ "  \"projectName\": \"string1234x678yz\",\r\n"
			+ "  \"status\": \"Ongoing\",\r\n"
			+ "  \"teamSize\": 0\r\n"
			+ "}")
	.when()
	.post("http://49.249.28.218:8091/addProject")
	
	.then()
	.log().all()
	.assertThat()
		.statusCode(201)
		.header("Content-Type", equalTo("application/json"))
		.body("projectName", containsString("string1234x678yz"))
		.time(lessThan(5000L));
}
}
