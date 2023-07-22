import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;

public class WriteToPdfFile {
    public static void main(String[] args) {

        try{
            File file = new File("C:\\Users\\User\\IntelliJWorkspace\\examMaven\\src\\main\\resources\\test.pdf");
            PDDocument document = new PDDocument();
            PDPage page = new PDPage();
            document.addPage(page);
            PDPageContentStream pdPageContentStream = new PDPageContentStream(document ,page, PDPageContentStream.AppendMode.APPEND, true, true );
            pdPageContentStream.beginText();
            pdPageContentStream.setFont(PDType1Font.TIMES_ROMAN, 12);
            pdPageContentStream.newLineAtOffset(60,60);
            pdPageContentStream.setLeading(14.5f);


            String[] strText = new String[6];
            strText[0] = "First PDF Page generation and write to test.pdf file...";
            strText[1] = "First PDF Page generation and write..";
            strText[2] = "First PDF Page generation and write 2..";
            strText[3] = "First PDF Page generation and write 3..";
            strText[4] = "First PDF Page generation and write 4..";
            strText[5] = "First PDF Page generation and write 5..";

            for (int i = 0; i < strText.length; i++) {
                pdPageContentStream.showText(strText[i]);
                pdPageContentStream.newLine();
            }
            pdPageContentStream.endText();
            pdPageContentStream.close();
            document.save(file);




        }catch( Exception e){
            System.err.println("Error::" + e.getMessage());
            e.getStackTrace();
        }
    }
}
