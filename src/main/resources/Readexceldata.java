import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Readexceldata {

	
	@Test
	public void getdata()
	{
	
		File file1= new File("C:\\Users\\bhavani.kore\\Desktop\\dataprovider.xlsx");
		
	FileInputStream fis= new FileInputStream(file1);
	
	XSSFWorkbook wbk= new XSSFWorkbook(fis);
	
	XSSFSheet sheet=wbk.getSheetAt(1);
	
	XSSFRow row=sheet.getRow(0)// returns first row in the sheet
	
	int colcount=row.getLastCellNum();
	
	System.out.println("total number of columns in excel sheet" +colcount);
	
	//row count
	int rowcount=sheet.getLastRowNum()+1;
	
	System.out.println("total number of rows in excel sheet" +rowcount);
	
	for(int i=0;i<rowcount;i++) {
		XSSFRow row=sheet.getRow(i);
		
		for(int j=0;j<row.getLastCellNum();j++) {
			
			System.out.Prnt(row.getCell(j));
			
			
		}
	}
	
	
	

	}

}
