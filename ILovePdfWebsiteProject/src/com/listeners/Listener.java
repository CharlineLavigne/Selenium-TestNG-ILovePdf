package com.listeners;

import com.tests.BaseTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class Listener extends BaseTest implements ITestListener, ISuiteListener {

    public void onStart(ISuite suite) {
        System.out.println("Starting the execution of suite: " + suite.getName());
    }


    public void onFinish(ISuite suite) {
        System.out.println("Finishing the execution of suite: " + suite.getName());
    }


    public void onTestFailure(ITestResult result) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);

        try {
            String screenshotPath = System.getProperty("user.dir") + File.separator + "screenshots" + File.separator + result.getName() + ".png";
            FileUtils.copyFile(source, new File(screenshotPath));
            System.out.println("screenshot taken");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
