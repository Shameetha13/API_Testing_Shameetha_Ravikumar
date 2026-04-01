package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/java/feature/NinzaCRUD.feature",
    glue = "stepDefinition",
    plugin = {"pretty", "html:target/cucumber-report.html"},
    monochrome = true
)

public class NinzaRunner extends AbstractTestNGCucumberTests {
}