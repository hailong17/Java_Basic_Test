import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

public class ExcelDemo
{
    public static void main(String[] args) {
        // Step 1: Create a workbook
        Workbook workbook = new XSSFWorkbook();

        /* Step 2: Create a sheet in the workbook */
        Sheet sheet = workbook.createSheet("Sheet1");

        // Creating an empty TreeMap of string and Object][]
        // type
        Map<String, Object[]> data = new TreeMap<String, Object[]>();

        /* Writing data to Object[] using put() method */
        data.put("1", new Object[] { "Students", "Paper1", "Paper2", "Paper3", "Paper4", "Paper5", "Paper5", "Paper7", "Total" });
        data.put("2", new Object[] { "Student 1", 1, 7, 74 , 23, 75, 55, 51});
        data.put("3", new Object[] { "Student 2", 73, 17, 5, 52, 18, 26, 26});
        data.put("4", new Object[] { "Student 3", 27, 29, 29, 35, 96, 17, 45});
        data.put("5", new Object[] { "Student 4", 4, 4, 56, 32, 12, 22, 14});

        // Iterating over data and writing it to sheet
        Set<String> keyset = data.keySet();

        int rownum = 0;

        for (String key : keyset) {

            // Creating a new row in the sheet
            Row row = sheet.createRow(rownum++);

            Object[] objArr = data.get(key);

            int cellnum = 0;

            for (Object obj : objArr) {

                // This line creates a cell in the next
                //  column of that row
                Cell cell = row.createCell(cellnum++);

                if (obj instanceof String)
                    cell.setCellValue((String)obj);

                else if (obj instanceof Integer)
                    cell.setCellValue((Integer)obj);
            }
        }

        // Step 3: Create a row in the sheet
        Row row = sheet.createRow(0);

        // // Step 4: Add cells in the sheet
        // for (int i = 0; i < 10; i++) {
        //     Cell cell = row.createCell(i);
        //     cell.setCellValue(i + 1);
        // }

        // Step 5: Create the FormulaTotal cell
        Cell formulaTotalCell = row.createCell(10);
        formulaTotalCell.setCellFormula("SUM(B2:H2)");
        formulaTotalCell.setCellFormula("SUM(B3:H3)");
        formulaTotalCell.setCellFormula("SUM(B4:H4)");
        formulaTotalCell.setCellFormula("SUM(B5:H5)");

        // // Step 6: Apply cell formatting to highlight all cells
        // CellStyle highlightStyle = workbook.createCellStyle();
        // highlightStyle.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
        // highlightStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        // for (int i = 0; i <= 10; i++) {
        //     Cell cell = row.getCell(i);
        //     cell.setCellStyle(highlightStyle);
        // }

        // Write the workbook to a file
        try (FileOutputStream fileOut = new FileOutputStream("output.xlsx")) {
            workbook.write(fileOut);
            System.out.println("Excel file created successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}