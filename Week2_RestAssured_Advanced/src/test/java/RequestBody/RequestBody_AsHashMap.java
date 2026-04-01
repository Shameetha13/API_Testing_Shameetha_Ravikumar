package RequestBody;

import java.util.HashMap;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class RequestBody_AsHashMap {

    public static void main(String[] args) {
        
        // Creating the body using a HashMap
        HashMap<Object, Object> json_body = new HashMap<Object, Object>();
        json_body.put("createdBy", "ABCDEF");
        json_body.put("projectName", "PECC_1");
        json_body.put("status", "Completed");
        json_body.put("teamSize",0);

        // pre-condition
        RestAssured.given()
            .contentType(ContentType.JSON)
            .body(json_body)
            .log().all()

        // HTTP Method
        .when()
            .post("http://49.249.28.218:8091/addProject")

        // Response section
        .then()
            .log().all();
    }
}