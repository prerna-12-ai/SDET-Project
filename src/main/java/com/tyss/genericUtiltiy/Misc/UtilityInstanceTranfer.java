package com.tyss.genericUtiltiy.Misc;

import com.aventstack.extentreports.ExtentTest;
/**
 * 
 * @author MOHAN GOWDA
 *
 */
public class UtilityInstanceTranfer {
	private static ThreadLocal<ExtentTest> extentTest=new ThreadLocal<>();
	/**
	 * 
	 * @return
	 */
	public static ExtentTest getExtentTest() {
		return extentTest.get();
	}
	/**
	 * 
	 * @param setExtentTest
	 */
	public static void setExtentTest(ExtentTest setExtentTest) {
		extentTest.set(setExtentTest);
	}





}
