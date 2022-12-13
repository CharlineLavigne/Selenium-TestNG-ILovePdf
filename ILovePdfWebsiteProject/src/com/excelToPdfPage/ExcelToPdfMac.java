package com.excelToPdfPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class ExcelToPdfMac extends ExcelToPdf{


    public void uploadExcel_shouldUploadExcelFile(WebDriver driver, String scriptPath) throws IOException {
        driver.findElement(By.id("pickfiles")).click();
        Runtime.getRuntime().exec("osascript " + scriptPath);
        driver.navigate().back();
    }


    public void downloadApp_shouldDownloadDesktopApp(WebDriver driver){
        driver.findElement(By.cssSelector("[title='Desktop']")).click();
        try{
            driver.findElement(By.cssSelector(".binary > a")).click();
            Assert.assertTrue(driver.findElement(By.id("mac")).getText().equals("Download for MacOS"));
        }catch(Exception e){
            Assert.fail(e.getMessage(), e);
            driver.findElement(By.className(".binary__select")).click();
            driver.findElement(By.className("mac")).click();
        }
    }
}
