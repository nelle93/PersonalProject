package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import utility.AllureEnvironmentSetup;
import utility.AllureReportingUtils;
import utility.BrowserDriverFactory;

import java.io.IOException;

@CucumberOptions(
        plugin = {"pretty", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},
        features = "src/test/resources/features/homepage.feature",
        glue = {"stepDefinitions"},
        monochrome = true
)

public class TestNGrunner extends AbstractTestNGCucumberTests {
    private WebDriver driver;
    @Parameters("browser")
    @BeforeMethod
    public void startCrossBrowserTesting (@Optional String browser) {
    BrowserDriverFactory browserDriverFactory = new BrowserDriverFactory();
    driver = browserDriverFactory.init_driver(browser);
    AllureEnvironmentSetup.readEnvironmentValues();

    }
    @AfterMethod
    public void closeBrowsers () {
     driver.quit();
    }


    @AfterSuite
    public void generateAllureReport () throws IOException, InterruptedException {
        AllureEnvironmentSetup.writeEnvironmentValues();
        AllureReportingUtils.main();

    }

}