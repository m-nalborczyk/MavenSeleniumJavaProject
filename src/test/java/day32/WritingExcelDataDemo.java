package day32;


import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

//FLOW:
//File >>> Workbook >>> Sheets >>> Rows >>> Cells
public class WritingExcelDataDemo {

    public static void main(String[] args) throws IOException {

        FileOutputStream file = new FileOutputStream(System.getProperty("user.dir")+"\\testdata\\myfile.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet();

        //creating rows, cells and update data WITHOUT using loop
/*        XSSFRow row1 = sheet.createRow(0);
        row1.createCell(0).setCellValue("Type");
        row1.createCell(1).setCellValue("Brand");
        row1.createCell(2).setCellValue("Model");

        XSSFRow row2 = sheet.createRow(1);
        row2.createCell(0).setCellValue("Car");
        row2.createCell(1).setCellValue("Volvo");
        row2.createCell(2).setCellValue("XC60");

        XSSFRow row3 = sheet.createRow(2);
        row3.createCell(0).setCellValue("Motorcycle");
        row3.createCell(1).setCellValue("Ducati");
        row3.createCell(2).setCellValue("Monster");*/

        //creating rows, cells and update data WITH using loop
        for (int row=0; row < 50; row++){
            XSSFRow currentRow = sheet.createRow(row);
            for (int col=0; col<5; col++){
                currentRow.createCell(col).setCellValue("RowIndex#"+row+"_ColumnIndex#"+col+"_CellValue");
            }
        }

        workbook.write(file);
        workbook.close();
        file.close();
        System.out.println("File written.");




    }

}
