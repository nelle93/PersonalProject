package utility;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class AllureEnvironmentSetup {
    static Properties properties = new Properties();

    public static String browserName() {
        Capabilities cap = ((RemoteWebDriver)BrowserDriverFactory.getDriver()).getCapabilities();
        return cap.getBrowserName();
    }
    public static String browserVersion() {
        Capabilities cap = ((RemoteWebDriver)BrowserDriverFactory.getDriver()).getCapabilities();
        return cap.getBrowserVersion();
    }
    public static String operatingSystem () {
        return System.getProperty("os.name");
    }
    public static void main() {


        try (OutputStream outputStream = new FileOutputStream("target/allure-results/environment.properties")) {
          properties.setProperty("Browser", browserName());
          properties.setProperty("Browser Version", browserVersion());
          properties.setProperty("Operating System", operatingSystem());

          properties.store(outputStream, null);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
