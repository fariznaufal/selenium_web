package runners;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {"json:target/results/facebook/cucumber-report.json",  "html:target/results/facebook"},
        features = "src/test/resources/features",
        glue = "steps",
        tags = {"@facebook"}

)
public class FacebookTestRunner extends BaseTestRunner
{

}
