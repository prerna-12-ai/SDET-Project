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
import crm.vtiger.objectRepository.CreateNewOrganizationPage;
import crm.vtiger.objectRepository.OrganizationInformationPage;
import crm.vtiger.objectRepository.OrganizationsPage;
import crm.vtiger.objectRepository.TabNames;

public class CreateContactWithOrganizationTest extends BaseClass{
	@Report(author = "sanjay")
	@Test
	public void createContactWithOrganizationTest() throws InterruptedException  {
			//test data
		String sheetName=ExcelSheet.CONTACTS.getSheetName();
		String exptestCaseName="CreateContactWithOrganizationTest";
		Map<String, String> map = excelUtility.getData(sheetName, exptestCaseName);
		System.out.println(map);

		String expOrgName=map.get("OrgName")+randomNumber;
		String expContactName=map.get("ContactName")+randomNumber;
		String expIndustry=map.get("industry");

		report.info(UtilityInstanceTranfer.getExtentTest(),"createContactWithOrganizationTest 1");
		ContactsPage contactsPage=new ContactsPage(driver);
		CreateNewContactPage createNewContactPage=new CreateNewContactPage(driver);
		ContactInformationPage contactInformationPage=new ContactInformationPage(driver);
		OrganizationsPage organizationsPage=new OrganizationsPage(driver);
		OrganizationInformationPage organizationInformationPage=new OrganizationInformationPage(driver);
		CreateNewOrganizationPage createNewOrganizationPage=new CreateNewOrganizationPage(driver);
		report.info(UtilityInstanceTranfer.getExtentTest(),"createContactWithOrganizationTest 2");
		
		//create contat
		commonPage.clickTab(TabNames.ORGANIZATIONS);
		organizationsPage.clickCreateOrganizationLookUpImg();
		createNewOrganizationPage.createOrgnization(expOrgName,expIndustry,dropdownUtility);

		String actOrgName = organizationInformationPage.getorganizationName(waitUtility);
		String actIndustry= organizationInformationPage.getIndustryName();
		verificationUtility.exactVerify(expOrgName, actOrgName, "element", "orgName");
		verificationUtility.exactVerify(actIndustry, expIndustry, "element", "industry");
		report.info(UtilityInstanceTranfer.getExtentTest(),"createContactWithOrganizationTest 3");
Assert.fail();
		commonPage.clickTab(TabNames.CONTACTS);
		contactsPage.clickCreateContactLookUpImg();
		createNewContactPage.createContact(expContactName, expOrgName, popupUtility, waitUtility);

		String actLastName =contactInformationPage.getLastName(waitUtility);
		String actOrgInCon =contactInformationPage.getOrgnizationName();
		report.info(UtilityInstanceTranfer.getExtentTest(),"createContactWithOrganizationTest 4");
		verificationUtility.exactVerify(actLastName, expContactName, "element", "LastName");
		verificationUtility.exactVerify(actOrgInCon, expOrgName, "element", "OrgName");
		

	}

}
