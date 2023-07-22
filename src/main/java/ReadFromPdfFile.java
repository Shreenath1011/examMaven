import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;

public class ReadFromPdfFile {

    public static void main(String[] args) {
        try{
            File file = new File("C:\\Users\\User\\IntelliJWorkspace\\examMaven\\src\\main\\resources\\test.pdf");
            PDDocument document = PDDocument.load(file);
            PDFTextStripper pdfTextStripper = new PDFTextStripper();
            String s = pdfTextStripper.getText(document);
            System.out.println(s);
            document.close();


        }catch( Exception e){
            System.err.println("Error::" + e.getMessage());
        }
    }
}
