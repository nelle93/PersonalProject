package pages;

import org.openqa.selenium.WebDriver;
import pageResources.VisaSubmitPageResources;
import utility.PageFunctions;

public class VisaSubmitPage extends PageFunctions {

    public VisaSubmitPage(WebDriver driver) {
        super(driver);
    }

    public void fillSubmitForm (String name, String surname, String email, String phone, String date, String notes) {
        inputText(VisaSubmitPageResources.FirstName.getResource(), name);
        inputText(VisaSubmitPageResources.LastName.getResource(), surname);
        inputText(VisaSubmitPageResources.Email.getResource(), email);
        inputText(VisaSubmitPageResources.Phone.getResource(), phone);
        inputText(VisaSubmitPageResources.Date.getResource(), date);
        inputText(VisaSubmitPageResources.Notes.getResource(), notes);
        clickElement(VisaSubmitPageResources.GotItCookie.getResource());
        clickElement(VisaSubmitPageResources.Submit.getResource());
    }
    public void clickGotItButton () {
        clickElement(VisaSubmitPageResources.GotItCookie.getResource());
    }
    public void checkVisibilityOfSubmitMessage () {
        waitAndCheckIsVisibleTen(VisaSubmitPageResources.SubmitMessage.getResource());
    }
}
