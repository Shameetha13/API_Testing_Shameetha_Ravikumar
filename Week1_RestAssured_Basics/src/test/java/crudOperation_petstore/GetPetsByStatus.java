package crudOperation_petstore;
import io.restassured.RestAssured;


public class GetPetsByStatus {
    public static void main(String[] args) {
        
        RestAssured.given()
        .when()
            .get("https://petstore.swagger.io/v2/pet/findByStatus?status=pending")
        .then()
            .statusCode(200).log().all();
    }
}