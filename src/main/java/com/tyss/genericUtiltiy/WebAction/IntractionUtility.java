package com.tyss.genericUtiltiy.WebAction;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
/**
 * 
 * @author MOHAN GOWDA
 *
 */
public class IntractionUtility {
	private Actions act;
	/**
	 * 
	 * @param driver
	 */
	public IntractionUtility(WebDriver driver) {
		 act=new Actions(driver);
	}
	/**
	 * 
	 * @param element
	 */
	public void mouseHover(WebElement element) {
		act.moveToElement(element).perform();
	}
/**
 * 
 * @param element
 */
	public void doubleClick(WebElement element) {
		act.doubleClick(element).perform();
	}
	
	/**
	 * 
	 */
	public void doubleClick() {
		act.doubleClick().perform();
	}
	/**
	 * 
	 * @param element
	 */
	public void rightClick(WebElement element) {
		act.contextClick(element).perform();
	}
	/**
	 * 
	 */
	public void rightClick() {
		act.contextClick().perform();
	}
	/**
	 * 
	 */
	public void enter() {
		act.keyDown(Keys.ENTER).perform();
	}
	/**
	 * 
	 * @param srcElement
	 * @param targetElement
	 */
	public void dragDrop(WebElement srcElement, WebElement targetElement) {
		act.dragAndDrop(srcElement, targetElement).perform();
	}
	
	
}
