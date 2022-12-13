package com.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class Base {

    //Parametize the browser String ?
    public WebDriver initializeBrowser(String browser) throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();

        switch(browser) {
            case "chrome":
                dc.setBrowserName(browser);
                break;
        }
        return new RemoteWebDriver(new URL("http://localhost:4444"), dc);
    }
}
