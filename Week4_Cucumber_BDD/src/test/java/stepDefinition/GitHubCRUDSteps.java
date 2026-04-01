package stepDefinition;
	
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.cucumber.java.en.*;

	

public class GitHubCRUDSteps {


	Response response;
    String token;
    String username;

    public GitHubCRUDSteps() {
        try {
            
            Properties prop = new Properties();
            FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
            prop.load(fis);
            
           
            this.token = prop.getProperty("github_token");
            this.username = prop.getProperty("github_username");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	    @Given("GitHub Base URI is set")
	    public void setBaseURI() {
	        baseURI = "https://api.github.com";
	    }

	    
	    @When("I create a repository with name {string} and description {string}")
	    public void createRepo(String repoName, String description) {

	        String body = "{\n" +
	                "  \"name\": \"" + repoName + "\",\n" +
	                "  \"description\": \"" + description + "\"\n" +
	                "}";

	        response = given()
	                .auth().oauth2(token)
	                .header("Accept", "application/vnd.github+json")
	                .contentType(ContentType.JSON)
	                .body(body)
	        .when()
	                .post("/user/repos");

	        response.then().log().all();
	    }

	    @When("I fetch repository {string}")
	    public void getRepo(String repoName) {

	        response = given()
	                .auth().oauth2(token)
	                .header("Accept", "application/vnd.github+json")
	        .when()
	                .get("/repos/" + username + "/" + repoName);

	        response.then().log().all();
	    }

	
	    @When("I update repository {string} with description {string}")
	    public void updateRepo(String repoName, String desc) {

	        String body = "{\n" +
	                "  \"description\": \"" + desc + "\"\n" +
	                "}";

	        response = given()
	                .auth().oauth2(token)
	                .header("Accept", "application/vnd.github+json")
	                .contentType(ContentType.JSON)
	                .body(body)
	        .when()
	                .patch("/repos/" + username + "/" + repoName);

	        response.then().log().all();
	    }

	 
	    @When("I delete repository {string}")
	    public void deleteRepo(String repoName) {

	        response = given()
	                .auth().oauth2(token)
	                .header("Accept", "application/vnd.github+json")
	        .when()
	                .delete("/repos/" + username + "/" + repoName);

	        response.then().log().all();
	    }

	  
	    @Then("the response status should be {int}")
	    public void validateStatus(int statusCode) {
	        response.then().statusCode(statusCode);
	    }

	    @Then("the repository name should be {string}")
	    public void validateRepoName(String repoName) {
	        response.then().body("name", equalTo(repoName));
	    }
	}