package pageResources;

import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.devtools.v85.page.Page;
import org.testng.asserts.SoftAssert;
import utility.PageFunctions;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

public enum VisaSubmitPageResources {


    SubmissionForm("//h3[normalize-space()='Submission Form']"),
    FirstName("//input[@placeholder='First Name']"),
    LastName("//input[@placeholder='Last Name']"),
    Email("//input[@placeholder='Email']"),
    Phone("//input[@placeholder='Phone']"),
    Date("//input[@placeholder='Date']"),
    Notes("//textarea[@placeholder='Notes']"),
    Submit("//button[@id='submit']"),
    GotItCookie("//div[@id='cookie_disclaimer']//button[@id='cookie_stop']"),
    SubmitMessage("//h2[text()='Your visa form has been submitted']");

    private final String resource;

    VisaSubmitPageResources(String resource) {
        this.resource = resource;
    }

    public String getResource() {
        return resource;
    }

    public static List<String> getAllLocators() {

        List<String> listOfElements = new ArrayList<>();

        for (VisaSubmitPageResources visaSubmitPageResources : VisaSubmitPageResources.values()) {
            listOfElements.add((visaSubmitPageResources.getResource()));
        }
        return listOfElements;
    }


}



