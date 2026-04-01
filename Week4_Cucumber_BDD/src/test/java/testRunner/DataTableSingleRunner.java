package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/feature/DataTableSingleData.feature",
        glue = "stepDefinition",
        plugin = {"pretty", "html:target/report-datatable1.html"},
        monochrome = true
)
public class DataTableSingleRunner extends AbstractTestNGCucumberTests {
	
}