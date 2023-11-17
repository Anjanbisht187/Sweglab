package cucumber.option;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/features",glue={"StepDefination" , "helper"},tags="@Reg",
//plugin="html:taget/reports/test.html" ,
plugin="json:target/jsonReports/test.json")
public class TestRunner {

}
//dryRun
//monoChrome