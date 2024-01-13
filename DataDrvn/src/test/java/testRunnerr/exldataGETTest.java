package testRunnerr;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import ExcelReader.ReadExcel1;
import ExcelReader.excelReader;

public class exldataGETTest extends excelReader{
	static WebDriver driver ;
	@Ignore
	@Test(dataProvider="dp2",priority = 1)
	public void printData(String fname, String lname, String uname)
	{
		System.out.println(fname +" "+lname+" "+uname);
	}

	//@Ignore
	@Test(dataProvider="dp2",priority = 1)
	public void runExl(String fname, String lname, String uname) throws InterruptedException
	{
		Thread.sleep(2000);
		driver = new ChromeDriver();
		driver.navigate().to("https://www.facebook.com/reg");
		driver.findElement(By.name("firstname")).sendKeys(fname);
		driver.findElement(By.name("lastname")).sendKeys(lname);
		driver.findElement(By.name("reg_email__")).sendKeys(uname);
		Thread.sleep(5000);
		driver.quit();
		
	}
	
@DataProvider(name= "dp1")
	public static Object[][] datap() throws IOException
	
	{
	{System.out.println("-------------------");
	String filepath ="E:\\softtech\\data1.xlsx";
	XSSFWorkbook workbook = readFile(filepath);
	XSSFSheet sheet = getSheetby(0);
	int rc = row_count(sheet)+1;
	
	int cc = col_count(sheet);
	System.out.println(rc+"-----"+cc);
	Object[][] arr= new Object[rc][cc];
	for(int i=0;i<rc;i++)
	{
		for(int j=0;j<cc;j++)
		{
	      arr[i][j]=sheet.getRow(i).getCell(j).getStringCellValue();;
		}
		
	}
	
	// Deleting Column_Name row
	Object[][] newArr = new Object[arr.length - 1][arr[0].length];
	for (int i = 1; i < arr.length; i++) {
	    for (int j = 0; j < arr[i].length; j++) {
	        newArr[i - 1][j] = arr[i][j];
	    }
	}
	
	return newArr;
}
	}




@Test(priority = 2,enabled=false)
public void quitBrowser()
{
	driver.quit();
}



@DataProvider(name="dp2")
public Object[][] dp2() throws IOException
{
	ReadExcel1 rd = new ReadExcel1("E:\\softtech\\F11.xlsx");
	Object[][] data=rd.getAllData(0);
	/*int r =data.length;
	int c = data[0].length;
	for(int i=0;i<r;i++)
	{
		for(int j=0;j<c;j++)
		{
			System.out.println(data[i][j]);
		}
	}
	*/
	return data;
	
}









}
