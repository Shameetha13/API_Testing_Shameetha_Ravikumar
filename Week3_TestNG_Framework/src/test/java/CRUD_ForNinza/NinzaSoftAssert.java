package CRUD_ForNinza;

import java.io.File;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class NinzaSoftAssert {
    String project_Id;

    @Test(priority = 1)
    public void createProject() {
        SoftAssert sa = new SoftAssert();
        File json_file = new File("./src/test/resources/CreateProject_data.json");
        
        Response response = given()
                .contentType(ContentType.JSON)
                .body(json_file)
                .when()
                .post("http://49.249.28.218:8091/addProject");

        project_Id = response.jsonPath().getString("projectId");

        sa.assertEquals(response.getStatusCode(), 201);
        sa.assertNotNull(project_Id);
//        sa.assertEquals(response.jsonPath().getString("msg"), "Successfully Added");
        
        sa.assertAll();
    }

    @Test(priority = 2, dependsOnMethods = "createProject")
    public void getProjectDetails() {
        SoftAssert sa = new SoftAssert();
        Response response = given()
            .pathParam("PID", project_Id)
        .when()
            .get("http://49.249.28.218:8091/project/{PID}");

        sa.assertEquals(response.getStatusCode(), 200);
        sa.assertEquals(response.jsonPath().get("projectId"), project_Id);
        sa.assertTrue(response.getContentType().contains("json"));
        
        sa.assertAll();
    }

    @Test(priority = 3, dependsOnMethods = "createProject")
    public void putProjectDetails() {
        SoftAssert sa = new SoftAssert();
        Response response = given()
        .contentType(ContentType.JSON)
        .body("{\"createdBy\": \"garishm162\",\"projectName\":\"gariishm122163\",\"status\": \"Ongoing\",\"teamSize\": 0}")
            .pathParam("PID", project_Id)
        .when()
            .put("http://49.249.28.218:8091/project/{PID}");

        sa.assertEquals(response.getStatusCode(), 200);
        sa.assertEquals(response.jsonPath().get("status"), "Ongoing");
        sa.assertTrue(response.getTime() < 3000);
        
        sa.assertAll();
    }

    @Test(priority = 4, dependsOnMethods = "createProject")
    public void deleteProjectDetails() {
        SoftAssert sa = new SoftAssert();
        Response response = given()
            .pathParam("PID", project_Id)
        .when()
            .delete("http://49.249.28.218:8091/project/{PID}");

        sa.assertEquals(response.getStatusCode(), 204);
        
        sa.assertAll();
    }
}