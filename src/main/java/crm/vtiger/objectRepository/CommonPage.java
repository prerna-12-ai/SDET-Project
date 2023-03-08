package crm.vtiger.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tyss.genericUtiltiy.WebAction.IntractionUtility;

public class CommonPage {
	private WebDriver driver;
	//declaration
	private String tabPartialXpath="//a[.='%s']";
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement admistrorIcon;
	
	@FindBy(linkText  = "Sign Out")
	private WebElement signOutLink;
	
	/**
	 * This method is used to convert partialXpath String into Webelement
	 * @param partialXpath
	 * @param replaceData
	 * @return
	 */
	private WebElement convertToWebElement(String partialXpath, String replaceData) {
		String xpath = String.format(partialXpath, replaceData);
		return	driver.findElement(By.xpath(xpath));
	}

	//intiallization
	public CommonPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//Business Logic
	public void clickTab(TabNames tabName) {
		convertToWebElement(tabPartialXpath, tabName.getTab()).click();
	}

	public void signout(IntractionUtility intraction) {
		intraction.mouseHover(admistrorIcon);
		signOutLink.click();
	}



}
