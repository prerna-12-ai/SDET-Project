package crm.vtiger.practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FetchDataFromPropertyFile {
	
	public static void main(String[] args) throws IOException {
		//Step 1=> convert the physical file into java readable object
		FileInputStream fis = new FileInputStream("./src/test/resources/commonData/commonData.properties");
	
		//Step 2==> create object for properties class
	Properties prop = new Properties();
	
	//Step 3==> load all keys	
	prop.load(fis);
	
	//step 4 ==> fetch data
	String password = prop.getProperty("password");
	System.out.println(password);
	
	//Step 5 --> close input stream 
	fis.close();
	prop.clear();
	}

}
