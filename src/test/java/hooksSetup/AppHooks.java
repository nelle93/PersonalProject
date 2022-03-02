package hooksSetup;

import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pageResources.GeneralResources;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import utility.AllureEnvironmentSetup;
import utility.BrowserDriverFactory;
import java.io.ByteArrayInputStream;


public class AppHooks {
    private WebDriver driver;

    @Before(order = 0)
    public void launchBrowser() {
        BrowserDriverFactory browserDriverFactory = new BrowserDriverFactory();
        driver = browserDriverFactory.init_driver(GeneralResources.browserName.getResource());

    }

    @Before(order = 1)
    public void getEnvironmentValues () {
        AllureEnvironmentSetup.readEnvironmentValues();
    }

    @After(order = 1)

        public void getScreenshotAllure(Scenario scenario) throws IllegalMonitorStateException
        {
            if(scenario.isFailed())
            {
                Allure.addAttachment(scenario.getName(), new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
            }
        }
    @After(order = 0)
    public void quitBrowser(){

        driver.quit();
    }


}

