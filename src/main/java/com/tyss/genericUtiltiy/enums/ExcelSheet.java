package com.tyss.genericUtiltiy.enums;

/**
 * This enum contains sheet name of excel
 * @author MOHAN GOWDA
 *
 */
public enum ExcelSheet {
	ORGANIZATION("Organization"), CONTACTS("Contact");

	String key;
	/**
	 * 
	 * @param key
	 */
	private ExcelSheet(String key) {
		this.key=key;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getSheetName() {
		return key;
	}

}
