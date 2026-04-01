package assignment1;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import pojoclasses.CrudPet;
import pojoclasses.CrudPet.Category;
import pojoclasses.CrudPet.Tag;

import static org.hamcrest.Matchers.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CrudPetstore {
    
    static int petId = 1302;

    @Test(priority = 1)
    public void createPet() {
        CrudPet pet = new CrudPet();
        pet.setId(petId);
        pet.setName("doggie");
        pet.setStatus("available");

        Category cat = new Category(1, "Dogs");
        pet.setCategory(cat);

        pet.setPhotoUrls(Arrays.asList("https://example.com/image.png"));

        Tag myTag = new Tag(1, "friendly");
        List<Tag> tagsList = new ArrayList<>();
        tagsList.add(myTag);
        pet.setTags(tagsList);

        RestAssured.given()
            .contentType(ContentType.JSON)
            .body(pet) 
        .when()
            .post("https://petstore.swagger.io/v2/pet")
        .then()
            .log().all()
            .statusCode(200)
            .body("name", equalTo("doggie"));
    }

    @Test(priority = 2, dependsOnMethods = "createPet")
    public void getPet() {
        RestAssured.given()
            .pathParam("petId", petId)
        .when()
            .get("https://petstore.swagger.io/v2/pet/{petId}")
        .then()
            .log().all()
            .statusCode(200)
            .body("id", equalTo(petId))
            .body("name", equalTo("doggie"));
    }

    @Test(priority = 3, dependsOnMethods = "getPet")
    public void updatePet() {
        CrudPet petUpdate = new CrudPet();
        petUpdate.setId(petId);
        petUpdate.setName("doggie_updated"); 
        petUpdate.setStatus("sold");         
        
        petUpdate.setCategory(new Category(1, "Dogs"));
        petUpdate.setTags(Arrays.asList(new Tag(1, "friendly")));
        petUpdate.setPhotoUrls(Arrays.asList("https://example.com/image.png"));

        RestAssured.given()
            .contentType(ContentType.JSON)
            .body(petUpdate)
        .when()
            .put("https://petstore.swagger.io/v2/pet")
        .then()
            .log().all()
            .statusCode(200)
            .body("name", equalTo("doggie_updated"))
            .body("status", equalTo("sold"));
    }

    @Test(priority = 4, dependsOnMethods = "updatePet")
    public void deletePet() {
        RestAssured.given()
            .pathParam("petId", petId)
        .when()
            .delete("https://petstore.swagger.io/v2/pet/{petId}")
        .then()
            .log().all()
            .statusCode(200);

        RestAssured.given()
            .pathParam("petId", petId)
        .when()
            .get("https://petstore.swagger.io/v2/pet/{petId}")
        .then()
            .statusCode(404);
    }
}