package crm.vtiger.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tyss.genericUtiltiy.WebAction.PopupUtility;
import com.tyss.genericUtiltiy.WebAction.WaitUtiliy;

public class CreateNewContactPage {
	private WebDriver driver;
	@FindBy(name ="lastname")
	private WebElement lastNameTxt;

	@FindBy(xpath ="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;


	@FindBy(xpath ="//span[@class='lvtHeaderText']")
	private WebElement headerText;

	@FindBy(xpath ="//input[@name='search_text']")
	private WebElement searchField;

	@FindBy(xpath ="//input[@name='search']")
	private WebElement searchBtn;


	@FindBy(xpath ="//td[normalize-space(.)='Organization Name']/following-sibling::td/img")
	private WebElement organizationSerchLookupImg;

	public CreateNewContactPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	

	public void createContact(String contactName) {
		lastNameTxt.sendKeys(contactName);
		saveBtn.click();
	}
	public void createContact(String contactName, String orgName, PopupUtility popupUtility, WaitUtiliy waitUtiliy) throws InterruptedException {
		lastNameTxt.sendKeys(contactName);
		organizationSerchLookupImg.click();
		popupUtility.switchWindow(driver, "partial_title", "Popup");
		searchField.sendKeys(orgName);
		searchBtn.click();
		
		waitUtiliy.waitandClick(1000, 10, driver.findElement(By.xpath("//a[text()='"+orgName+"']")));
		popupUtility.switchWindow(driver, "partial_url", "Contacts");
		saveBtn.click();
	}

	public String getHeaderText() {
		return headerText.getText();
	}
}
