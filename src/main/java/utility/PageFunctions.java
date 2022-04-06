package utility;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;



public abstract class PageFunctions {

    protected WebDriverWait wait;
    protected WebDriver driver;


    public PageFunctions(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    protected WebElement waitIsPresent(String locator) {

        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));

    }
    protected WebDriverWait waitTimeoutToCustomSeconds(int dur) {
        return new WebDriverWait(driver, Duration.ofSeconds(dur));
    }
    protected WebElement waitIsDisplayed (String locator) {

       return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }

    protected List<WebElement> waitForAllElPresence (String locator) {

        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(locator)));
    }

    protected boolean waitAndCheckIsVisibleFive(String locator) {

        return waitTimeoutToCustomSeconds(5).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator))).isDisplayed();

    }
    protected boolean waitAndCheckIsVisibleTen(String locator) {

        return waitTimeoutToCustomSeconds(10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator))).isDisplayed();

    }

    protected WebElement waitIsClickable(String locator) {

        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));

    }

    protected void switchToIframe(String iFrame) {
        try {
            driver.switchTo().frame(iFrame);
        } catch (NoSuchFrameException e) {
            Assert.fail("The iFrame " + iFrame + "doesn't exist. Check structure.");
        }
    }

    protected void clickElement(String locator) {
        waitIsClickable(locator).click();
    }


    protected void inputText(String locator, String text) {
        waitIsClickable(locator).sendKeys(text);
    }

    protected void isTextEqual(String locator, String expectedText) {
        WebElement element;
        element = waitIsPresent(locator);
        String actualText = element.getText();
        if (!actualText.equals(expectedText)) {
            Assert.fail("Element actually have text [ " + actualText + " ] but it should have text [ " + expectedText + " ]");
        }
    }
    protected void getElementValue(String locator) {
        waitIsPresent(locator);
        driver.findElement(By.xpath(locator)).getAttribute("value");
    }
    protected void getElementText (String locator) {
        waitIsPresent(locator);
        driver.findElement(By.xpath(locator)).getText();
    }
    protected void checkIfAllElementsAreDisplayed (List<String> allElements, SoftAssert softAssert) {
       for (String el : allElements) {


           try {

           softAssert.assertTrue(waitAndCheckIsVisibleFive(el));



           } catch (NoSuchElementException | TimeoutException e) {
               softAssert.fail("Element with xpath: " + el + " is not displayed on the page!");
           }
       }
       softAssert.assertAll();
   }
   protected List<String> listaListaMnogo (List<String> lst, String text) {
        List<String> new_lst = new ArrayList<>();
       for(String el: lst) {
           if (el.contains(text)) {
              new_lst.add(el);
           }
       }
       return new_lst;
   }
   protected void scrollToElement (String locator) {
       ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", waitIsClickable(locator));
   }

}




