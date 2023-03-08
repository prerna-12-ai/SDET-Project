package crm.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	//declaration
	@FindAll({@FindBy(name="user_name"),@FindBy(xpath = "//input[@name='user_name']")})private WebElement userNameTxtField;
	@FindBy(xpath = "//input[@name='user_password']") private WebElement passwordTxtField;
	@FindBy(xpath = "//input[@id='submitButton']") private WebElement loginBtn;

	
	//intiallization
	public LoginPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	//utilization --> business logic
	public void loginAction(String username, String password) {
		userNameTxtField.sendKeys(username);
		passwordTxtField.sendKeys(password);
		loginBtn.click();
	}




}
