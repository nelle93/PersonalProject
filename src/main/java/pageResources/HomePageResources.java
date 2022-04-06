package pageResources;

import java.util.ArrayList;
import java.util.List;

public enum HomePageResources {

    SearchFromCountryDrop("//span[contains(@id, 'from_country-container')]/parent::span"),
    SearchToCountryDrop("//span[contains(@id, 'to_country-container')]/parent::span"),
    InputFromCityDrop("//input[contains(@aria-controls, 'from_country-results')]"),
    InputToCityDrop("//input[contains(@aria-controls, 'to_country-results')]"),
    VisaButton("//button[@id='visa-tab']"),
    CheckIn("//form[@id='visa-submit']//input[@id='date']"),
    HomeButton("//a[text()='Home']"),
    SearchButton("//form[@id='visa-submit']//button[@id='submit']"),
    LanguagesButton("//button[@id='languages']"),
    CurrencyButton("//button[@id='currency']"),
    SupplierButton("//button[@id='supplier']"),
    AgentsButton("//button[@id='agents']");



    private final String resource;

    HomePageResources(String resource) {
        this.resource = resource;
    }

    public String getResource() {
        return resource;
    }

    public static List<String> getAllLocators() {

        List<String> listOfElements = new ArrayList<>();

        for (HomePageResources homePageResources : HomePageResources.values()) {
            listOfElements.add((homePageResources.getResource()));
        }
     return listOfElements;
    }

}