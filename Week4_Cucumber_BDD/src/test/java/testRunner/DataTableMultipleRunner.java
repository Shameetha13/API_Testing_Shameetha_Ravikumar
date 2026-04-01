package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/feature/DataTableMultipleData.feature",
        glue = "stepDefinition",
        plugin = {"pretty", "html:target/report-datatable2.html"},
        monochrome = true
)
public class DataTableMultipleRunner extends AbstractTestNGCucumberTests {
	
}