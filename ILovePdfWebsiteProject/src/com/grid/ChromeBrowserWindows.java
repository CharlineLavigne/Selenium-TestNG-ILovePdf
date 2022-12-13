package com.grid;

import com.excelToPdfPage.ExcelToPdf;
import com.excelToPdfPage.ExcelToPdfWindows;
import com.utils.Base;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class ChromeBrowserWindows extends Base {

    public WebDriver driver;
    ExcelToPdf excelToPdfPageWindows = new ExcelToPdfWindows();

    @BeforeClass
    public void setup() throws MalformedURLException {
        driver = initializeBrowser("chrome");
        driver.get("https://www.ilovepdf.com/");
        driver.manage().window().maximize();
    }


    @Test
    public void closeToastMessage(){
        excelToPdfPageWindows.closeToastMessage_shouldCloseLanguageToastMessage(driver);
    }


    @Test
    public void accessExcelToPdf(){
        excelToPdfPageWindows.accessExcelToPdf_shouldAccessExcelToPdfPageFromHome(driver);
    }


    @AfterClass
    public void teardown() {
        driver.quit();
    }
}
