package runners;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {"json:target/results/matahari/cucumber-report.json",  "html:target/results/matahari"},
        features = "src/test/resources/features",
        glue = "steps",
        tags = {"@Addbarang"}
)
public class MatahariTestRunner extends BaseTestRunner
{

}
