package com.tests;

import com.excelToPdfPage.ExcelToPdf;
import com.excelToPdfPage.ExcelToPdfMac;
import com.homePage.HomePage;
import com.homePage.HomePageMac;
import com.utils.Base;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;

public class SafariBrowserMac extends Base {

    public WebDriver driver;
    ExcelToPdf excelToPdfPageMac;
    HomePage homePageMac;


    @BeforeClass
    public void setup() throws MalformedURLException {
        driver = initializeBrowser("safari");
        driver.get("https://www.ilovepdf.com/");
        driver.manage().window().maximize();
        excelToPdfPageMac = new ExcelToPdfMac(driver);
        homePageMac = new HomePageMac(driver);
    }


    @Test(priority = 1, groups = {"homePage"})
    public void closeToastMessage() {
        homePageMac.closeToastMessage_shouldCloseLanguageToastMessage();
    }


    @Test(priority = 2, groups = {"homePage"})
    public void downloadDesktopApp() {

        homePageMac.downloadApp_shouldDownloadDesktopApp();
    }


    @Test(priority = 3, groups = {"homePage"})
    public void accessExcelToPdf() {
        excelToPdfPageMac.accessExcelToPdf_shouldAccessExcelToPdfPageFromHome();
    }


    @Test(priority = 4, groups = {"excelToPdf"}, dependsOnMethods = "accessExcelToPdf")
    public void checkDataTest() throws FileNotFoundException {
        excelToPdfPageMac.checkDataTest_shouldVerifyExcelData("/Users/charlinelavigne/Desktop/GitProjects/ILovePdfWebSite/ILovePdfWebsiteProject/src/com/data/ShoppingListData.xlsx", "Apple", "2", "Ananas", 0, 1, 5);
    }


    @Test(priority = 5, groups = {"excelToPdf"}, dependsOnMethods = "accessExcelToPdf")
    public void uploadExcel() throws IOException {
        excelToPdfPageMac.uploadExcel_shouldUploadExcelFile("/Users/charlinelavigne/Desktop/GitProjects/ILovePdfWebSite/fileUploadScript.scpt");
    }


    @AfterClass
    public void teardown() {
        driver.quit();
    }
}


