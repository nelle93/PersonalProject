package pages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageResources.GeneralResources;
import utility.BrowserDriverFactory;
import utility.PageFunctions;
import pageResources.LoginResources;



public class LoginPage extends PageFunctions {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void loginGetUrl () {
        driver.get(GeneralResources.loginUrl.getResource());

    }
    public void enterCredentials (String mailText, String passText) {
        inputText(LoginResources.InputMail.getResource(), mailText);
        inputText(LoginResources.InputPassword.getResource(), passText);

    }
    public void clickLogin () {
        clickElement(LoginResources.LoginButton.getResource());
    }
    public void checkLoginUrl () {
        Assert.assertEquals(driver.getCurrentUrl(), GeneralResources.loginPageUrlFailedLogin.getResource());
    }
    public void clickHomeButton () {
        clickElement(LoginResources.HomeButton.getResource());
    }

    public HomePage checkHomePageRedirection () {
        Assert.assertEquals(driver.getCurrentUrl(), GeneralResources.homePageUrl.getResource());
        return new HomePage(BrowserDriverFactory.getDriver());
    }




    }

