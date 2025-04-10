package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features/correct_login.feature",
        glue = "stepDefinitions",
        plugin = {"pretty", "html:target/correct-login-cucumber-report.html"}
)
public class CorrectLoginTestRunner extends AbstractTestNGCucumberTests {
}
