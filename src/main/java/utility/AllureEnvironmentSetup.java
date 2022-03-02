package utility;

import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class AllureEnvironmentSetup {
   private static final Properties properties = new Properties();

    private static String browserName() {

            return ((RemoteWebDriver) BrowserDriverFactory.getDriver()).getCapabilities().getBrowserName();
    }
    private static String browserVersion() {

            return ((RemoteWebDriver)BrowserDriverFactory.getDriver()).getCapabilities().getBrowserVersion();
    }
    private static String operatingSystem () {
        return System.getProperty("os.name");
    }
    public static void readEnvironmentValues () {
        properties.setProperty("Browser", browserName());
        properties.setProperty("Browser Version", browserVersion());
        properties.setProperty("Operating System", operatingSystem());
    }
    public static void writeEnvironmentValues () {

        try (OutputStream outputStream = new FileOutputStream("target/allure-results/environment.properties")) {


            properties.store(outputStream, null);
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }


}
