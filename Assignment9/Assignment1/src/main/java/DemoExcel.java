import java.io.File;
import java.io.FileOutputStream;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Hello world!
 *
 */
public class DemoExcel 
{
    public static void main(String[] args)
    {

        XSSFWorkbook workbook = new XSSFWorkbook();

        XSSFSheet sheet = workbook.createSheet("student Details");

        Map<String, Object[]> data = new TreeMap<String, Object[]>();

        data.put("1", new Object[] { "ID", "NAME", "LASTNAME" });
        data.put("2", new Object[] { 1, "Pankaj", "Kumar" });
        data.put("3", new Object[] { 2, "Prakashni", "Yadav" });
        data.put("4", new Object[] { 3, "Ayan", "Mondal" });
        data.put("5", new Object[] { 4, "Virat", "kohli" });

        Set<String> keyset = data.keySet();

        int rownum = 0;

        for (String key : keyset) {

            Row row = sheet.createRow(rownum++);

            Object[] objArr = data.get(key);

            int cellnum = 0;

            for (Object obj : objArr) {
                Cell cell = row.createCell(cellnum++);

                if (obj instanceof String)
                    cell.setCellValue((String)obj);
                else if (obj instanceof Integer)
                    cell.setCellValue((Integer)obj);
            }
        }

        try {
            String userDirectory = System.getProperty("user.dir");
            String excelFile   = userDirectory.replace("\\", "/") + "/DemoExcel.xlsx";
            FileOutputStream out = new FileOutputStream(new File(excelFile));
            workbook.write(out);
            out.close();
            System.out.println("DemoExcel.xlsx written successfully");
        }

        catch (Exception e) {
            e.printStackTrace();
        }
    }
}