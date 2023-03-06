package com.pom;

import com.utils.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePagePO {

    WebDriver driver;
    Utilities utils;
    By toastCloseBtnWait = By.xpath("//button[@class='toast-close-button']");
    By toastTitle = By.className("toast-title");
    By desktopAppIconDownload = By.cssSelector("[title='Desktop']");
    By btnDownloadDesktopAppWait = By.xpath("//div[@class='binary'] /a");
    By btnDownloadDesktopAppMac = By.id("mac");
    By btnDownloadDesktopAppWin = By.id("win64");
    By btnSelectSystemAppWait = By.xpath("//div[@class='binary__select']");
    By macDesktopAppSelect = By.className("mac");
    By winDesktopAppSelect = By.className("win64");


    public HomePagePO(WebDriver driver){
        this.driver = driver;
        utils = new Utilities(driver);
    }


    public void closeToastMessage(){
        utils.waitForElement(driver.findElement(toastCloseBtnWait));
    }


    public String getTextToastMessage(){
        return driver.findElement(toastTitle).getText();
    }


    public void clickIconDesktopDownload(){
        driver.findElement(desktopAppIconDownload).click();
    }


    public void downloadDesktopApp(){
        utils.waitForElement(driver.findElement(btnDownloadDesktopAppWait)).click();
    }


    public String getTextDownloadDesktopAppMac(){
        return driver.findElement(btnDownloadDesktopAppMac).getText();
    }


    public String getTestDownloadDesktopAppWin(){
        return driver.findElement(btnDownloadDesktopAppWin).getText();
    }


    public void selectSystemDesktopApp(){
        utils.waitForElement(driver.findElement(btnSelectSystemAppWait)).click();
    }


    public void selectDesktopAppMac(){
        driver.findElement(macDesktopAppSelect).click();
    }


    public void selectDesktopAppWin(){
        driver.findElement(winDesktopAppSelect).click();
    }
}
