package crm.vtiger.practice;

import org.testng.annotations.Test;

import com.tyss.genericUtiltiy.Misc.ReportUtility;
import com.tyss.genericUtiltiy.Misc.UtilityInstanceTranfer;

public class ExtentReportPractice {

	@Test
	public void report() {
		
		ReportUtility report=new ReportUtility();
		report.createTest("test1");
		report.info(UtilityInstanceTranfer.getExtentTest(),"a1");
		report.info(UtilityInstanceTranfer.getExtentTest(),"b1");
		report.info(UtilityInstanceTranfer.getExtentTest(),"c1");
		report.createTest("test2");
		report.info(UtilityInstanceTranfer.getExtentTest(),"a2");
		report.info(UtilityInstanceTranfer.getExtentTest(),"b2");
		report.info(UtilityInstanceTranfer.getExtentTest(),"c2");
		report.saveReport();
	}

}
