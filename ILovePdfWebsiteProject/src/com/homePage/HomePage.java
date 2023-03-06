package com.homePage;

import com.pom.HomePagePO;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public abstract class HomePage {

    WebDriver driver;
    SoftAssert softAssert = new SoftAssert();
    HomePagePO homePage;


    public HomePage (WebDriver driver){
        this.driver = driver;
        homePage = new HomePagePO(driver);
    }


    //This method tests if user can close the switch language toast message when displayed
    int attempt = 0;
    public void closeToastMessage_shouldCloseLanguageToastMessage(){
        try{
            homePage.closeToastMessage();
            softAssert.assertNotNull(homePage.getTextToastMessage());
            softAssert.assertAll();
            Assert.assertEquals(1, 2);

        }catch(StaleElementReferenceException e){
            driver.navigate().refresh();
            attempt++;
            if(attempt < 3){
                closeToastMessage_shouldCloseLanguageToastMessage();
            }
            else{
                System.out.println("Toast message close button has been deleted or is no longer attached to the DOM");
            }
        }catch(NoSuchElementException e){
            System.out.println("Toast message is not displayed");
        }
    }


    public abstract void downloadApp_shouldDownloadDesktopApp();
}
