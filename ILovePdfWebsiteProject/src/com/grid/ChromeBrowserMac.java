package com.grid;

import com.excelToPdfPage.ExcelToPdf;
import com.excelToPdfPage.ExcelToPdfMac;
import com.utils.Base;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;

public class ChromeBrowserMac extends Base {

    public WebDriver driver;
    ExcelToPdf excelToPdfPageMac = new ExcelToPdfMac();


    @BeforeClass
    public void setup() throws MalformedURLException {
        driver = initializeBrowser("chrome");
        driver.get("https://www.ilovepdf.com/");
        driver.manage().window().maximize();
    }


    @Test
    public void closeToastMessage(){
        excelToPdfPageMac.closeToastMessage_shouldCloseLanguageToastMessage(driver);
    }


    @Test
    public void accessExcelToPdf(){
        excelToPdfPageMac.accessExcelToPdf_shouldAccessExcelToPdfPageFromHome(driver);
    }


    @Test
    public void checkDataTest() throws FileNotFoundException {
        excelToPdfPageMac.checkDataTest_shouldVerifyExcelData("/Users/charlinelavigne/Desktop/GitProjects/ILovePdfWebSite/ILovePdfWebsiteProject/src/com/data/ShoppingListData.xlsx" ,"1.0, Apple", "2.0", "5.0");
    }


    @Test(dependsOnMethods = "accessExcelToPdf")
    public void uploadExcel() throws IOException {
        excelToPdfPageMac.uploadExcel_shouldUploadExcelFile(driver, "/Users/charlinelavigne/Desktop/GitProjects/ILovePdfWebSite/fileUploadScript.scpt");
    }


    @Test
    public void downloadDesktopApp(){
        excelToPdfPageMac.downloadApp_shouldDownloadDesktopApp(driver);
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }
}
