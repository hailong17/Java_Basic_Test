import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDemo {
    public static void main(String[] args) {
        // Step 1: Create a workbook
        Workbook workbook = new XSSFWorkbook();

        /* Step 2: Create a sheet in the workbook */
        Sheet sheet = workbook.createSheet("Sheet1");

        // Creating an empty TreeMap of string and Object[] type
        Map<String, Object[]> data = new TreeMap<String, Object[]>();

        /* Writing data to Object[] using put() method */
        data.put("1", new Object[] {"Students", "Paper1", "Paper2", "Paper3", "Paper4", "Paper5", "Paper6", "Paper7", "Total"});
        data.put("2", new Object[] {"Student 1", 1, 7, 74, 23, 75, 55, 51, 286});
        data.put("3", new Object[] {"Student 2", 73, 17, 5, 52, 18, 26, 26, 217});
        data.put("4", new Object[] {"Student 3", 27, 29, 29, 35, 96, 17, 45, 278});
        data.put("5", new Object[] {"Student 4", 4, 4, 56, 32, 12, 22, 14, 144});

        // Iterating over data and writing it to sheet
        Set<String> keyset = data.keySet();
        int rownum = 0;

        for (String key : keyset) {
            // Creating a new row in the sheet
            Row row = sheet.createRow(rownum++);
            Object[] objArr = data.get(key);
            int cellnum = 0;

            for (Object obj : objArr) {
                // This line creates a cell in the next column of that row
                Cell cell = row.createCell(cellnum++);

                if (obj instanceof String) {
                    cell.setCellValue((String) obj);
                } else if (obj instanceof Integer) {
                    cell.setCellValue((Integer) obj);
                }
            }
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
            } if (rowIndex == 1 || rowIndex == 2 || rowIndex == 3 || rowIndex == 4) {
                Cell cell = row.getCell(0);
                CellStyle style = workbook.createCellStyle();
                style.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
                style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                cell.setCellStyle(style);
            }
            if (rowIndex == 1 || rowIndex == 2 || rowIndex == 3 || rowIndex == 4) {
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