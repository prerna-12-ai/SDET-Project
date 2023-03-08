package com.tyss.genericUtiltiy.Misc;
/**
 * 
 * @author MOHAN GOWDA
 *
 */
public class VerificationUtility {
	/**
	 * 
	 * @param actual
	 * @param expected
	 */
	public void exactVerify(String actual, String expected,String strategy,String pageOrElementOrTCname) {

		if(strategy.equalsIgnoreCase("TC")) {
			if(actual.equals(expected))
			{
				System.out.println(pageOrElementOrTCname+" TC is Pass");
			}
			else {
				System.out.println(pageOrElementOrTCname+" TC is Fail");
			}
		}
		else if(strategy.equalsIgnoreCase("page")) {
			if(actual.equals(expected))
			{
				System.out.println(pageOrElementOrTCname+" Page Dispayed");
			}
			else {
				System.out.println(pageOrElementOrTCname+" Page not Displyed");
			}

		}
		else if(strategy.equalsIgnoreCase("element")) {
			if(actual.equals(expected))
			{
				System.out.println(pageOrElementOrTCname+" is showing");
			}
			else {
				System.out.println(pageOrElementOrTCname+" is not showing");
			}

		}
	}



/**
 * 
 * @param actual
 * @param expected
 * @param strategy
 * @param pageOrElementOrTCname
 */
	public void exactVerify1(String actual, String expected,String strategy,String pageOrElementOrTCname) {
		String pass="";
		String fail="";
		switch (strategy.toUpperCase()) {
		case "TC":
			pass=" TC is Pass";
			fail=" TC is Fail";
			break;
		case "PAGE":
			pass=" Page Dispayed";
			fail=" Page not Displyed";
			break;
		case "ELEMENT":
			pass=" is showing";
			fail=" is not showing";
			break;
		default:
			break;
		}
		if(actual.equals(expected))
		{
			System.out.println(pageOrElementOrTCname+pass);
		}
		else {
			System.out.println(pageOrElementOrTCname+fail);
		}
	}


	/**
	 * 
	 * @param actual
	 * @param expected
	 * @param strategy
	 * @param pageNameOrTCname
	 */
	public void partialVerify(String actual, String expected,String strategy,String pageNameOrTCname) {
		if(strategy.equalsIgnoreCase("TC")) {
			if(actual.contains(expected))
			{
				System.out.println(pageNameOrTCname+" TC is Pass");
			}
			else {
				System.out.println(pageNameOrTCname+" TC is Fail");
			}
		}
		else if(strategy.equalsIgnoreCase("page")) {
			if(actual.contains(expected))
			{
				System.out.println(pageNameOrTCname+" Page Dispayed");
			}
			else {
				System.out.println(pageNameOrTCname+" Page not Displyed");
			}

		}}

}
