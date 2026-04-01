package RequestBody;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import pojoClasses.createProject;

public class RequestBody_FromPOJO {
	@Test
	public void createProject() {
		createProject obj = new createProject();
		obj.setCreatedBy("Sam");
		obj.setProjectName("Sam1");
		obj.setStatus("Completed");
		obj.setTeamSize(0);
		
		RestAssured.given()
		.contentType(ContentType.JSON)
		.body(obj)
		
		.when()
		.post("http://49.249.28.218:8091/addProject")
		
		.then()
		.log().all();
	}
}
