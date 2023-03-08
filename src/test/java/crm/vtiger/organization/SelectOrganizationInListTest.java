package crm.vtiger.organization;

import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.tyss.genericUtiltiy.Base.BaseClass;
import com.tyss.genericUtiltiy.Misc.UtilityInstanceTranfer;
import com.tyss.genericUtiltiy.annotation.Report;

import crm.vtiger.objectRepository.TabNames;

public class SelectOrganizationInListTest extends BaseClass{
	@Report(author = "mohan")
	@Test
	public  void selectOrganizationInListTest() throws EncryptedDocumentException, IOException {
		
		//create contat
		commonPage.clickTab(TabNames.ORGANIZATIONS);
		report.info(UtilityInstanceTranfer.getExtentTest(),"selectOrganizationInListTest 1");
		String orgName="Sdet46_3";
		String colName="Organization Name";

		List<WebElement> list = driver.findElements(By
				.xpath("//table[@class='lvt small']/tbody/tr[1]/td/a"));
		int count=0;
		for (int i=0;i<list.size();i++) {
			String actHeader = list.get(i).getText();
			if(colName.equals(actHeader)) {
				count=i+2;
				break;
			}
		}
		
		report.info(UtilityInstanceTranfer.getExtentTest(),"selectOrganizationInListTest 2");
		Assert.fail();
		String strPages=driver.findElement(By.xpath("//a[text()='Create Mail Merge templates ']/following::span[@name]")).getText();
		int pages =javaUtility.parseNumber(javaUtility.split(strPages, " ")[1]);


		boolean flag=false;
		for (int i = 0; i < pages; i++) {
			List<WebElement> listOrg = driver.findElements(By
					.xpath("//table[@class='lvt small']/tbody/tr/td["+count+"]"));
			for (WebElement webElement : listOrg) {
				String actOrg = webElement.getText();
				javaUtility.consolePrint(actOrg);
				if(actOrg.equals(orgName)) {
					driver.findElement(By.xpath("//a[text()='"+orgName+"']/../preceding-sibling::td/input")).click();
					flag=true;
					break;
				}
			}
			if(flag) {
				break;
			}
			else {

				driver.findElement(By.xpath("//a[@title='Next']")).click();
				waitUtility.waitUntillInvisible("//div[@id='status']");

			}	
		}
		report.info(UtilityInstanceTranfer.getExtentTest(),"selectOrganizationInListTest 3");
		waitUtility.pause(5000);
	}
}

