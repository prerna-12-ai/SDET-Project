package com.tyss.genericUtiltiy.WebAction;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
/**
 * 
 * @author MOHAN GOWDA
 *
 */
public class WaitUtiliy {
private	WebDriverWait wait;
private WebDriver driver;
	/**
	 * 
	 * @param driver
	 * @param timeout
	 */
	public WaitUtiliy(WebDriver driver, long timeout){
		this.driver=driver;
	wait=new WebDriverWait(driver, 10);
	}
/**
 * 
 * @param milisecond
 */
	public void pause(long milisecond) {
		try {
			Thread.sleep(milisecond);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 
	 * @param driver
	 * @param timeout
	 */
	public void waitForElementLoad(WebDriver driver, long timeout){
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS); 
	}
	
	
	/**
	 * 
	 * @param xpath
	 */
	public void waitUntillVisible(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * 
	 * @param xpath
	 */
	public void waitUntillClickable(String xpath) {
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(xpath))));
	}
	/**
	 * 
	 * @param xpath
	 */
	public void waitUntillInvisible(String xpath) {
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath(xpath))));
	}
	/**
	 * 
	 * @param xpath
	 * @param text
	 */
	public void waitUntillInvisibleOfText(String xpath, String text) {
		wait.until(ExpectedConditions.invisibilityOfElementWithText(By.xpath(xpath),text));
	}
	/**
	 * 
	 * @param pollingTime
	 * @param duration
	 * @param element
	 * @throws InterruptedException
	 */
	public void waitandClick(long pollingTime,int duration,  WebElement element) throws InterruptedException {
		int count=0;
		while(count<duration) {
			try {
				element.click();
				break;
			}catch(Exception e) {
				Thread.sleep(pollingTime);
				count=count+((int)pollingTime/1000);
			}
		}
	}
	
	
}
