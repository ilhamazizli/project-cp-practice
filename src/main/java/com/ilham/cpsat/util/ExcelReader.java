package com.ilham.cpsat.util;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

public class ExcelReader {
    static Workbook workbook;
    static Sheet sheet;

    public static Object[][] getTestData(String path, String sheetName) {
        FileInputStream file = null;
        try {
            file = new FileInputStream(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            workbook = WorkbookFactory.create(file);
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        sheet = workbook.getSheet(sheetName);
        Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

        for (int i = 0; i < sheet.getLastRowNum(); i++) {
            for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
                data[i][k] = sheet.getRow(i + 1).getCell(k);
                //System.out.println(data[i][k]);
            }
        }
        return data;

    }


    public static void writeData(String excelPath, String sheetName, int rowNum, int colNum, String data) {
        try {

            File file = new File(excelPath);
            FileInputStream fis = new FileInputStream(file);
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFSheet sheet = wb.getSheet(sheetName);
            XSSFRow xssfRow;
            try {
                xssfRow = sheet.getRow(rowNum);
                if (xssfRow == null) {
                    xssfRow = sheet.createRow(rowNum);
                }
            } catch (NullPointerException np) {
                xssfRow = sheet.createRow(rowNum);
            }

            XSSFCell cell;
            try {
                cell = xssfRow.getCell(colNum);
                if (cell == null) {
                    cell = xssfRow.createCell(colNum);
                }

            } catch (NullPointerException ex) {
                cell = xssfRow.createCell(colNum);

            }
            assert cell != null;
            cell.setCellValue(data);
            FileOutputStream fio = new FileOutputStream(file);
            wb.write(fio);
            wb.close();


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
