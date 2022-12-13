package com.excelToPdfPage;

import com.utils.Utilities;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class ExcelToPdfMac extends ExcelToPdf{

    Utilities utils = new Utilities();


    //This method tests if an excel file can be uploaded using Applescript
    public void uploadExcel_shouldUploadExcelFile(WebDriver driver, String scriptPath) throws IOException {
        utils.waitForElement(driver, "//a[@id='pickfiles']").click();
        Runtime.getRuntime().exec("osascript " + scriptPath);
        driver.navigate().back();
    }

}
