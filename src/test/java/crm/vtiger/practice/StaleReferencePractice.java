package crm.vtiger.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.tyss.genericUtiltiy.WebAction.JavaScriptUtility;
import com.tyss.genericUtiltiy.WebAction.SeleniumUtilitiy;

public class StaleReferencePractice {
	
	public static void main(String[] args) {
		SeleniumUtilitiy seleniumUtilitiy=new SeleniumUtilitiy();
		WebDriver driver = seleniumUtilitiy.launchBrowser("chrome");
		
		JavaScriptUtility javaScriptUtility=new JavaScriptUtility(driver);
		javaScriptUtility.launchApplication("http://localhost:8888");
		
		WebElement userNameTxtField = driver.findElement(By.name("user_name"));
		WebElement passwordTxtField = driver.findElement(By.name("user_password"));
		WebElement loginBtn = driver.findElement(By.id("submitButton"));
	
	userNameTxtField.sendKeys("admin");
passwordTxtField.sendKeys("admin");
	loginBtn.click();
	
	driver.findElement(By.linkText("Organizations")).click();
	WebElement d = driver.findElement(By.xpath("//a[@class='hdrLink' and contains(.,'Org')]"));
	driver.findElement(By.linkText("Contacts")).click();
	
	System.out.println(d.getText());
	
	}

}
