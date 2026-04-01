package github;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Github_API_Testing {
	static String name;
	static String owner;
	String token;
	@BeforeClass
    public void loadConfig() {
        try {
            Properties prop = new Properties();
           
            FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
            prop.load(fis);
            
  
            this.token = prop.getProperty("github_token");
        } catch (IOException e) {
            System.err.println("Error: Could not find config.properties in src/test/resources/");
            e.printStackTrace();
        }
    }
@Test(priority = 1)
public void createRepoTest(){
	
	File jsonfile = new File("./src/test/resources/Github_create.json");
	Response response = given()
	.auth().oauth2(token)
	.contentType(ContentType.JSON)
	.body(jsonfile)
	
	.when()
	.post("https://api.github.com/user/repos");
	name= response.jsonPath().getString("name");
	owner= response.jsonPath().getString("owner.login");
	System.out.println(name);
	System.out.println(owner);
	response.then().log().all().assertThat()
	.statusCode(201)
	.body("name", equalTo(name))
	.header("Content-Type", equalTo("application/json; charset=utf-8"))
	.time(lessThan(50000L));
	System.out.println("--------------------------------------------------------------------------------------------------");
}
@Test(priority = 2, dependsOnMethods = "createRepoTest")
public void getRepoTest(){
	System.out.println(name);
	System.out.println(owner);
	given()
	.pathParam("name", name)
	.pathParam("owner",owner)
	.auth().oauth2(token)
	.when()
	.get("https://api.github.com/repos/{owner}/{name}")
	.then()
	.log().all().assertThat()
	.statusCode(200)
	.body("name", equalTo(name))
	.header("Content-Type", equalTo("application/json; charset=utf-8"))
	.time(lessThan(50000L));
	System.out.println("--------------------------------------------------------------------------------------------------");
}
@Test(priority = 3, dependsOnMethods = "getRepoTest")
public void patchRepoTest(){
	System.out.println(name);
	System.out.println(owner);
	given()
	.pathParam("name", name)
	.pathParam("owner",owner)
	.auth().oauth2(token)
	.contentType(ContentType.JSON)
	.body("{\r\n"
			+ "  \"name\": \"sham6\",\r\n"
			+ "  \"description\": \"Hello\"\r\n"
			+ "}")
	.when()
	.patch("https://api.github.com/repos/{owner}/{name}")
	.then()
	.log().all().assertThat()
	.statusCode(200)
	.body("name", equalTo(name))
	.header("Content-Type", equalTo("application/json; charset=utf-8"))
	.time(lessThan(50000L));
	System.out.println("--------------------------------------------------------------------------------------------------");
}
@Test(priority = 4, dependsOnMethods = "patchRepoTest")
public void deleteRepoTest(){
	System.out.println(name);
	System.out.println(owner);
	given()
	.pathParam("name", name)
	.pathParam("owner",owner)
	.auth().oauth2(token)
	.when()
	.delete("https://api.github.com/repos/{owner}/{name}")
	.then()
	.log().all().assertThat()
	.statusCode(204)
	.time(lessThan(50000L));
	System.out.println("--------------------------------------------------------------------------------------------------");
}
}
