package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="./src/test/java/feature/FakeRestAPI.feature"
,glue="stepDefinition",
plugin= {"pretty","html:target/report.html"},
monochrome=true)


public class fakeRestAPIRunner extends AbstractTestNGCucumberTests {

}