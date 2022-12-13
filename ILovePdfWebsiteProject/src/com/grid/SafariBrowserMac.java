package com.grid;

import com.utils.Base;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;

public class SafariBrowserMac extends Base {

    WebDriver driver;

    @BeforeClass
    public void setup() throws MalformedURLException {
        driver = initializeBrowser("firefox");
        driver.get("https://www.ebay.ca");
    }


    @AfterClass
    public void teardown() {
        driver.quit();
    }
}
