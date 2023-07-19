import org.apache.poi.ss.formula.functions.Column;
import org.apache.poi.ss.formula.functions.Rows;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

public class ReadExcelFile {
    public static void main(String[] args) {
        try{
            File file = new File("C:\\Users\\User\\IntelliJWorkspace\\examMaven\\src\\main\\resources\\test.xlsx");
            FileInputStream fileInputStream = new FileInputStream(file);

            //create workbook instance and capture the data from Excel file
            XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
            int num = workbook.getNumberOfSheets();
            System.out.println(num);
            XSSFSheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();
            while (rowIterator.hasNext()){
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext()){
                    Cell cell = cellIterator.next();
                    switch (cell.getCellType()){
                        case STRING : System.out.print(cell.getStringCellValue()+"\t");
                            break;
                        case NUMERIC: System.out.print("\t"+cell.getNumericCellValue()+"\t\t");
                            break;
                        case BOOLEAN: System.out.print(cell.getBooleanCellValue()+"\t");
                            break;
                    }
                }
                System.out.println();
            }
        }catch (Exception e){
            System.err.println(" Error is: "+e.getMessage());

        }
    }
}
