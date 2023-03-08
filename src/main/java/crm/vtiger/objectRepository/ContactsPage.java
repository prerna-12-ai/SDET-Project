package crm.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {
	
	@FindBy(xpath="//img[@title='Create Contact...']")
	private WebElement createContactLookUpImg;
	
	@FindBy(xpath="//img[@title='Import Contacts']") 
	private WebElement importContactLookupImg;
	
	@FindBy(xpath="//img[@title='Export Contacts']") 
	private WebElement exportContactLookupImg;

	@FindBy(xpath="//input[@name='Export']") 
	private WebElement exportContactBtn;
	
	public ContactsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void clickCreateContactLookUpImg() {
		createContactLookUpImg.click();
	}
	
	public void clickImportContactLookUpImg() {
		importContactLookupImg.click();
	}
	
	public void clickExport() {
		exportContactLookupImg.click();
		exportContactBtn.click();
	}
}
