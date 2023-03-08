package crm.vtiger.contacts;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.tyss.genericUtiltiy.Base.BaseClass;
import com.tyss.genericUtiltiy.Misc.UtilityInstanceTranfer;
import com.tyss.genericUtiltiy.annotation.Report;
import com.tyss.genericUtiltiy.enums.ExcelSheet;

import crm.vtiger.objectRepository.ContactInformationPage;
import crm.vtiger.objectRepository.ContactsPage;
import crm.vtiger.objectRepository.CreateNewContactPage;
import crm.vtiger.objectRepository.TabNames;

public class CreateContactTest extends BaseClass{

	@Report(author = "mohan", category = "sanity")
	@Test
	public void createContactTest() {
		//test data
		String sheetName=ExcelSheet.CONTACTS.getSheetName();
		String exptestCaseName="CreateContactTest";
		Map<String, String> map = excelUtility.getData(sheetName, exptestCaseName);
		report.info(UtilityInstanceTranfer.getExtentTest(),"Test Data Fetched Succesfully");
		report.info(UtilityInstanceTranfer.getExtentTest(),map+"");
		
		String expLastName=map.get("LastName")+"_"+javaUtility.getRandomNumber(100);
		report.info(UtilityInstanceTranfer.getExtentTest(),"Exp Last Name ==> "+expLastName);
		//object for other pom class
		ContactsPage contactsPage=new ContactsPage(driver);
		CreateNewContactPage createNewContactPage=new CreateNewContactPage(driver);
		ContactInformationPage contactInformationPage=new ContactInformationPage(driver);	
		report.info(UtilityInstanceTranfer.getExtentTest(),"Require Objects for Pom classes Created Succesfully");
		//create contat
		commonPage.clickTab(TabNames.CONTACTS);
		report.info(UtilityInstanceTranfer.getExtentTest(),"Contact Tab Clicked successfully");
		contactsPage.clickCreateContactLookUpImg();
		report.info(UtilityInstanceTranfer.getExtentTest(),"Create Contact page showing successfully");
		createNewContactPage.createContact(expLastName);
		report.info(UtilityInstanceTranfer.getExtentTest(),"Contact Created Successfully");
		String actualLastName = contactInformationPage.getLastName(waitUtility);
		//validating contact last name
		Assert.assertEquals(actualLastName, expLastName);
		report.info(UtilityInstanceTranfer.getExtentTest(),"Actual Lastname verified succesfully With Exp Last name");
//		Assert.fail();
		
	}
}


