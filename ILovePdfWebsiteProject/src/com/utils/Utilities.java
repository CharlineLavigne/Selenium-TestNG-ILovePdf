package com.utils;

import org.apache.poi.ss.usermodel.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.time.Duration;

public class Utilities {

    WebDriver driver;


    public Utilities(WebDriver driver){
        this.driver = driver;
    }


    public WebElement waitForElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }


    public void selectElement(WebElement element, String selectedText){
        Select elementSelected = new Select(waitForElement(element));
        elementSelected.selectByVisibleText(selectedText);
    }


    public Object[][] readExcelData(String dataFile) {
        String data[][] = null;

        try {
            File file = new File(dataFile);
            InputStream fileReader = new FileInputStream(file);
            Workbook workbook = WorkbookFactory.create(fileReader);
            Sheet sheet = workbook.getSheet("List");
            Row row;
            Cell cell;

            int rowCount = sheet.getLastRowNum();
            data = new String[rowCount+1][2];

            for(int i=0; i<= rowCount; i++) {
                row = sheet.getRow(i);
                int cellCount = row.getLastCellNum();

                for(int j=0; j<cellCount; j++) {
                    cell = row.getCell(j);

                    if(cell.getCellType().toString().equals("NUMERIC")) {
                        double doubleVal = cell.getNumericCellValue();
                        data[i][j] = String.valueOf(doubleVal);
                        System.out.print("Cell value is: " + cell.getNumericCellValue() + " ");
                    }
                    else {
                        data[i][j] = cell.getStringCellValue();
                        System.out.println("Cell value is: " + cell.getStringCellValue());
                    }
                }
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return data;
    }
}
