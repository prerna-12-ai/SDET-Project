package crm.vtiger.practice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tyss.genericUtiltiy.Base.BaseClass;
import com.tyss.genericUtiltiy.constants.FrameworkConstans;
import com.tyss.genericUtiltiy.externalFileUtility.ExcelUtility;



public class TestNGPracticeClass2 {
	ExcelUtility excel=new ExcelUtility(FrameworkConstans.TEST_EXCEL_FILE_PATH);
	
	@Test(dataProvider = "data")
	public void test1(String username, String password) {
		System.out.println("Hi");
	}   
	
	@DataProvider
	public  String[][] data() throws EncryptedDocumentException, IOException {
	
	 String[][] arr = excel.getData("dataprovider");
	return	arr;
	}
	
	
}
