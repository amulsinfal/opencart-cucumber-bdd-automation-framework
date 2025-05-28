package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
				features = "src/test/resources/features", 
				glue = { "stepdefinitions", "hooks" }, 
				dryRun = false,
				tags = "@Sanity or @Regression",
				plugin={"pretty","html:CucumberReports/CucumberReport.html"})
public class TestRunner {

}
