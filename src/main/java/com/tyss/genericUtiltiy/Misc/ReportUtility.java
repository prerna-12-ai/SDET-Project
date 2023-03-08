package com.tyss.genericUtiltiy.Misc;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.tyss.genericUtiltiy.constants.FrameworkConstans;
import com.tyss.genericUtiltiy.enums.PropertyKey;
import com.tyss.genericUtiltiy.externalFileUtility.PropertyUtiltiy;
/**
 * 
 * @author MOHAN GOWDA
 *
 */
public class ReportUtility {
	private ExtentReports report;
	private String extentReportPath;
	/**
	 * 
	 */
	public ReportUtility() {
		init();
	}

	/**
	 * 
	 * @param filePath
	 * @param title
	 * @param reportName
	 * @param browserName
	 */
	private void init() {
		PropertyUtiltiy propUtil=null;
		try {
			propUtil=new PropertyUtiltiy(FrameworkConstans.REPORT_PROPERTY_FILE_PATH);
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		String overrideOrNot=propUtil.getPropertyData(PropertyKey.OVERRIDEREPORT);
		String randomName="";
		if(overrideOrNot.equalsIgnoreCase("no")) {
			randomName="_"+new JavaUtiltiy().getCurrentDateTime();
		}
		 extentReportPath=FrameworkConstans.EXTENT_REPORT_FOLDER_PATH+"extentReport"+randomName+".html";
		ExtentSparkReporter spark=new ExtentSparkReporter(extentReportPath);
		spark.config().setDocumentTitle(propUtil.getPropertyData(PropertyKey.EXTENTREPORTTITLE));
		spark.config().setReportName(propUtil.getPropertyData(PropertyKey.EXTENTREPORTNAME));
		spark.config().setTheme(Theme.DARK);

		report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("Browser", propUtil.getPropertyData(PropertyKey.BROWSER));
		report.setSystemInfo("OS", System.getProperty("os.name"));

	}
	/**
	 * 
	 * @param testName
	 * @return 
	 * @return 
	 * @return 
	 */
	public void createTest(String testName) {
		 ExtentTest test = report.createTest(testName);
		UtilityInstanceTranfer.setExtentTest(test);
	}
	/**
	 * 
	 * @param message
	 */
	public void fail( ExtentTest test, String message,Throwable errorMsg) {
		test.fail(message);
		test.fail(errorMsg);
		System.out.println(message);
	}
	/**
	 * 
	 * @param names
	 */
	public void addAuthor(ExtentTest test, String... names) {
		test.assignAuthor(names);
	}
	/**
	 * 
	 * @param names
	 */
	public void addCategory(ExtentTest test, String... names) {
		test.assignCategory(names);
	}


	/**
	 * 
	 * @param message
	 */
	public void pass(ExtentTest test, String message) {
		test.pass(message);
		System.out.println(message);
	}
	/**
	 * 
	 * @param message
	 */
	public void warn(ExtentTest test, String message) {
		test.warning(message);
		System.out.println(message);
	}
	/**
	 * 
	 * @param message
	 */
	public void skip(ExtentTest test, String message, Throwable errorMsg) {
		test.skip(message);
		test.skip(errorMsg);
		System.out.println(message);
	}
	/**
	 * 
	 * @param message
	 */
	public void info(ExtentTest test, String message) {
		test.info(message);

		System.out.println(message);
	}
	/**
	 * 
	 * @param screenShotPath
	 * @param title
	 * @param strategy
	 */
	public void attachScreenShot(ExtentTest test, String screenShotPath,String title, String strategy) {
		if(strategy.equalsIgnoreCase("base64")) {
			test.addScreenCaptureFromBase64String(screenShotPath, title);
		}
		else {
			test.addScreenCaptureFromPath(screenShotPath,title);
		}
	}
	/**
	 * 
	 */
	public void saveReport() {
		report.flush();
	
		try {
			Desktop.getDesktop().browse(new File(extentReportPath).toURI());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
