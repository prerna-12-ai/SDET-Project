package crm.vtiger.practice;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.jayway.jsonpath.JsonPath;

public class WriteDataIntoExcelSanjay {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {

		DataFormatter df=new DataFormatter();
		FileInputStream fis = new FileInputStream("./src/test/resources/excel/MasterData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet apisheet = wb.getSheet("FieldAPI");
		int rowCount = apisheet.getLastRowNum(); 
		int j=1;
		for (int i = 1; i <= rowCount; i++) {
			String api = df.formatCellValue(apisheet.getRow(i).getCell(1));		
			String a = JsonPath.read(api, "name");
			List<String> label = JsonPath.read(api, "$.fields[*].label");
			List<String> name = JsonPath.read(api, "$.fields[*].name");
			//			System.out.println(a);
			//			System.out.println(label);
			//			System.out.println(name);
			Sheet fieldSheet = wb.getSheet("ModuleFields");
			try {	
				fieldSheet.getRow(j).createCell(0).setCellValue(a);
			}catch (Exception e) {
				fieldSheet.createRow(j).createCell(0).setCellValue(a);
			}
			for(int k=0;k<label.size();k++)	fieldSheet.getRow(j).createCell(k+1).setCellValue(label.get(k)+"###"+name.get(k));
			j=j+3;
			System.out.println(a+" data added successfully");
		}
		wb.write(new FileOutputStream("./src/test/resources/excel/MasterData.xlsx"));
		System.out.println("excel data saved successfully");
	}
}
