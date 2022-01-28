package testRunner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
//@CucumberOptions(features = "/Users/adilraza/Downloads/New/Arabits_automation_v1/src/test/Features/UserProfile.feature",
//                 glue = "stepDefinations")
@CucumberOptions(
//        features = "/Users/adilraza/Downloads/New/Arabits_automation_v1/src/test/Features/UserProfile2.feature",
        features = "/Users/adilraza/Downloads/New/Arabits_automation_v1/src/test/Features", tags = "@regression",
        glue = "stepDefinations",
        plugin = {"pretty",
                "rerun:target/failedrerun.txt", //Creates a text file with failed scenarios
                "json:target/cucumber.json"}

)
public class TestRunner {
}
