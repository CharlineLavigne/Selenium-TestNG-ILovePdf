package com.homePage;

import com.pom.HomePagePO;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomePageWindows extends HomePage{

    HomePagePO homepage;

    public HomePageWindows(WebDriver driver) {
        super(driver);
        homepage = new HomePagePO(driver);
    }


    //This method tests if the ILovePdf desktop app can be downloaded for windows(64)
    public void downloadApp_shouldDownloadDesktopApp(){
        homepage.clickIconDesktopDownload();
        try{
            homePage.downloadDesktopApp();
            Assert.assertTrue(homepage.getTestDownloadDesktopAppWin().equals("Download for Windows"));
        }catch(AssertionError e){
            homepage.selectSystemDesktopApp();
            homepage.selectDesktopAppWin();
        }
        driver.navigate().back();
    }
}
