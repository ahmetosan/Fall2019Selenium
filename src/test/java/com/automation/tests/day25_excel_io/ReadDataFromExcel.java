package com.automation.tests.day25_excel_io;

import org.apache.poi.hssf.model.WorkbookRecordList;
import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class ReadDataFromExcel {

    @Test
    public void readExcelFileTest() throws IOException {
    File file = new File("VytrackTestUsers.xlsx");

        Workbook workbook = WorkbookFactory.create(file);
        Sheet workSheet = workbook.getSheet("QA1-short");
        Row firstRow = workSheet.getRow(0);
        Cell firstCell = firstRow.getCell(0);

        String value = firstCell.getStringCellValue();
        String secondCellValue = firstRow.getCell(1).getStringCellValue();

        System.out.println(value);
        System.out.println(secondCellValue);

        int lastCell = firstRow.getLastCellNum();

        for (int i = 0; i <lastCell ; i++) {
            System.out.print(firstRow.getCell(i)+"|");
        }

        int numberOfRows = workSheet.getLastRowNum();
        int numberOfRows2 = workSheet.getPhysicalNumberOfRows();

        System.out.println("\nlast index number of the row = " + numberOfRows);
        System.out.println("\nnumberOfRows2 = " + numberOfRows2);

        System.out.println(" =================================================================== ");


        for (int row = 0; row < workSheet.getPhysicalNumberOfRows()  ; row++) {
            for (int cell = 0; cell<workSheet.getRow(row).getLastCellNum(); cell++){
                String cellValue =  workSheet.getRow(row).getCell(cell).getStringCellValue();
                System.out.print("cellValue = " + cellValue+"|");
            }
            System.out.println();
        }




    }
}
