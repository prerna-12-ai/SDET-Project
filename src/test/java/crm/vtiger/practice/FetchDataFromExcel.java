package crm.vtiger.practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchDataFromExcel {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		DataFormatter df=new DataFormatter();
		
		//Step 1=> convert the physical file into java readable object
		FileInputStream fis = new FileInputStream("./src/test/resources/testData.xlsx");
		//step 2 ==> open excel
		Workbook wb = WorkbookFactory.create(fis);
		FormulaEvaluator evaluator = wb.getCreationHelper().createFormulaEvaluator();
		//step 3 ==> get control on sheet
		Sheet sheet = wb.getSheet("Sheet4");
		//step 4==> get control on row
		Row row = sheet.getRow(0);
		//step 5==> get control on cell
		Cell cell = row.getCell(2);
		//step 6 ==> fetch data 
		 String data = df.formatCellValue(cell,evaluator);
//		 String data = cell.getStringCellValue();
//		 String data = cell.toString();
		//step 7 ==> utilize data
		System.out.println(data);
		//step 8 ==> close stream, workbook
		wb.close();
		fis.close();

	}
}
