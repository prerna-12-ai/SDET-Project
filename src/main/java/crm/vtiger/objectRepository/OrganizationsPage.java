package crm.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {
	
	@FindBy(xpath="//img[@title='Create Organization...']")
	private WebElement createOrganizationLookUpImg;
	
	@FindBy(className ="hdrLink")
	private WebElement OrganizationHeaderLink;
	
	public OrganizationsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void clickCreateOrganizationLookUpImg() {
		createOrganizationLookUpImg.click();
	}
	
	public void clickOrganizationHeaderLink() {
		OrganizationHeaderLink.click();
	}
}
