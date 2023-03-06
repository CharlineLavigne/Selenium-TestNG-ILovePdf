package com.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;


public class BaseTest {

    public static WebDriver driver;

    @Parameters({"browserName"})
    @BeforeTest
    public void setup(String browserName){
        if(browserName.equals("firefox")){
            driver = WebDriverManager.firefoxdriver().create();
        }
        else if (browserName.equals("safari")){
            driver = WebDriverManager.safaridriver().create();
        }
        else{
            driver = WebDriverManager.chromedriver().create();
        }
        driver.get("https://www.ilovepdf.com/");
        driver.manage().window().maximize();
    }

    @AfterTest
    public void teardown() {
        driver.quit();
    }
}
