package pages;


import org.openqa.selenium.*;
import org.testng.asserts.SoftAssert;
import pageResources.GeneralResources;
import pageResources.HomePageResources;
import utility.BrowserDriverFactory;
import utility.PageFunctions;
import java.util.List;


public class HomePage extends PageFunctions {


    SoftAssert softAssert = new SoftAssert();

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void openHomePageURl() {
        driver.get(GeneralResources.homePageUrl.getResource());
    }

    public void clickHomeButton() {
        clickElement(HomePageResources.HomeButton.getResource());
    }

    public void checkAllHomePageElements() {
        checkIfAllElementsAreDisplayed(HomePageResources.getAllLocators(), softAssert);
    }
    public void clickVisaButton () {
        clickElement(HomePageResources.VisaButton.getResource());
    }

    public void clickAndInputCountryFrom(String countryFrom) {
        try {
            clickElement(HomePageResources.SearchFromCountryDrop.getResource());
            inputText(HomePageResources.InputFromCityDrop.getResource(), "Se");
            List<WebElement> countries = waitForAllElPresence("//ul[@id='select2-from_country-results']//li[contains(@class, 'results__option')]");
            for (WebElement country : countries) {
                if (country.getText().equals(countryFrom)) {
                    country.click();
                }
            }
        } catch (StaleElementReferenceException ignored) {
        }

    }
    public void clickAndInputCountryTo(String countryTo) {
        try {
            clickElement(HomePageResources.SearchToCountryDrop.getResource());
            inputText(HomePageResources.InputToCityDrop.getResource(), "Be");
            List<WebElement> countries = waitForAllElPresence("//ul[@id='select2-to_country-results']//li[contains(@class, 'results__option')]");
            for (WebElement country : countries) {
                if (country.getText().equals(countryTo)) {
                    country.click();
                }
            }
        } catch (StaleElementReferenceException ignored) {
        }

    }


    public void clickCheckinandChooseDate(String day, String expectedMonth) {
        String dayCheckin = "(//table)[19]//tbody//tr//td[@class='day '][(text()='" + day + "')]";
        clickElement(HomePageResources.CheckIn.getResource());
        String monthYear = "(//th[@class='switch'])[19]";
        String nextArrow = "(//th[@class='next'])[19]";
        WebElement elementMonth = waitIsDisplayed(monthYear);
        while (!elementMonth.getText().equals(expectedMonth))
        {
            clickElement(nextArrow);
        }
        clickElement(dayCheckin);
    }
    public VisaSubmitPage clickSubmitButton () {
        clickElement(HomePageResources.SearchButton.getResource());
        return new VisaSubmitPage(BrowserDriverFactory.getDriver());
    }

}







