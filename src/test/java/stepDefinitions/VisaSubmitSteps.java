package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.VisaSubmitPage;
import utility.BrowserDriverFactory;

public class VisaSubmitSteps {

    VisaSubmitPage visaSubmitPage;



        @Then("Info message should be present on the page")
        public void resultsShouldBePresentOnThePage() {
            visaSubmitPage = new VisaSubmitPage(BrowserDriverFactory.getDriver());
            visaSubmitPage.checkVisibilityOfSubmitMessage();
        }
    }

