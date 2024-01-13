package ExcelReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel1 {
	XSSFWorkbook workbook;
	public ReadExcel1(String filepath) throws IOException {
		
		File f= new File("E:\\softtech\\data1.xlsx");
		FileInputStream fis = new FileInputStream(f);
		workbook = new XSSFWorkbook(fis);
		// TODO Auto-generated constructor stub
	}

	public int getRowCount(int sheetindex)
	{
		XSSFSheet sheet = workbook.getSheetAt(sheetindex);
		return sheet.getLastRowNum()+1;
	}
	
	public int getColCount(int sheetindex)
	{
		XSSFSheet sheet = workbook.getSheetAt(sheetindex);
		return sheet.getRow(0).getLastCellNum();
	}
	
	public  String getSpecificSheetData(int sheetindex,int rows,int cell)
	{
		XSSFSheet sheet = workbook.getSheetAt(sheetindex);
		XSSFCell cells=sheet.getRow(rows).getCell(cell);
		if(cells.getCellType()==XSSFCell.CELL_TYPE_STRING)
		{
			return sheet.getRow(rows).getCell(cell).getStringCellValue();
			
		}
		if(cells.getCellType()==XSSFCell.CELL_TYPE_NUMERIC)
		{
			return sheet.getRow(rows).getCell(cell).getRawValue();
		}
		else {
			return null;
		}
		
	}
	
	public Object[][] getAllData(int sheetindex)
	{
		XSSFSheet sheet = workbook.getSheetAt(sheetindex);
		int rows = getRowCount(sheetindex);
		int cells=getColCount(sheetindex);
		System.out.println(rows+"X"+cells);
		Object[][] obj = new Object[rows][cells];
		for(int i=0; i<rows;i++)
		{
			for(int j=0;j<cells;j++)
			{
				
				obj[i][j]=getSpecificSheetData(sheetindex, i, j);
			}
		}
		
		return obj;
	}
	
}
