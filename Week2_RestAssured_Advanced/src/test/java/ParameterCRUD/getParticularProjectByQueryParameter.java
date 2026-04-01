package ParameterCRUD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class getParticularProjectByQueryParameter {

	public class getParticularProjectByQuery {
		@Test
		public void getParticularProjectById() {
			RestAssured.given()
			.queryParam("projectId", "NH_PROJ_011")
			.when()
			.post("http://49.249.28.218:8091/project")
			.then()
			.log().all();
		}
	}

}
