package stepDefinitions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.VisaSubmitPage;
import utility.BrowserDriverFactory;


public class HomeSteps {

    HomePage homePage;
    VisaSubmitPage visaSubmitPage;

    @Given("The user is on the home page")
    public void the_user_is_on_the_home_page() {
        homePage = new HomePage(BrowserDriverFactory.getDriver());
        homePage.openHomePageURl();
    }
    @When("The user navigates to the Home button")
    public void theUserClickOnTheHomeButton() {
        homePage.clickHomeButton();
    }
    @Then("All elements should be present")
    public void all_elements_should_be_present() {
        homePage.checkAllHomePageElements();
    }
    @And("enters {string} in the CountryFrom input field and {string} in the CountryTo input field")
    public void userClicksOnTheFromCountryButton(String countryFrom, String countryTo) {
        homePage.clickAndInputCountryFrom(countryFrom);
        homePage.clickAndInputCountryTo(countryTo);
    }
    @And("clicks on the Checkin date button and chooses {string} {string}")
    public void userClicksOnTheCheckinSearchButton(String day, String expectedMonth) {
        homePage.clickCheckinandChooseDate(day, expectedMonth);
    }

    @And("User clicks Visa button")
    public void userClicksVisaButton() {
        homePage.clickVisaButton();
    }

    @And("fills the submit form with {string}, {string}, {string}, {string}, {string}, {string}")
    public void fillsthesubmitfrom (String name, String surname, String email, String phone, String date, String notes) {
     visaSubmitPage.fillSubmitForm(name, surname, email, phone, date, notes);
    }


    @When("User clicks on the Submit button")
    public void userClicksOnTheSubmitButton() {
     visaSubmitPage = homePage.clickSubmitButton();
    }
}
