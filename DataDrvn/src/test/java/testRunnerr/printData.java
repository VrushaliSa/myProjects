package testRunnerr;

import java.io.IOException;

import ExcelReader.ReadExcel1;

public class printData {

	public printData() {
		// printing data
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ReadExcel1 rd = new ReadExcel1("E:\\softtech\\data1.xlsx");
		Object[][] myArray = rd.getAllData(0);
		int numRows = myArray.length;
		int numCols = myArray[0].length;
		Object[][] newArr = new Object[numRows - 1][numCols];
		
		// Storing data in new array without col names
		for (int i = 1; i < numRows; i++) {
			for (int j = 0; j < numCols; j++) {
				newArr[i - 1][j] = myArray[i][j];
			}
			
		}
		
		/*//Or WE CAN USE LIKE THIS BY  STARTING FROM INDEX 1
		for (int i = 1; i < numRows; i++) {
			for (int j = 0; j < numCols; j++) {
				System.out.println(myArray[i][j]);
			}
		}
		*/	
		
		System.out.println("===========MYARR(After Deleting ColNames)=================");
		for (int i = 0; i < numRows - 1; i++) {
			for (int j = 0; j < numCols; j++) {
				System.out.println(newArr[i][j]);
			}
			System.out.println(); // Move to the next line after each row
		}

	}
}
