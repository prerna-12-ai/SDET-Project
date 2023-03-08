package com.tyss.genericUtiltiy.externalFileUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * 
 * @author MOHAN GOWDA
 *
 */
public class ExcelUtility {
	private DataFormatter df;
	private Workbook wb ;
	/**
	 * 
	 */

	/**
	 * 
	 * @param fileName
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public ExcelUtility(String fileName) {
		try {
			intiallize(fileName);
		} catch (EncryptedDocumentException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 
	 * @param filePath
	 * @param sheetName
	 * @param exptestCaseName
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public Map<String, String> getData(String sheetName, String exptestCaseName) {
		
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
		
		
	return map;
	}
	
	/**
	 * 
	 * @param sheetName
	 * @return
	 */
public String[][] getData(String sheetName) {
		
		Sheet sheet = wb.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum(); //index
		String[][] arr=new String[rowCount][sheet.getRow(0).getLastCellNum()];
		for (int i = 1; i <= rowCount; i++) {
				for (int j = 0; j < sheet.getRow(i).getLastCellNum(); j++) {
				arr[i-1][j]=df.formatCellValue(sheet.getRow(i).getCell(j));
				}
		}
		return arr;
	}
	/**
	 * 
	 * @param sheetName
	 * @param exptestCaseName
	 * @param expectedKey
	 * @return
	 */
	public String getData(String sheetName, String exptestCaseName, String expectedKey) {
		
		Sheet sheet = wb.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum(); //index
		String value="";
		int testScriptCounter = 0;
		int keyCounter = 0;
		for (int i = 1; i <= rowCount; i++) {
			String testScriptName = df.formatCellValue(sheet.getRow(i).getCell(0));		
			
			if(testScriptName.equalsIgnoreCase(exptestCaseName)) {
				testScriptCounter++;
				for (int j = 1; j < sheet.getRow(i).getLastCellNum(); j++) {
					String key = df.formatCellValue(sheet.getRow(i).getCell(j));
					if(key.equalsIgnoreCase(expectedKey)) {
						keyCounter++;
					 value = df.formatCellValue(sheet.getRow(i+1).getCell(j));
					break;
					}
				}
				break;
		}
	}
		if(keyCounter==0) {
			if(testScriptCounter==0) {
				value="please give proper testScript key '"+exptestCaseName+"'";
			}
			else {
				value="please give proper testScript key '"+expectedKey+"'";
			}
		}
		System.out.println("Value fetched from excel ==> "+value);
	return value;
	}

	/**
	 * 
	 * @param filePath
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	private void intiallize(String filePath) throws EncryptedDocumentException, IOException {
		df=new DataFormatter();
		FileInputStream fisExcel = new FileInputStream(filePath);
		 wb = WorkbookFactory.create(fisExcel);
		fisExcel.close();
	}
	
	/**
	 * 
	 * @deprecated {@link getData(String sheetName, String exptestCaseName) }
	 * @param sheetName
	 * @param rowIndex
	 * @param cellIndex
	 * @return
	 */
	@Deprecated
	public String getData(String sheetName, int rowIndex, int cellIndex)  {
		  String value = df.formatCellValue(wb.getSheet(sheetName).getRow(rowIndex).getCell(cellIndex));
		return value;
	}
	/**
	 * 
	 * @throws IOException
	 */
	public void close() throws IOException {
		wb.close();
	}
	
	/**
	 * 
	 * @param sheetName
	 * @param rowIndex
	 * @param cellIndex
	 */
	public void setData(String sheetName,int rowIndex, int cellIndex) {
		wb.getSheet(sheetName).getRow(rowIndex).createCell(cellIndex);
	}
	/**
	 * 
	 * @param fileOutputPath
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void saveData(String fileOutputPath) throws FileNotFoundException, IOException {
		wb.write(new FileOutputStream(fileOutputPath));
	}
	

}
