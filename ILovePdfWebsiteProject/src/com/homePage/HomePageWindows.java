package com.homePage;

import com.utils.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class HomePageWindows extends HomePage{

    Utilities utils = new Utilities();


    //This method tests if the ILovePdf desktop app can be downloaded for windows(64)
    public void downloadApp_shouldDownloadDesktopApp(WebDriver driver){
        driver.findElement(By.cssSelector("[title='Desktop']")).click();
        try{
            driver.findElement(By.cssSelector(".binary > a")).click();
            Assert.assertTrue(driver.findElement(By.id("win64")).getText().equals("Download for Windows"));
        }catch(AssertionError e){
            WebElement systemChoiceBtn = utils.waitForElement(driver, "//div[@class='binary__select']");
            systemChoiceBtn.click();
            driver.findElement(By.className("win64")).click();
        }
        driver.navigate().back();
    }
}
