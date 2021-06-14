package runners;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {"json:target/results/sociolla/cucumber-report.json",  "html:target/results/sociolla"},
        features = "src/test/resources/features",
        glue = "steps",
        tags = {"@sociolla"}

)
public class SociollaTestRunner extends BaseTestRunner
{

}
