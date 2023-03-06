package com.tests;

import com.excelToPdfPage.ExcelToPdf;
import com.excelToPdfPage.ExcelToPdfMac;
import com.homePage.HomePage;
import com.homePage.HomePageMac;
import com.homePage.HomePageWindows;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest{

    ExcelToPdf excelToPdfPageMac;
    HomePage homePageMac;
    HomePage homePageWindows;


    @BeforeClass
    public void setupDriver(){
        excelToPdfPageMac = new ExcelToPdfMac(BaseTest.driver);
        homePageMac = new HomePageMac(BaseTest.driver);
        homePageWindows = new HomePageWindows(BaseTest.driver);
    }


    @Test(priority = 1, groups = {"homePage"})
    public void closeToastMessage(){
        homePageMac.closeToastMessage_shouldCloseLanguageToastMessage();
    }


    @Parameters({"system"})
    @Test(priority = 2, groups = "homePage")
    public void downloadDesktopApp(String system){
        if(system.equals("windows")){
            homePageWindows.downloadApp_shouldDownloadDesktopApp();
        }
        else if(system.equals("mac")){
            homePageMac.downloadApp_shouldDownloadDesktopApp();
        }
    }


    @Parameters({"excelPdfTitle"})
    @Test(priority = 3, groups = {"homePage"})
    public void accessExcelToPdf(String excelPdfTitle){
        excelToPdfPageMac.accessExcelToPdf_shouldAccessExcelToPdfPageFromHome(excelPdfTitle);
    }
}
