package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/java/feature/CRUD.feature",
    glue = "stepDefinition",                            
    plugin = {
        "pretty",
        "html:target/cucumber-reports.html",           
        
    },
    monochrome = true                                 
)
public class TestRunner extends AbstractTestNGCucumberTests{
    
}




