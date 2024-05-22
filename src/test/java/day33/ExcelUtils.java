package day33;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	public static FileInputStream inputFile;
	public static FileOutputStream outputFile;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static CellStyle style;   
	
	public static int getLastRowIndex(String filePath,String sheetName) throws IOException 
	{
		inputFile=new FileInputStream(filePath);
		workbook=new XSSFWorkbook(inputFile);
		sheet=workbook.getSheet(sheetName);
		int lastRowNum=sheet.getLastRowNum();
		workbook.close();
		inputFile.close();
		return lastRowNum;		
	}
	

	public static int getLastColumnIndex(String filePath,String sheetName,int rowIndex) throws IOException
	{
		inputFile=new FileInputStream(filePath);
		workbook=new XSSFWorkbook(inputFile);
		sheet=workbook.getSheet(sheetName);
		row=sheet.getRow(rowIndex);
		int cellcount=row.getLastCellNum();
		workbook.close();
		inputFile.close();
		return cellcount;
	}
	
	
	public static String getCellData(String filePath,String sheetName,int rowIndex,int columnIndex) throws IOException
	{
		inputFile=new FileInputStream(filePath);
		workbook=new XSSFWorkbook(inputFile);
		sheet=workbook.getSheet(sheetName);
		row=sheet.getRow(rowIndex);
		cell=row.getCell(columnIndex);
	
		String data;
		try 
		{
			//data=cell.toString();
			
			DataFormatter formatter = new DataFormatter();
            data = formatter.formatCellValue(cell);
            return data;
		}
		catch (Exception e) 
		{
			data="";
		}
		
		workbook.close();
		inputFile.close();
		return data;
	}
	
	

	public static void setCellData(String filePath,String sheetName,int rowIndex,int columnIndex,String data) throws IOException
	{
		inputFile=new FileInputStream(filePath);
		workbook=new XSSFWorkbook(inputFile);
		sheet=workbook.getSheet(sheetName);
		row=sheet.getRow(rowIndex);
		cell=row.createCell(columnIndex);
		cell.setCellValue(data);
		outputFile=new FileOutputStream(filePath);
		workbook.write(outputFile);		
		workbook.close();
		inputFile.close();
		outputFile.close();
				
	}
	
	public static void fillGreenColor(String filePath,String sheetName,int rowIndex,int columnIndex) throws IOException
	{
		inputFile=new FileInputStream(filePath);
		workbook=new XSSFWorkbook(inputFile);
		sheet=workbook.getSheet(sheetName);
		row=sheet.getRow(rowIndex);
		cell=row.getCell(columnIndex);
		
		style=workbook.createCellStyle();
		
		style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND); 
				
		cell.setCellStyle(style);
		outputFile=new FileOutputStream(filePath);
		workbook.write(outputFile);
		workbook.close();
		inputFile.close();
		outputFile.close();
	}
	
	
	public static void fillRedColor(String filePath,String sheetName,int rowIndex,int columnIndex) throws IOException
	{
		inputFile=new FileInputStream(filePath);
		workbook=new XSSFWorkbook(inputFile);
		sheet=workbook.getSheet(sheetName);
		row=sheet.getRow(rowIndex);
		cell=row.getCell(columnIndex);
		
		style=workbook.createCellStyle();
		
		style.setFillForegroundColor(IndexedColors.RED.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);  
		
		cell.setCellStyle(style);		
		outputFile=new FileOutputStream(filePath);
		workbook.write(outputFile);
		workbook.close();
		inputFile.close();
		outputFile.close();
	}
	
}
