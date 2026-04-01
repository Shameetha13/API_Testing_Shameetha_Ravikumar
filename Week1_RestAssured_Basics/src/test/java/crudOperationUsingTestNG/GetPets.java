package crudOperationUsingTestNG;
import org.testng.annotations.Test;
import io.restassured.RestAssured;

public class GetPets {
	@Test
	public void getPetTest() {
		 //pre-condition
	 RestAssured.given()
     .when()
         .get("https://petstore.swagger.io/v2/pet/findByStatus?status=pending")
     .then()
         .statusCode(200).log().all();
	}
}
