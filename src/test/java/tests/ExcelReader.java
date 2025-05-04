package tests;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelReader {

    public static FileInputStream fil;
    public static FileInputStream getFileInputStream(){

       String path= System.getProperty("user.dir")+"/src/test/java/tests/Datadriven.xlsx";
       File file = new File(path);
        try {
            fil= new FileInputStream(file);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return fil;
     }




     public static Object [][] getData() throws IOException {
        fil=getFileInputStream();
         XSSFWorkbook workbook = new XSSFWorkbook(fil);
         XSSFSheet sheet = workbook.getSheetAt(0);
         XSSFRow row = sheet.getRow(0);
         int rowNum = sheet.getLastRowNum()+1;
         int colNum = 2;
         String [][] data = new String[rowNum][colNum];
         for(int i=0; i<rowNum; i++){
             for(int j=0; j<colNum; j++){
                 data[i][j] = row.getCell(j).toString();
             }
         }
         workbook.close();

        return data;

     }
}