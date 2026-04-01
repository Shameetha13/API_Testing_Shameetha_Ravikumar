package requestChaining;
import java.io.File;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
public class APIChainingForNinza {
    String project_Id; 
    @Test(priority = 1)
    public void createProject() {
        File json_file = new File("./src/test/resources/CreateProject_data.json");
        Response response = given()
                .contentType(ContentType.JSON)
                .body(json_file)
                .when()
                .post("http://49.249.28.218:8091/addProject");
              
        response.prettyPrint();
      
        project_Id = response.jsonPath().getString("projectId"); 
        response.then()
        .log().all()
        .assertThat().statusCode(201);
        System.out.println("The ProjectId is saved as ---> " + project_Id);
    }
    @Test(priority = 2, dependsOnMethods = "createProject")
    public void getProjectDetails() {
        System.out.println("Fetching details for ID: " + project_Id);

        given()
            .pathParam("PID", project_Id)
        .when()
            .get("http://49.249.28.218:8091/project/{PID}")
        .then()
            .log().all()
            .assertThat().statusCode(200);
    }
    @Test(priority = 3 , dependsOnMethods = "createProject")
    public void putProjectDetails() {
        System.out.println("Fetching details for ID: " + project_Id);

        given()
        .contentType(ContentType.JSON)
        .body("{\r\n"
        		+ "	\"createdBy\": \"garishm162\",\r\n"
        		+ "    \"projectName\":\"gariishm122163\",\r\n"
        		+ "	\"status\": \"Ongoing\",\r\n"
        		+ "	\"teamSize\": 0\r\n"
        		+ "}")
            .pathParam("PID", project_Id)
        .when()
            .put("http://49.249.28.218:8091/project/{PID}")
        .then()
            .log().all()
            .assertThat().statusCode(200);
    }
    @Test(priority = 4 , dependsOnMethods = "createProject")
    public void deleteProjectDetails() {
        System.out.println("Fetching details for ID: " + project_Id);

        given()
            .pathParam("PID", project_Id)
        .when()
            .delete("http://49.249.28.218:8091/project/{PID}")
        .then()
            .log().all()
            .assertThat().statusCode(204);
    }
}