package crudOperationUsingTestNG;
import org.testng.annotations.Test;
import io.restassured.RestAssured;

public class DeletePet {
	@Test
	public void deletePetTest() {

	 //pre-condition
    RestAssured.given()
        
    //HTTP Method
    .when()
        .delete("https://petstore.swagger.io/v2/pet/9223372036854775807")

    // Response section
    .then()
        .log().all();
}
}
