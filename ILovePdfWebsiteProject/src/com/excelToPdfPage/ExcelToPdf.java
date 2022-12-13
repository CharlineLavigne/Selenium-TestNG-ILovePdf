package com.excelToPdfPage;

import com.utils.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;


public abstract class ExcelToPdf {

    SoftAssert softAssert = new SoftAssert();
    Utilities utils = new Utilities();


    //This method tests if user can go to ExcelToPdf page from home page
    public void accessExcelToPdf_shouldAccessExcelToPdfPageFromHome(WebDriver driver){
        driver.findElement(By.cssSelector("[title='Excel to PDF']")).click();
        WebElement excelHeaderTitle = driver.findElement(By.className("tool__header__title"));
        Assert.assertTrue(excelHeaderTitle.getText().equals("Convert EXCEL to PDF"));
    }


    //This method tests if user can close the switch language toast message when displayed
    public void closeToastMessage_shouldCloseLanguageToastMessage(WebDriver driver){
        //WebElement toastMessageCloseBtn = driver.findElement(By.className("toast-close-button"));

        WebElement toastMessageCloseBtn = utils.waitForElement(driver, "//button[@class='toast-close-button']");
        toastMessageCloseBtn.click();
        softAssert.assertTrue(toastMessageCloseBtn.getText().equals("×"));
        softAssert.assertAll();
    }


    //This method tests if data excel sheet contains correct values at the expected position
    public void checkDataTest_shouldVerifyExcelData(String excelPath, String dataTest1, String dataTest2, String dataTest3) throws FileNotFoundException {
        Object[][] excelListObject = utils.readExcelData(excelPath);
        String[][] excelListStringObject = Arrays.stream(excelListObject).toArray(String[][]::new);
        String[] excelListArray = new String[excelListObject.length];

        for(int i = 0; i<excelListStringObject.length; i++){
            excelListArray[i] = Arrays.toString(excelListStringObject[i]).replace(".0,", "");
        }

        Assert.assertTrue(excelListArray[0].contains("Apple"));
        Assert.assertTrue(excelListArray[1].contains("2"));
        Assert.assertFalse(excelListArray[5].contains("Ananas"));
    }


    public abstract void uploadExcel_shouldUploadExcelFile(WebDriver driver, String excelPath) throws IOException;


    public abstract void downloadApp_shouldDownloadDesktopApp(WebDriver driver);



}
