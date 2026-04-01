package responseValidation;

import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class getProject {
@Test
public void getSingleProject() {
	given()
	.pathParam("projectId", "NH_PROJ_278")
	.when()
	.get("http://49.249.28.218:8091/project/{projectId}")
	
	.then()
	.log().all()
	.assertThat()
		.statusCode(200)
		.time(lessThan(5000L));
}
}
