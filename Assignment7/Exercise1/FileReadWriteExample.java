package Exercise1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileReadWriteExample {
    public static void main(String[] args) {
		String userDirectory = System.getProperty("user.dir");
		String inputFile     = userDirectory.replace("\\", "/") + "/Exercise1/input.txt";
		String outputFile    = userDirectory.replace("\\", "/") + "/Exercise1/output.txt";

        try {
            /* Read the file */
            FileInputStream fileInputStream = new FileInputStream(inputFile);
            byte[] data                     = new byte[fileInputStream.available()];
            fileInputStream.read(data);
            fileInputStream.close();

            /* Write to the file */
            FileOutputStream fileOutputStream = new FileOutputStream(outputFile);
            fileOutputStream.write(data);
            fileOutputStream.close();

            System.out.println("File read and write operations completed successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}