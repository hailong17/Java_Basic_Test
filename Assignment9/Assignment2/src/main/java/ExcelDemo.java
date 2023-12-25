import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDemo {
    public static void main(String[] args) {
        Random random = new Random();
        // Step 1: Create a workbook
        Workbook workbook = new XSSFWorkbook();

        /* Step 2: Create a sheet in the workbook */
        Sheet sheet = workbook.createSheet("Sheet1");

        Row header        = sheet.createRow(0);
        Cell firstColumn  = header.createCell(0);
        firstColumn.setCellValue("Students");

        for (int i = 0; i <= 6; i++) {
            Cell nextHeader = header.createCell(i+1);
            nextHeader.setCellValue("Paper " + (i+1));
        }

        Cell lastColumn = header.createCell(8);
        lastColumn.setCellValue("Total");

        for (int row = 1; row <= 7; row++) {
            Row firstrow = sheet.createRow(row);
            Cell cell    = firstrow.createCell(0);
            cell.setCellValue("Student " + row);
            for (int column = 1; column <= 7; column++) {
                Cell numOfCell = firstrow.createCell(column);
                numOfCell.setCellValue(random.nextInt(100));
            }

            Cell sum = firstrow.createCell(8);
            sum.setCellFormula("SUM(B" + (row + 1) + ":H" + (row + 1) + ")");
        }

        // Set the color for specific cells using a loop
        for (int rowIndex = 0; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
            Row row = sheet.getRow(rowIndex);

            if (rowIndex == 0) {
                for (int cellIndex = 1; cellIndex < row.getLastCellNum(); cellIndex++) {
                    Cell cell = row.getCell(cellIndex);
                    CellStyle style = workbook.createCellStyle();
                    style.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
                    style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                    cell.setCellStyle(style);
                }
            } if (rowIndex == 1 || rowIndex == 2 || rowIndex == 3 || rowIndex == 4 || rowIndex == 5 || rowIndex == 6 || rowIndex == 7) {
                Cell cell = row.getCell(0);
                CellStyle style = workbook.createCellStyle();
                style.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
                style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                cell.setCellStyle(style);
            }
            if (rowIndex == 1 || rowIndex == 2 || rowIndex == 3 || rowIndex == 4 || rowIndex == 5 || rowIndex == 6 || rowIndex == 7) {
                Cell orangeCell = row.getCell(8);

                CellStyle style1 = workbook.createCellStyle();
                style1.setFillForegroundColor(IndexedColors.ORANGE.getIndex());
                style1.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                orangeCell.setCellStyle(style1);
            }
        }

        // Write the workbook to a file
        try (FileOutputStream fileOut = new FileOutputStream("output.xlsx")) {
            workbook.write(fileOut);
            System.out.println("Excel file created successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}