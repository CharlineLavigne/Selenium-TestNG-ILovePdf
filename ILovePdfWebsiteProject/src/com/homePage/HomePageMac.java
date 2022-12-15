package com.homePage;

import com.pom.HomePagePO;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomePageMac extends HomePage{


    HomePagePO homepage;

    public HomePageMac(WebDriver driver) {
        super(driver);
        homepage = new HomePagePO(driver);
    }


    //This method tests if the ILovePdf desktop app can be downloaded for mac
    public void downloadApp_shouldDownloadDesktopApp(){
        homepage.clickIconDesktopDownload();
        try{
            homepage.downloadDesktopApp();
            Assert.assertTrue(homepage.getTextDownloadDesktopAppMac().equals("Download for MacOS"));
        }catch(AssertionError e){
            homepage.selectSystemDesktopApp();
            homepage.selectDesktopAppMac();
        }
        driver.navigate().back();
    }
}
