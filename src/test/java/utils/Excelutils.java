package utils;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import Constant.Constants;

public class Excelutils {


	static 	XSSFWorkbook Workbook;
	static XSSFSheet sheet;
	static FileInputStream fis;

	public 	Excelutils(String excelpath,String sheetname) {
		try
		{
			fis = new FileInputStream(excelpath); 	
			Workbook= new XSSFWorkbook(fis);
			sheet= Workbook.getSheet(sheetname);
		}catch (Exception e) {
			// TODO Auto-generated catch block			
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}		

	}	



	public static Object getCellData(int rowNum, int colNum) {


		//			String excelPath=  "./DataFromExcel/TestData.xlsx";
		//			 Workbook= new XSSFWorkbook(excelPath);
		//			 sheet= Workbook.getSheet("Sheet1");
		//			
		//Get any data type value we need dataformatter		
	
		DataFormatter formatter=new DataFormatter();
		Object value=	formatter.formatCellValue(sheet.getRow(rowNum).getCell(colNum));
		//String value=sheet.getRow(1).getCell(1).getStringCellValue();
		System.out.println(value);
		return value;			
	}

	public static void writedatainExcel(int rowNum, int colNum, String ax) throws IOException
	{

		Row row = sheet.getRow(rowNum); if (row == null) row = sheet.createRow(rowNum);
		Cell cell = row.getCell(colNum); if (cell == null) cell = row.createCell(colNum);

		//Cell cell2Update = sheet.getRow(rowNum).getCell(colNum);

		sheet.getRow(rowNum).getCell(colNum).setCellValue(ax);


		//		Object empdata[][]= {
		//				{"EmpId", "Name", "Job"},
		//				{101, "David", "Engineer"},
		//				{102, "smitt", "Manager"},
		//				{103, "scott", "Analyst"}
		//		};
		//		
		//		//using for loop
		//		int rows= empdata.length;
		//		int cols= empdata[0].length;
		//		
		//		for(int r=0;r<rows;r++)
		//		{
		//			XSSFRow row=sheet.createRow(r);
		//			
		//			for(int c=0;c<cols; c++)
		//			{
		//			XSSFCell cell=  row.createCell(c);
		//		Object value=	empdata[r][c];
		//		
		//		if(value instanceof String)
		//			cell.setCellValue((String) (value));
		//		
		//		if(value instanceof Integer)
		//			cell.setCellValue((Integer) (value));
		//		
		//		if(value instanceof Boolean)
		//			cell.setCellValue((Boolean) (value));
		//		
		//		     }
		//		}
		//		


		fis.close();
		//FileOutputStream outstream= new FileOutputStream(Constants.excelPath);
		Workbook.write(new FileOutputStream(Constants.excelPath)); 
		//Workbook.close();

		//		if(value instanceof String)
		//			cell2Update.setCellValue((String) (value));
		//		

		//		XSSFRow row= sheet.createRow(rowNum);
		//		XSSFCell cell= row.createCell(colNum);
		//		Object variable=value;
		//		if(variable instanceof String)
		//			cell.setCellValue((String) (variable));




	}


	public static int getRowcount()
	{		
		int rowCount=sheet.getPhysicalNumberOfRows();
		System.out.println(rowCount);
		return 	rowCount;	
	}



	public static XSSFWorkbook getWorkbook() {
		return Workbook;
	}



	public static void setWorkbook(XSSFWorkbook workbook) {
		Workbook = workbook;
	}



	public static XSSFSheet getSheet() {
		return sheet;
	}



	public static void setSheet(XSSFSheet sheet) {
		Excelutils.sheet = sheet;
	}

}
