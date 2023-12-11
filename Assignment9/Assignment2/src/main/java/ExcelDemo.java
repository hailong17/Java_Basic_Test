import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
/**
 * Hello world!
 *
 */
public class ExcelDemo 
{
    public static void main(String[] args) {
        // Step 1: Create a workbook
        Workbook workbook = new XSSFWorkbook();

        // Step 2: Create a sheet in the workbook
        Sheet sheet = workbook.createSheet("Sheet1");

        // Creating an empty TreeMap of string and Object][]
        // type
        Map<String, Object[]> data
            = new TreeMap<String, Object[]>();

        // Writing data to Object[]
        // using put() method
        data.put("1",
                 new Object[] { "ID", "NAME", "LASTNAME" });
        data.put("2",
                 new Object[] { 1, "Pankaj", "Kumar" });
        data.put("3",
                 new Object[] { 2, "Prakashni", "Yadav" });
        data.put("4", new Object[] { 3, "Ayan", "Mondal" });
        data.put("5", new Object[] { 4, "Virat", "kohli" });
        
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

        // Step 4: Add cells in the sheet
        for (int i = 0; i < 10; i++) {
            Cell cell = row.createCell(i);
            cell.setCellValue(i + 1);
        }

        // Step 5: Create the FormulaTotal cell
        Cell formulaTotalCell = row.createCell(10);
        formulaTotalCell.setCellFormula("SUM(B1:H1)");

        // Step 6: Apply cell formatting to highlight all cells
        CellStyle highlightStyle = workbook.createCellStyle();
        highlightStyle.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
        highlightStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        for (int i = 0; i <= 10; i++) {
            Cell cell = row.getCell(i);
            cell.setCellStyle(highlightStyle);
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