package com.excelToPdfPage;

import com.utils.Utilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;


public abstract class ExcelToPdf {

    Utilities utils = new Utilities();


    //This method tests if user can go to ExcelToPdf page from home page
    public void accessExcelToPdf_shouldAccessExcelToPdfPageFromHome(WebDriver driver){
        utils.waitForElement(driver, "//a[@title='Excel to PDF']").click();
        WebElement excelHeaderTitle = utils.waitForElement(driver, "//h1[@class='tool__header__title']");
        Assert.assertTrue(excelHeaderTitle.getText().equals("Convert EXCEL to PDF"));
    }


    //This method tests if data excel sheet contains correct values at the expected position
    public void checkDataTest_shouldVerifyExcelData(String excelPath, String dataTest1, String dataTest2, String dataTest3, int pos1, int pos2, int pos3) throws FileNotFoundException {
        Object[][] excelListObject = utils.readExcelData(excelPath);
        String[][] excelListStringObject = Arrays.stream(excelListObject).toArray(String[][]::new);
        String[] excelListArray = new String[excelListObject.length];

        for(int i = 0; i<excelListStringObject.length; i++){
            excelListArray[i] = Arrays.toString(excelListStringObject[i]).replace(".0,", "");
        }

        Assert.assertTrue(excelListArray[pos1].contains(dataTest1));
        Assert.assertTrue(excelListArray[pos2].contains(dataTest2));
        Assert.assertFalse(excelListArray[pos3].contains(dataTest3));
    }


    public abstract void uploadExcel_shouldUploadExcelFile(WebDriver driver, String excelPath) throws IOException;
}
