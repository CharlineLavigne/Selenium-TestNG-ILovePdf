package com.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class Base {


    public WebDriver initializeBrowser(String browser) throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();

        switch(browser) {
            case "chrome":
                dc.setBrowserName(browser);
                break;
            case "firefox":
                dc.setBrowserName(browser);
                break;
            case "safari":
                dc.setBrowserName(browser);
                break;
        }
        return new RemoteWebDriver(new URL("http://localhost:4444"), dc);
    }
}
