package com.pom;

import com.utils.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ExcelToPdfPO {

    WebDriver driver;
    Utilities utils;
    By excelToPdfLinkWait = By.xpath("//a[@title='Excel to PDF']");
    By excelHeaderTitleWait = By.xpath("//h1[@class='tool__header__title']");
    By excelUploadBtnWait = By.xpath("//a[@id='pickfiles']");


    public ExcelToPdfPO(WebDriver driver){
        this.driver = driver;
        utils = new Utilities(driver);
    }


    public void clickExcelToPdfLink(){
        utils.waitForElement(driver.findElement(excelToPdfLinkWait)).click();
    }


    public String getTextOfHeaderTitle(){
        return utils.waitForElement(driver.findElement(excelHeaderTitleWait)).getText();
    }


    public void clickExcelUploadBtn(){
        utils.waitForElement(driver.findElement(excelUploadBtnWait)).click();
    }

}
