package com.tyss.genericUtiltiy.externalFileUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.tyss.genericUtiltiy.enums.PropertyKey;
/**
 * This class contains reusable methods for handle propertyFile
 * @author MOHAN GOWDA
 *
 */
public class PropertyUtiltiy {
	private Properties prop;

	/**
	 * This constructor will intiallize the property file
	 * @param filePath
	 * @throws IOException
	 */
	public PropertyUtiltiy(String filePath) throws IOException {
		FileInputStream fisProperty = new FileInputStream(filePath);
		prop = new Properties();
		prop.load(fisProperty);
		fisProperty.close();
	}
	/**
	 * This constructor is used to create object for class
	 */
	public PropertyUtiltiy(){
	}
	/**
	 * This method is used to intiallize Property File
	 * @deprecated new PropertyUtiltiy(String filePath)
	 * @param filePath
	 * @throws Throwable
	 */
	@Deprecated
	public void intiallizePropertyFile(String filePath) throws Throwable {
		FileInputStream fisProperty = new FileInputStream(filePath);
		prop = new Properties();
		prop.load(fisProperty);
		fisProperty.close();
	}
	/**
	 * This method is used to fetch data from property file based on key
	 * @param key
	 * @return
	 */
	public String getPropertyData(PropertyKey key) {
		String keyString=key.name().toLowerCase();
		String value=prop.getProperty(keyString,"please give proper key '"+keyString+"'").trim();
		return value;
	}


}
