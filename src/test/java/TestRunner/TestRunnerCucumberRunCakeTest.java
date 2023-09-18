package TestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:cucumber-reports/htmlreprt.html", "json:cucumber-reports/report.json",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        features = {"src/test/AcceptanceTest"},
        glue = {"StepDefinitions", "AppHooks"},
        publish = true,
        monochrome = true,
        dryRun = false,
        tags = ("@IRCTCBooking")

)


public class TestRunnerCucumberRunCakeTest {

}
