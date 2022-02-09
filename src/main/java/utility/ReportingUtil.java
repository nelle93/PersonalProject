package utility;

import com.google.common.io.Files;
import io.cucumber.java.Scenario;
import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;


public class ReportingUtil {

    static final String ProjectPath = "C:/Users/njakovljevic/IdeaProjects/PersonalSeleniumProject/";
    static final String ResultPath = "target/allure-results";
    static final String ReportPath = "target/allure-report";
    static final File dirFrom = new File(ProjectPath + ReportPath + "/history");
    static final File dirTo = new File(ProjectPath + ResultPath + "/history");

    public static void main() throws InterruptedException, IOException {
        if (dirFrom.exists() && dirTo.exists()) {
            Thread.sleep(1000);
            moveFile();
            Thread.sleep(1000);
            generateAllureReport();
        } else if (dirTo.exists() && !dirFrom.exists()) {
            generateAllureReport();
            Thread.sleep(1000);
            moveFile();
        }

    }


    public static void moveFile() throws IOException {

           FileUtils.copyDirectory(dirFrom, dirTo);

    }

    public static void generateAllureReport() throws IOException {

        ProcessBuilder builder = new ProcessBuilder(
                "cmd.exe", "/c", "allure generate " + ProjectPath + ResultPath + " -o " + ProjectPath + ReportPath + " --clean");
        builder.redirectErrorStream(true);
        Process p = builder.start();
        BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line;
        while (true) {
            line = r.readLine();
            if (line == null) {
                break;
            }
            System.out.println(line);
        }

    }



}


