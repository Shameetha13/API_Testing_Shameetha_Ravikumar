package RequestBody;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class RequestBody_FromMethod {

    public static void main(String[] args) {

        //pre-conditions
        RestAssured.given()
            .contentType(ContentType.JSON)
            .body(Payload.CreateAProject())

        //HTTP Method
        .when()
            .post("http://49.249.28.218:8091/addProject")

        //Response Section
        .then()
            .log().all();
    }
}