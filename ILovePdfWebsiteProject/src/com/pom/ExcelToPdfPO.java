package com.pom;

import com.utils.Utilities;
import org.openqa.selenium.WebDriver;

public class ExcelToPdfPO {

    WebDriver driver;
    Utilities utils;
    String excelToPdfLinkWait = "//a[@title='Excel to PDF']";
    String excelHeaderTitleWait = "//h1[@class='tool__header__title']";
    String excelUploadBtnWait = "//a[@id='pickfiles']";


    public ExcelToPdfPO(WebDriver driver){
        this.driver = driver;
        utils = new Utilities(driver);
    }


    public void clickExcelToPdfLink(){
        utils.waitForElement(excelToPdfLinkWait).click();
    }


    public String getTextOfHeaderTitle(){
        return utils.waitForElement(excelHeaderTitleWait).getText();
    }


    public void clickExcelUploadBtn(){
        utils.waitForElement(excelUploadBtnWait).click();
    }

}
