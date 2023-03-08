package crm.vtiger.practice;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class StoreDataIntoPropertyFile {

	public static void main(String[] args) throws IOException {
		//Step 1=> convert the physical file into java readable object
		FileOutputStream fos = new FileOutputStream("./src/test/resources/commonData/commonData.properties", true);

		//Step 2==> create object for properties class
		Properties prop = new Properties();
		
		//step3 --> store data
		prop.setProperty("url", "http://localhost:8888");
		
		//step4 --> save data
		prop.store(fos,"");
		
		//step5 --> close stream
		fos.close();
	}

}
