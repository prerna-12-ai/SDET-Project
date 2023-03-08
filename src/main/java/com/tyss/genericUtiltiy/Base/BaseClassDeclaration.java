package com.tyss.genericUtiltiy.Base;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.tyss.genericUtiltiy.Misc.JavaUtiltiy;
import com.tyss.genericUtiltiy.Misc.ReportUtility;
import com.tyss.genericUtiltiy.Misc.VerificationUtility;
import com.tyss.genericUtiltiy.WebAction.DropdownUtility;
import com.tyss.genericUtiltiy.WebAction.IntractionUtility;
import com.tyss.genericUtiltiy.WebAction.PopupUtility;
import com.tyss.genericUtiltiy.WebAction.SeleniumUtilitiy;
import com.tyss.genericUtiltiy.WebAction.WaitUtiliy;
import com.tyss.genericUtiltiy.externalFileUtility.ExcelUtility;
import com.tyss.genericUtiltiy.externalFileUtility.PropertyUtiltiy;

import crm.vtiger.objectRepository.CommonPage;
import crm.vtiger.objectRepository.LoginPage;

public class BaseClassDeclaration {
	protected PropertyUtiltiy proprtyUtlis;
	protected ExcelUtility excelUtility;
	public JavaUtiltiy javaUtility;
	public SeleniumUtilitiy seleniumUtility;
	protected VerificationUtility verificationUtility;
	protected DropdownUtility dropdownUtility;
	protected PopupUtility popupUtility;
	protected int randomNumber;
	protected WebDriver driver;
	protected WaitUtiliy waitUtility;
	protected IntractionUtility interactionUtility;
	protected LoginPage loginPage;
	protected CommonPage commonPage;
	protected String browser;
	protected long timeout;
	protected String url;
	protected String username;
	protected String password;
	public  ReportUtility report;
	public ExtentTest test;

}
