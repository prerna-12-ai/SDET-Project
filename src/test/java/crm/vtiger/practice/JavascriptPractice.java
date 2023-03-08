package crm.vtiger.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.tyss.genericUtiltiy.WebAction.JavaScriptUtility;
import com.tyss.genericUtiltiy.WebAction.SeleniumUtilitiy;

import crm.vtiger.objectRepository.LoginPage;


public class JavascriptPractice {
	public static void main(String[] args) throws InterruptedException {
		
	
		
		SeleniumUtilitiy seleniumUtilitiy=new SeleniumUtilitiy();
		WebDriver driver = seleniumUtilitiy.launchBrowser("chrome");
		driver.manage().window().maximize();
		JavaScriptUtility javaScriptUtility=new JavaScriptUtility(driver);
		javaScriptUtility.launchApplication("http://localhost:8888");
		LoginPage loginPage=new LoginPage(driver);
		loginPage.loginAction("admin", "admin");
		/*
		javaScriptUtility.scrollDown();
		Thread.sleep(2000);
		javaScriptUtility.scrollUp();
		Thread.sleep(2000);
		WebElement ele = driver.findElement(By.xpath("//b[contains(.,'Upcoming Activities')]"));
		javaScriptUtility.scrollTillElement(ele);
		*/
	}
	

}
