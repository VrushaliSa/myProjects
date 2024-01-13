package ExcelReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelReader {
	static XSSFWorkbook workbook ;
	static int row_count;
	
	//READ FILE AS WORKBOOK
	public static XSSFWorkbook readFile(String filepath) throws IOException
	{
		File f= new File(filepath);
		FileInputStream fis = new FileInputStream(f);
		return workbook = new XSSFWorkbook(fis);	
		
	}
	//GET SHEET BY INDEX
	public static XSSFSheet getSheetby(int index)
	{
		XSSFSheet sheet=workbook.getSheetAt(index);
		return sheet;
	}
	//GET SHEET BY NAME
	public static XSSFSheet getSheetby(String name)
	{
		XSSFSheet sheet=workbook.getSheet(name);
		return sheet;
	}
	
	//GET ROW COUNT
	public static  int row_count(XSSFSheet sheet)
	{
		return sheet.getLastRowNum();	
	}
	
	//GET COL COUNT
	public static  int col_count(XSSFSheet sheet)
	{
		return sheet.getRow(0).getLastCellNum();	
	}
	
	//GET Specific cell DATA
	public String getSpecCellVal(XSSFSheet sheet, int rowNum, int colNum)
	{
		String data =sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
		return data;
	}
	
	public static String[]getValuesFromRow(XSSFSheet sheet, int rowNum)
	{
		int colCount  = col_count(sheet);
		//int rowCount = row_count(sheet);
		String[] data=new String[colCount]; 
		for(int i=0;i<colCount;i++)
		{
		data[i]= sheet.getRow(rowNum).getCell(i).getStringCellValue();
		}
		
		return data;
	}
	
	
	
}
