package com.homePage;

import com.utils.Utilities;
import org.openqa.selenium.*;
import org.testng.asserts.SoftAssert;

public abstract class HomePage {

    SoftAssert softAssert = new SoftAssert();
    Utilities utils = new Utilities();


    //This method tests if user can close the switch language toast message when displayed
    int attempt = 0;
    public void closeToastMessage_shouldCloseLanguageToastMessage(WebDriver driver){
        try{
            WebElement toastMessageCloseBtn = utils.waitForElement(driver, "//button[@class='toast-close-button']");
            softAssert.assertTrue(toastMessageCloseBtn.getText().equals("×"));
            softAssert.assertAll();
            toastMessageCloseBtn.click();

        }catch(StaleElementReferenceException e){
            driver.navigate().refresh();
            attempt++;
            if(attempt < 3){
                closeToastMessage_shouldCloseLanguageToastMessage(driver);
            }
            else{
                System.out.println("Toast message close button has been deleted or is no longer attached to the DOM");
            }
        }catch(NoSuchElementException e){
            System.out.println("Toast message is not displayed");
        }
    }


    public abstract void downloadApp_shouldDownloadDesktopApp(WebDriver driver);
}
