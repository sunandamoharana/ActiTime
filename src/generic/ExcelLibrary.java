package generic;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelLibrary implements AutoConstant
{
 public static String getStringTypeCellData(String sheet,int row,int cell) throws IOException
 {
	 FileInputStream fis=new FileInputStream(excel_path);
	 Workbook wb=new XSSFWorkbook(fis);
	 String cellValue=wb.getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
	 
	return cellValue;
	 
 }
 public static Double getNumericTypeCellData(String sheet,int row,int cell) throws IOException
 {
	 FileInputStream fis=new FileInputStream(excel_path);
	 Workbook wb=new XSSFWorkbook(fis);
	 Double cellValue=wb.getSheet(sheet).getRow(row).getCell(cell).getNumericCellValue();
	 
	return cellValue;
	 
 }
 public static boolean getBooleanTypeCellData(String sheet,int row,int cell) throws IOException
 {
	 FileInputStream fis=new FileInputStream(excel_path);
	 Workbook wb=new XSSFWorkbook(fis);
	 boolean cellValue=wb.getSheet(sheet).getRow(row).getCell(cell).getBooleanCellValue();
	 
	return cellValue;
	 
 }
 public static Date getDateTypeCellData(String sheet,int row,int cell) throws IOException
 {
	 FileInputStream fis=new FileInputStream(excel_path);
	 Workbook wb=new XSSFWorkbook(fis);
	 Date cellValue=wb.getSheet(sheet).getRow(row).getCell(cell).getDateCellValue();
	 
	return cellValue;
	 
 }
 public static CellAddress getCellAddress(String sheet,int row,int cell) throws IOException
 {
	 FileInputStream fis=new FileInputStream(excel_path);
	 Workbook wb=new XSSFWorkbook(fis);
	 CellAddress cellValue=wb.getSheet(sheet).getRow(row).getCell(cell).getAddress();
	 
	return cellValue;
	 
 }
 public static int rowCount(String sheet) throws IOException
 {
	 FileInputStream fis=new FileInputStream(excel_path);
	 Workbook wb=new XSSFWorkbook(fis);
	 Sheet sheet1=wb.getSheet(sheet);
	 int rowNum=sheet1.getLastRowNum();	 
	return rowNum;
 }
 public static int cellCount(String sheet) throws IOException
 {
	 FileInputStream fis=new FileInputStream(excel_path);
	 Workbook wb=new XSSFWorkbook(fis);
	 Sheet sheet1=wb.getSheet(sheet);
	 int rowNum=sheet1.getLastRowNum();	
	 int cellCount=0;
	 for(int i=0;i<=rowNum;i++)
	 {
		 cellCount=sheet1.getRow(i).getLastCellNum();
	 }
	return cellCount;
 }
 
 
 
 
 
 
 
 
 
}
