package runners;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {"json:target/results/hijabenka/cucumber-report.json",  "html:target/results/hijabenka"},
        features = "src/test/resources/features",
        glue = "steps",
        tags = {"@hijabenka"}

)

public class HijabenkaTestRunner extends BaseTestRunner {

}