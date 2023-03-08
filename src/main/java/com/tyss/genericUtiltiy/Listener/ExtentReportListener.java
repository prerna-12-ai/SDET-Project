package com.tyss.genericUtiltiy.Listener;

import org.testng.IClassListener;
import org.testng.IMethodInstance;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestClass;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.tyss.genericUtiltiy.Base.BaseClass;
import com.tyss.genericUtiltiy.Misc.ReportUtility;
import com.tyss.genericUtiltiy.Misc.UtilityInstanceTranfer;
import com.tyss.genericUtiltiy.annotation.Report;
/**
 * 
 * @author MOHAN GOWDA
 *
 */
public class ExtentReportListener implements ITestListener, ISuiteListener,IClassListener {

	private ReportUtility report;
	public static ReportUtility sreport;

	/**
	 * 
	 */
	@Override
	public void onStart(ISuite suite) {
		System.out.println("onStart --> Suite");
		report = new ReportUtility();
		sreport=report;
	}
	/**
	 * 
	 */
	@Override
	public void onFinish(ISuite suite) {
		System.out.println("onStart --> Suite");
		report.saveReport();
	}
	/**
	 * 
	 */
	@Override
	public void onBeforeClass(ITestClass testClass) {
		System.out.println("onBeforeClass");
	}
	/**
	 * 
	 */
	@Override
	public void onAfterClass(ITestClass testClass) {
		System.out.println("onAfterClass");
	}

	/**
	 * 
	 */
	@Override 
	public void onStart(ITestContext context) {
		System.out.println("onStart --> Test");

	}
	/**
	 * 
	 */
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("onTestStart");
		report.createTest(result.getMethod().getMethodName());
		Report reportAnnotation = result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(Report.class);
		System.out.println(reportAnnotation.author());
		System.out.println(reportAnnotation.category());
		report.addAuthor(UtilityInstanceTranfer.getExtentTest(),reportAnnotation.author());
		report.addCategory(UtilityInstanceTranfer.getExtentTest(),reportAnnotation.category());
	}
	/**
	 * 
	 */
	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("onTestSuccess");
		report.pass(UtilityInstanceTranfer.getExtentTest(), "<b>"+result.getMethod().getMethodName()+"</b> is pass");
	}
	/**
	 * 
	 */
	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("onTestFailure");
		report.fail(UtilityInstanceTranfer.getExtentTest(),"<b>"+result.getMethod().getMethodName()+"</b> is Failed", result.getThrowable());


		String screenShotPath = null;
		//		try {
		//			 screenShotPath = BaseClassPractice.class.cast(result.getMethod().getInstance()).sUtil.getScreenShot( 
		//					result.getMethod().getRealClass().getSimpleName(), 
		//					BaseClassPractice.class.cast(result.getMethod().getInstance()).jUtil);
		//		} catch (IOException e) {
		//			e.printStackTrace();
		//		}

		screenShotPath = BaseClass.class.cast(result.getMethod().getInstance()).seleniumUtility.getScreenShot();


		report.attachScreenShot(UtilityInstanceTranfer.getExtentTest(),screenShotPath,result.getMethod().getMethodName(), "base64");
	}
	/**
	 * 
	 */
	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("onTestSkipped");
		report.skip(UtilityInstanceTranfer.getExtentTest(),"<b>"+result.getMethod().getMethodName()+"</b> is Skipped",result.getThrowable());
	}
	/**
	 * 
	 */
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("onTestFailedButWithinSuccessPercentage");
	}
	/**
	 * 
	 */
	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		System.out.println("onTestFailedWithTimeout");

	}

	/**
	 * 
	 */
	@Override
	public void onFinish(ITestContext context) {
		System.out.println("onFinish --> Test");
	}
	
}
