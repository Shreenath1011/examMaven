import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;

public class WriteToExcelFile {
    public static void main(String[] args) {
        try{
            File file = new File("C:\\Users\\User\\IntelliJWorkspace\\examMaven\\src\\main\\resources\\students.xlsx");
            FileInputStream fileInputStream = new FileInputStream(file);
            XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);

            int num = workbook.getNumberOfSheets();
            System.out.println(num);
            XSSFSheet sheet = workbook.getSheetAt(0);
            //display all values

            Iterator<Row> rowIterator = sheet.iterator();
            while (rowIterator.hasNext()){
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext()){
                    Cell cell = cellIterator.next();
                    switch (cell.getCellType()){
                        case STRING : System.out.print(cell.getStringCellValue()+"\t");
                            break;
                        case NUMERIC: System.out.print("\t"+cell.getNumericCellValue()+"\t");
                            break;
                        case BOOLEAN: System.out.print(cell.getBooleanCellValue()+"\t");
                            break;
                    }
                }
                System.out.println();
            }
            Student[] student = new Student[7];
            for( int i=1 ; i<= 5; i++){
                Row row = sheet.getRow(i);
                int id=0, score1=0, score2=0, score3=0;
                String name="";
                for( int j =0 ; j<row.getLastCellNum(); i++ ){
                    Cell cell = row.getCell(j);

                    switch (cell.getCellType()) {
                        case STRING:
                            name = cell.getStringCellValue();
                            break;
                        case NUMERIC:
                            if( j==0){
                                id = (int) cell.getNumericCellValue();
                            }else  if( j==2){
                                score1 = (int) cell.getNumericCellValue();
                            }else  if( j==3){
                                score2 = (int) cell.getNumericCellValue();
                            }else  if( j==4){
                                score3 = (int) cell.getNumericCellValue();
                            }
                            break;
                    }

                }

                Student tempStu = new Student(id , name , score1 , score2, score3);
                student[i] = tempStu;

            }
            // display
            for( int i=0 ; i<5; i++){
                student[i].toString();
            }

            Student student1 = new Student(1006, "Shree", 90 , 60, 70);
            Student student2 = new Student(1007, "Shreenath", 95 , 66, 78);
            student[6] = student1;
            student[7] = student2;
            for( int i=0 ; i< 2; i++){
                Row row = sheet.createRow(sheet.getLastRowNum()+1);
                for( int j=0 ; j<5 ; j++){
                    Cell cell = row.createCell(j);
                    switch (j) {
                        case 0:
                            if (i == 0) {
                                cell.setCellValue(student[6].getId());
                            } else {
                                cell.setCellValue(student[7].getId());
                            }
                            break;
                        case 1:
                            if (i == 0) {
                                cell.setCellValue(student[6].getName());
                            } else {
                                cell.setCellValue(student[7].getName());
                            }
                            break;
                        case 2:
                            if (i == 0) {
                                cell.setCellValue(student[6].getScore1());
                            } else {
                                cell.setCellValue(student[7].getScore1());
                            }
                            break;
                        case 3:
                            if (i == 0) {
                                cell.setCellValue(student[6].getScore2());
                            } else {
                                cell.setCellValue(student[7].getScore2());
                            }
                            break;
                        case 4:
                            if (i == 0) {
                                cell.setCellValue(student[6].getScore3());
                            } else {
                                cell.setCellValue(student[7].getScore3());
                            }
                            break;

                    }
                }

            }
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            workbook.write(fileOutputStream);
            fileOutputStream.close();
            display(student , sheet.getLastRowNum());

        }catch(Exception e){
            System.out.println("Error is" + e.getMessage());
        }
    }
    public static void display(Student[] s , int i){
        for( int j=0 ; j<i; j++){
            s[i].toString();
        }
    }
}
