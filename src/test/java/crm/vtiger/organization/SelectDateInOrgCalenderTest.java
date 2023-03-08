package crm.vtiger.organization;

import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.tyss.genericUtiltiy.Base.BaseClass;
import com.tyss.genericUtiltiy.Misc.UtilityInstanceTranfer;
import com.tyss.genericUtiltiy.annotation.Report;
import com.tyss.genericUtiltiy.enums.ExcelSheet;

import crm.vtiger.objectRepository.TabNames;

public class SelectDateInOrgCalenderTest extends BaseClass{
	@Report(author = "Harsha")
	@Test
	public void selectDateInOrgCalenderTest() throws IOException {
		Map<String, String> testData = excelUtility.getData(ExcelSheet.ORGANIZATION.getSheetName(), "SelectDateInOrgCalenderTest");
		javaUtility.consolePrint(testData);
		int reqMonthNum = javaUtility.getMonthNumber(testData.get("reqMonth"), "MMMM");
		int reqYearNum=javaUtility.parseNumber(testData.get("reqYear"));
		report.info(UtilityInstanceTranfer.getExtentTest(),"selectDateInOrgCalenderTest 1");
		//create contat
		commonPage.clickTab(TabNames.ORGANIZATIONS);
		//click on calender icon/widget
		driver.findElement(By.xpath("//img[@title='Open Calendar...']")).click();
		//fetch current month and year
		WebElement ele = driver.findElement(By.xpath("//td[@class='calHdr']/a/b"));
		waitUtility.waitUntillVisible(driver.findElement(By.xpath("//td[@class='calHdr']/a/b")));
		String curMonthYear = ele.getText();
		report.info(UtilityInstanceTranfer.getExtentTest(),"selectDateInOrgCalenderTest 2");
		//store month and year seperate
		String curMonth=javaUtility.split(curMonthYear, " ")[0];
		String curYear=javaUtility.split(curMonthYear, " ")[1];

		//January --> MMMM , 01 --> MM, HH, mm, yyyy, DD,sss,MMM
		int curMonthNum = javaUtility.getMonthNumber(curMonth, "MMMM");
		int curYearNum=javaUtility.parseNumber(curYear);
		report.info(UtilityInstanceTranfer.getExtentTest(),"selectDateInOrgCalenderTest 3");
		//verify with required month and year and click on next
		while(reqMonthNum>curMonthNum || reqYearNum>curYearNum)
		{
			driver.findElement(By.xpath("//img[@src='themes/images/small_right.gif']"))
			.click();	
			waitUtility.waitUntillInvisibleOfText("//td[@class='calHdr']/a/b", curMonthYear);
			curMonthYear = driver.findElement(By.xpath("//td[@class='calHdr']/a/b")).getText();
			javaUtility.consolePrint(curMonthYear);
			curMonth=javaUtility.split(curMonthYear, " ")[0];
			curYear=javaUtility.split(curMonthYear, " ")[1];
			 curMonthNum = javaUtility.getMonthNumber(curMonth, "MMMM");
			curYearNum=javaUtility.parseNumber(curYear);
			
		}
		report.info(UtilityInstanceTranfer.getExtentTest(),"selectDateInOrgCalenderTest 4");
		while(reqMonthNum<curMonthNum || reqYearNum<curYearNum)
		{
			driver.findElement(By.xpath("//img[@src='themes/images/small_left.gif']"))
			.click();	
			waitUtility.waitUntillInvisibleOfText("//td[@class='calHdr']/a/b", curMonthYear);
			curMonthYear = driver.findElement(By.xpath("//td[@class='calHdr']/a/b")).getText();
			javaUtility.consolePrint(curMonthYear);
			curMonth=javaUtility.split(curMonthYear, " ")[0];
			curYear=javaUtility.split(curMonthYear, " ")[1];
			 curMonthNum = javaUtility.getMonthNumber(curMonth, "MMMM");
			curYearNum=javaUtility.parseNumber(curYear);
		}
		report.info(UtilityInstanceTranfer.getExtentTest(),"selectDateInOrgCalenderTest 5");
		//click on date
		driver.findElement(
				By.xpath("//a[contains(@href,'view=day') and text()='"+testData.get("reqDate")+"']"))
		.click();
		waitUtility.pause(5000);
	}
}

