package com.excelToPdfPage;

import com.pom.ExcelToPdfPO;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class ExcelToPdfMac extends ExcelToPdf{

    ExcelToPdfPO excelToPdfPO;


    public ExcelToPdfMac(WebDriver driver) {
        super(driver);
        excelToPdfPO = new ExcelToPdfPO(driver);
    }


    //This method tests if an excel file can be uploaded using Applescript
    public void uploadExcel_shouldUploadExcelFile(String scriptPath) throws IOException {
        excelToPdfPO.clickExcelUploadBtn();
        Runtime.getRuntime().exec("osascript " + scriptPath);
        driver.navigate().back();
    }

}
