package com.tyss.genericUtiltiy.WebAction;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * 
 * @author MOHAN GOWDA
 *
 */
public class JavaScriptUtility {
	JavascriptExecutor js;

	/**
	 * 
	 * @param driver
	 */
	public JavaScriptUtility(WebDriver driver){
		js = (JavascriptExecutor)driver;
	}
	/**
	 * 
	 */
	public void scrollUp() {
		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
	}
	/**
	 * 
	 * @param element
	 */
	public void scrollTillElement(WebElement element) {
		js.executeScript("arguments[0].scrollIntoView()", element);
	}
	/**
	 * 
	 */
	public void scrollDown() {
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}
	/**
	 * 
	 * @param element
	 */
	public void click(WebElement element) {
		js.executeScript("arguments[0].click()",element);
	}
	/**
	 * 
	 * @param element
	 * @param data
	 */
	public void sendKeys(WebElement element, String data) {
		js.executeScript("arguments[0].value=arguments[1]",element,data);
	}
	/**
	 * 
	 * @param url
	 */
	public void launchApplication(String url) {
		js.executeScript("window.location=arguments[0]",url);
	}
	
	/**
	 * 
	 * @param element
	 */
	public void highlight(WebElement element) {
		js.executeScript("arguments[0].setAttribute('style','border:6px dotted red;');",element);
	}
}
