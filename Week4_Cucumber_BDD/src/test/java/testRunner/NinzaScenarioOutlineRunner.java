package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/feature/NinzaScenarioOutline.feature",
        glue = "stepDefinition",                                  
        plugin = {
                "pretty",
                "html:target/cucumber-report-scenario-outline.html",
                
        },
        monochrome = true
)
public class NinzaScenarioOutlineRunner extends AbstractTestNGCucumberTests {

}