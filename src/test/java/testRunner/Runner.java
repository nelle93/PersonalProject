package testRunner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterSuite;
import utility.AllureEnvironmentSetup;
import utility.AllureReportingUtils;
import java.io.IOException;

@CucumberOptions(
        plugin = {"pretty", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},
        features = "src/test/resources/features/",
        glue = {"stepDefinitions"},
        monochrome = true
)

public class Runner extends AbstractTestNGCucumberTests {


    @AfterSuite
    public void generateAllureReport () throws IOException, InterruptedException {
        AllureEnvironmentSetup.writeEnvironmentValues();
        AllureReportingUtils.main();

    }

}
