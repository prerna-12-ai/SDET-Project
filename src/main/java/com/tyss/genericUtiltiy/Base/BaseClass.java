package com.tyss.genericUtiltiy.Base;
/**
 * This class contains all TestNG config annotations
 * @author MOHAN GOWDA
 *
 */

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.tyss.genericUtiltiy.Listener.ExtentReportListener;
import com.tyss.genericUtiltiy.Misc.JavaUtiltiy;
import com.tyss.genericUtiltiy.Misc.VerificationUtility;
import com.tyss.genericUtiltiy.WebAction.DropdownUtility;
import com.tyss.genericUtiltiy.WebAction.IntractionUtility;
import com.tyss.genericUtiltiy.WebAction.PopupUtility;
import com.tyss.genericUtiltiy.WebAction.SeleniumUtilitiy;
import com.tyss.genericUtiltiy.WebAction.WaitUtiliy;
import com.tyss.genericUtiltiy.constants.FrameworkConstans;
import com.tyss.genericUtiltiy.enums.PropertyKey;
import com.tyss.genericUtiltiy.externalFileUtility.ExcelUtility;
import com.tyss.genericUtiltiy.externalFileUtility.PropertyUtiltiy;

import crm.vtiger.objectRepository.CommonPage;
import crm.vtiger.objectRepository.LoginPage;
/**
 * djosajdojlskdjlksdjljsfdljklksjljj
 * @author MOHAN GOWDA
 *This class used for configure all TestNG Config Annotations
 */
@Listeners(ExtentReportListener.class)
public class BaseClass extends BaseClassDeclaration{
	
	
/**
 * 	Author: Harsha
 * @throws IOException
 */
	@Parameters(value = "browser")
@BeforeClass
	public void intaillationSetUp(@Optional String browser) throws IOException {
		report=ExtentReportListener.sreport;
		 proprtyUtlis=new PropertyUtiltiy(FrameworkConstans.TEST_PROPERTY_FILE_PATH);
		 excelUtility=new ExcelUtility(FrameworkConstans.TEST_EXCEL_FILE_PATH);
		 javaUtility=new JavaUtiltiy();
		 seleniumUtility=new SeleniumUtilitiy();
		 verificationUtility=new VerificationUtility();
		 dropdownUtility=new DropdownUtility();
		 popupUtility=new PopupUtility();
			//common data
		 if(browser==null || browser.isEmpty()||browser.equals("")) {
			 browser=proprtyUtlis.getPropertyData(PropertyKey.BROWSER);
			
			 }
		 this.browser=browser;
			// 
			 timeout=Long.parseLong(proprtyUtlis.getPropertyData(PropertyKey.TIMEOUT));
			 url=proprtyUtlis.getPropertyData(PropertyKey.URL);
			 username=javaUtility.decode(proprtyUtlis.getPropertyData(PropertyKey.USERNAME));
			 password=javaUtility.decode(proprtyUtlis.getPropertyData(PropertyKey.PASSWORD));
			 randomNumber=javaUtility.getRandomNumber(1000);
		
	}


	/**
	 * 
	 */
	@BeforeMethod
	public void methodSetUp(){
		
		driver = seleniumUtility.launchBrowser(browser);
		//object for genericUtility requires driver instance
		 waitUtility=new WaitUtiliy(driver, timeout);
		 interactionUtility=new IntractionUtility(driver);
		//object for common pom class
		 loginPage=new LoginPage(driver);
		 commonPage=new CommonPage(driver);
		waitUtility.waitForElementLoad(driver,10);
		//navigating the application
		seleniumUtility.launchApplicationWithMaximizeScreen(url);
		//login to the app
		loginPage.loginAction(username, password);
	}
	
	/**
	 * @throws IOException 
	 * 
	 */
	@AfterMethod 
	public void tearDown() {
				commonPage.signout(interactionUtility);
				seleniumUtility.closeBrowser();
	}
	
	/**
	 * 
	 * @throws IOException
	 */
	@AfterClass
	public void intiallizationTearDown() throws IOException {
		excelUtility.close();
	}
	
	
	
}
