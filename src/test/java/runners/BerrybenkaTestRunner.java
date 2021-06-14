package runners;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {"json:target/results/berrybenka/cucumber-report.json",  "html:target/results/berrybenka"},
        features = "src/test/resources/features",
        glue = "steps",
        tags = {"@berrybenka"}

)
public class BerrybenkaTestRunner extends BaseTestRunner
{

}
