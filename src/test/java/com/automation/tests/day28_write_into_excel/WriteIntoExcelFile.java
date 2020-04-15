package com.automation.tests.day28_write_into_excel;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteIntoExcelFile {

@Test
    public void writeIntoFileTest() throws IOException {
    FileInputStream inputStream = new FileInputStream("VytrackTestUsers.xlsx");
    Workbook workbook = WorkbookFactory.create(inputStream);
    Sheet sheet = workbook.getSheet("QA3-short");
    Row row = sheet.getRow(1);
    Cell cell =row.getCell(row.getLastCellNum()-1);
    System.out.println(cell.getStringCellValue());
    System.out.println(cell.getColumnIndex());
    cell.setCellValue("PASSED");


    Row firstRow =  sheet.getRow(0);
    Cell newCell =  firstRow.createCell(row.getLastCellNum());
    newCell.setCellValue("Date of execution");


    FileOutputStream outputStream = new FileOutputStream("VytrackTestUsers.xlsx");
    workbook.write(outputStream);
    workbook.close();
}

}
