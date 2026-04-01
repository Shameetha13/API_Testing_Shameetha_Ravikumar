package crudOperation_petstore;
import io.restassured.RestAssured;


public class GetAllDetailsOfPet {
    public static void main(String[] args) {
        
        RestAssured.given()
        .when()
            .get("https://petstore.swagger.io/v2/pet/1")
        .then()
            .statusCode(200).log().all();
    }
}