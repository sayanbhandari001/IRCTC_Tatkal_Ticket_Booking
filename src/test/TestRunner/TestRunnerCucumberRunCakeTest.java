package TestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = { "html:cucumber-reports/htmlreprt.html", "json:cucumber-reports/report.json" },
        features = {"src/test/Resources/AcceptanceTest"},
        glue = {"src/test/java/StepDefinitions"},
        publish = true,
        monochrome=true,
        dryRun=true,
        tags = ("@IRCTCBooking")
)


public class TestRunnerCucumberRunCakeTest {

}
