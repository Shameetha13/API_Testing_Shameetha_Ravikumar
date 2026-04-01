package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/java/feature/NinzaEmployee.feature",        
    glue = "stepDefinition",                   
    plugin = {
        "pretty",                              
        "html:target/cucumber-reports-NinzaEmployee.html",   
                  
    },
    monochrome = true                        
//    dryRun = false                             
)
public class NinzaEmployeeRunner extends AbstractTestNGCucumberTests {
}