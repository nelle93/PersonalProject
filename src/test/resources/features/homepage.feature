Feature: Homepage scenarios and flight reservations

  Background:
    Given The user is on the home page

  Scenario: Check elements presence after clicking Home Button
    When The user navigates to the Home button
    Then All elements should be present


  Scenario: Check if Flight can be reserved
    And User clicks Visa button
    And enters "Senegal" in the CountryFrom input field and "Belgium" in the CountryTo input field
    And clicks on the Checkin date button and chooses "27" "September 2022"
    When User clicks on the Submit button
    And fills the submit form with "Nenad", "Jakovljevic", "nenad@gmail.com", "06012345678", "05-05-2022", "Beleske"
    Then Info message should be present on the page

