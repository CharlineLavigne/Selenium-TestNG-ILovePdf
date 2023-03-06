package com.tests;

import com.excelToPdfPage.ExcelToPdf;
import com.excelToPdfPage.ExcelToPdfMac;
import com.excelToPdfPage.ExcelToPdfWindows;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelToPdfTest {

    ExcelToPdf excelToPdfPageMac;
    ExcelToPdf excelToPdfPAgeWindows;
    String scriptMac = System.getProperty("user.dir") + File.separator + "ILovePdfWebsiteProject" + File.separator + "fileUploadScript.scpt";

    @BeforeClass
    public void setupDriver(){
        excelToPdfPageMac = new ExcelToPdfMac(BaseTest.driver);
        excelToPdfPAgeWindows = new ExcelToPdfWindows(BaseTest.driver);
    }


    @Test(priority = 4, groups = {"excelToPdf"}, dependsOnMethods = "accessExcelToPdf")
    public void checkDataTest() throws FileNotFoundException {
        String path = System.getProperty("user.dir") + File.separator + "ILovePdfWebsiteProject" + File.separator + "src" + File.separator + "com" + File.separator + "data" + File.separator + "ShoppingListData.xlsx";
        excelToPdfPageMac.checkDataTest_shouldVerifyExcelData(path ,"Apple", "2", "Ananas", 0, 1, 5);
    }


    @Parameters({"system"})
    @Test(priority = 5, groups = {"excelToPdf"}, dependsOnMethods = "accessExcelToPdf")
    public void uploadExcel(String system) throws IOException{
        if(system.equals("windows")){
            excelToPdfPAgeWindows.uploadExcel_shouldUploadExcelFile("auto it script needs to be added");
        }
        else if(system.equals("mac")){
            excelToPdfPageMac.uploadExcel_shouldUploadExcelFile(scriptMac);
        }
    }
}
