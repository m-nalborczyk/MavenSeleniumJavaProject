package day32;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

//FLOW:
//File >>> Workbook >>> Sheets >>> Rows >>> Cells
public class ReadingExcelDataDemo {

    public static void main(String[] args) throws IOException {

        FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\testdata\\testdata.xlsx");

        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheet("Sheet1"); //getSheetAt(0);
        int numberOfRows = sheet.getLastRowNum()+1; //starts at index 0
        int numberOfColumns = sheet.getRow(0).getLastCellNum(); //starts at index 1

        for (int row=0; row<numberOfRows; row++){
            XSSFRow currentRow = sheet.getRow(row);
            for (int cell=0; cell<numberOfColumns; cell++){
                String value = currentRow.getCell(cell).toString();
                System.out.print(value + "\t");
            }
            System.out.println();
        }

        workbook.close();
        file.close();

    }

}
