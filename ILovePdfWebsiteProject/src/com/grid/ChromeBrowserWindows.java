package com.grid;

import com.excelToPdfPage.ExcelToPdf;
import com.excelToPdfPage.ExcelToPdfWindows;
import com.homePage.HomePage;
import com.homePage.HomePageWindows;
import com.utils.Base;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;

public class ChromeBrowserWindows extends Base {

    public WebDriver driver;
    ExcelToPdf excelToPdfPageWindows = new ExcelToPdfWindows();
    HomePage homePageWindows = new HomePageWindows();


    @BeforeClass
    public void setup() throws MalformedURLException {
        driver = initializeBrowser("chrome");
        driver.get("https://www.ilovepdf.com/");
        driver.manage().window().maximize();
    }


    @Test(priority = 1, groups = {"homePage"})
    public void closeToastMessage(){
        homePageWindows.closeToastMessage_shouldCloseLanguageToastMessage(driver);
    }


    @Test(priority = 2, groups = {"homePage"})
    public void downloadDesktopApp(){
        homePageWindows.downloadApp_shouldDownloadDesktopApp(driver);
    }


    @Test(priority = 3, groups = {"homePage"})
    public void accessExcelToPdf(){
        excelToPdfPageWindows.accessExcelToPdf_shouldAccessExcelToPdfPageFromHome(driver);
    }


    @Test(priority = 4, groups = {"excelToPdf"}, dependsOnMethods = "accessExcelToPdf")
    public void checkDataTest() throws FileNotFoundException {
        excelToPdfPageWindows.checkDataTest_shouldVerifyExcelData("/Users/charlinelavigne/Desktop/GitProjects/ILovePdfWebSite/ILovePdfWebsiteProject/src/com/data/ShoppingListData.xlsx" ,"Apple", "2", "Ananas", 0, 1, 5);
    }


    @Test(priority = 5, groups = {"excelToPdf"}, dependsOnMethods = "accessExcelToPdf")
    public void uploadExcel() throws IOException {

    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }
}
