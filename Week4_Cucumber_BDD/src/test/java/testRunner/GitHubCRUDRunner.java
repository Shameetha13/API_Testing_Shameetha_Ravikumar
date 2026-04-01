package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/feature/GitHubCRUD.feature",
        glue = "stepDefinition",
        plugin = {"pretty", "html:target/cucumber-report-gitS.html"},
        monochrome = true
)


	public class GitHubCRUDRunner extends AbstractTestNGCucumberTests {

}