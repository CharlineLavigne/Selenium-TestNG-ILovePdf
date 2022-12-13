package com.homePage;

import com.utils.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class HomePageMac extends HomePage{

    Utilities utils = new Utilities();


    //This method tests if the ILovePdf desktop app can be downloaded for mac
    public void downloadApp_shouldDownloadDesktopApp(WebDriver driver){
        driver.findElement(By.cssSelector("[title='Desktop']")).click();
        try{
            WebElement btnDownload = utils.waitForElement(driver, "//div[@class='binary'] /a");
            //driver.findElement(By.cssSelector(".binary > a")).click();
            Assert.assertTrue(driver.findElement(By.id("mac")).getText().equals("Download for MacOS"));
        }catch(AssertionError e){
            WebElement systemChoiceBtn = utils.waitForElement(driver, "//div[@class='binary__select']");
            systemChoiceBtn.click();
            driver.findElement(By.className("mac")).click();
        }
        driver.navigate().back();
    }
}
