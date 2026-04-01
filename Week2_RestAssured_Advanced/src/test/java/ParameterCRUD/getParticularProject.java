package ParameterCRUD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class getParticularProject {
	@Test
	public void getParticularProjectById() {
		RestAssured.given()
		.pathParam("prjid","NH_PROJ_3374")
		.when()
		.get("http://49.249.28.218:8091/project/{prjid}")
		.then()
		.log().all();
	}
}
