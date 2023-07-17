import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ReadTextFile {

        public static void main(String[] args) throws IOException {
                FileInputStream fileInputStream = null;
                FileOutputStream fileOutputStream = null;

                try {
                        fileInputStream = new FileInputStream("src/main/resources/Sample.txt");
                        int c;
                        String inputData = "";
                        while ((c = fileInputStream.read()) != -1) {
                                inputData = inputData + (char) c;
                        }
                        // displaying data read from input file ( sample.txt)
                        System.out.println("Displaying data in console :");
                        System.out.println(inputData);
                        System.out.println();
                        inputData = inputData+ "\nThe total amount would be $110.";
                        // creating new output file SampleOutput.txt to display added text
                        fileOutputStream = new FileOutputStream("src/main/resources/Sample.txt");
                        fileOutputStream.write(inputData.getBytes());

                } catch (Exception e) {
                        System.out.println(e.getMessage());
                } finally {
                        if (fileInputStream != null) {
                                fileInputStream.close();
                        }
                        if (fileOutputStream != null) {
                                fileOutputStream.close();
                        }
                }
        }
}