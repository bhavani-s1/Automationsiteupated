package com.atmecs.automationsite.helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

		public class Testclass {
		@Test
		public void getdata() throws InvalidFormatException, IOException
		{
		
			File file1= new File("C:\\Users\\bhavani.kore\\Desktop\\dataprovider.xlsx");
			
		FileInputStream fis= new FileInputStream(file1);
		
		XSSFWorkbook wbk= new XSSFWorkbook(file1);
		
		XSSFSheet sheet=wbk.getSheetAt(0);
		
		//rowcount 
		
		int rowcount=sheet.getLastRowNum()+1;
		
		for(int i=0;i<rowcount;i++) {
			XSSFRow row=sheet.getRow(i);
			
			for(int j=0;j<row.getLastCellNum();j++) {
				
				System.out.println(row.getCell('j')+"||");
				
				
				
			
				
				
			}
		}
		
		
		

		}

	}

	

