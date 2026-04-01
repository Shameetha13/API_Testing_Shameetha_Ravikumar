package assignment1;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.util.*;

public class PetstoreWithHashMap {
	static long petId;
	@Test(priority = 1)
    public void createPetTest() {
      
        Map<String, Object> jsonBody = new HashMap<>();
        jsonBody.put("id", 1302); 
        jsonBody.put("name", "doggie");
        jsonBody.put("status", "available");
      
        Map<String, Object> category = new HashMap<>();
        category.put("id", 1);
        category.put("name", "Dogs");
        jsonBody.put("category", category);
       
        List<String> photoUrls = new ArrayList<>();
        photoUrls.add("https://example.com/dog.jpg");
        jsonBody.put("photoUrls", photoUrls);
   
        Map<String, Object> tag = new HashMap<>();
        tag.put("id", 1);
        tag.put("name", "friendly");

        List<Map<String, Object>> tags = new ArrayList<>();
        tags.add(tag);
        jsonBody.put("tags", tags);

       
        petId =given()
            .baseUri("https://petstore.swagger.io/v2")
            .contentType("application/json")
            .body(jsonBody) 
        .when()
            .post("/pet")
        .then()
            .log().all() 
            .statusCode(200)
            .body("name", equalTo("doggie"))
            .body("category.name", equalTo("Dogs"))
            .body("tags[0].name", equalTo("friendly"))
            .extract().jsonPath().getLong("id");;
    }
	@Test(priority = 2, dependsOnMethods = "createPetTest")
    public void getPetTest() {
        given()
            .baseUri("https://petstore.swagger.io/v2")
            .pathParam("petId", petId)
        .when()
            .get("/pet/{petId}")
        .then()
            .statusCode(200)
            .body("name", equalTo("doggie"));
    }

    @Test(priority = 3, dependsOnMethods = "getPetTest")
    public void updatePetTest() {
     
    	  Map<String, Object> updateBody = new HashMap<>();
    	  updateBody.put("id", 1302); 
    	  updateBody.put("name", "shamee_pet");
    	  updateBody.put("status", "sold");
        
          Map<String, Object> category = new HashMap<>();
          category.put("id", 1);
          category.put("name", "Dogs");
          updateBody.put("category", category);
         
          List<String> photoUrls = new ArrayList<>();
          photoUrls.add("https://example.com/dog.jpg");
          updateBody.put("photoUrls", photoUrls);
     
          Map<String, Object> tag = new HashMap<>();
          tag.put("id", 1);
          tag.put("name", "friendly");

          List<Map<String, Object>> tags = new ArrayList<>();
          tags.add(tag);
          updateBody.put("tags", tags);


        given()
            .baseUri("https://petstore.swagger.io/v2")
            .contentType("application/json")
            .body(updateBody)
        .when()
            .put("/pet")
        .then()
            .statusCode(200)
            .body("name", equalTo("shamee_pet"));
        System.out.println(updateBody);
    }

    @Test(priority = 4, dependsOnMethods = "updatePetTest")
    public void deletePetTest() {
        given()
            .baseUri("https://petstore.swagger.io/v2")
            .pathParam("petId", petId)
        .when()
            .delete("/pet/{petId}")
        .then()
            .statusCode(200); 
    }
}