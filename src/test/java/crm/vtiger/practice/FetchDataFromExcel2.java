package crm.vtiger.practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchDataFromExcel2 {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		String sheetName="Contact";
		String exptestCaseName="CreateContactTest";
	
		DataFormatter df=new DataFormatter();
		FileInputStream fis = new FileInputStream("./src/test/resources/excel/testData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum(); //index
		Map<String, String> map=new HashedMap<>();
		for (int i = 1; i <= rowCount; i++) {
			String testScriptName = df.formatCellValue(sheet.getRow(i).getCell(0));		
			if(testScriptName.equalsIgnoreCase(exptestCaseName)) {
				for (int j = 1; j < sheet.getRow(i).getLastCellNum(); j++) {
					String key = df.formatCellValue(sheet.getRow(i).getCell(j));
					String value = df.formatCellValue(sheet.getRow(i+1).getCell(j));
					map.put(key, value);
				}
				break;
		}
	}
		System.out.println(map.get("LastName")+"   ======> "+map.get("Department"));
}
}
