package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features/wrong_login.feature",
        glue = "stepDefinitions",
        plugin = {"pretty", "html:target/wrong-login-cucumber-report.html"}
)
public class WrongLoginTestRunner extends AbstractTestNGCucumberTests {
}
