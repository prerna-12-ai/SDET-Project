package crm.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tyss.genericUtiltiy.WebAction.DropdownUtility;

public class CreateNewOrganizationPage {
	
	@FindBy(name ="accountname")
	private WebElement accountnameTxt;
	
	@FindBy(xpath ="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(xpath ="//select[@name='industry']")
	private WebElement industryDropdown;
	
	@FindBy(xpath ="//select[@name='accounttype']")
	private WebElement typeDropdown;
	

	@FindBy(xpath ="//span[@class='lvtHeaderText']")
	private WebElement headerText;
	

	public CreateNewOrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		}
		
		public void createOrgnization(String oranizationName) {
			accountnameTxt.sendKeys(oranizationName);
			saveBtn.click();
		}
		
		public void createOrgnization(String oranizationName, String industryName, DropdownUtility dropdownUtility) {
			accountnameTxt.sendKeys(oranizationName);
			dropdownUtility.handleDropDown(industryDropdown, industryName);
			saveBtn.click();
		}
		public String getHeaderText() {
			return headerText.getText();
		}
}
