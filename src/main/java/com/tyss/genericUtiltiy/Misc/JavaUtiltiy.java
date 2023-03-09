package com.tyss.genericUtiltiy.Misc;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

/**
 * 
 * @author MOHAN GOWDA
 *
 */
public class JavaUtiltiy {
	/**
	 * 
	 * @param boundryValue
	 * @return
	 */
	public int getRandomNumber(int boundryValue){
		return new Random().nextInt(boundryValue);
	}

	/**
	 * 
	 * @param output
	 */
	public void consolePrint(Object output){
		System.out.println(output);
	}


	/**
	 * This method is used to convert monthName into month Number
	 * please specify the pattern as below specified
	 * MMMM --> month full name
	 * MMM --> month short name
	 * @param monthName
	 * @param pattern
	 */
	public int getMonthNumber(String monthName, String pattern) {
		int monthNumber = DateTimeFormatter.ofPattern(pattern.toUpperCase())
				.withLocale(Locale.ENGLISH)
				.parse(monthName)
				.get(ChronoField.MONTH_OF_YEAR);
		return monthNumber;
	}

	/**
	 * 
	 * @param s
	 * @return
	 */
	public int parseNumber(String s) {
		return Integer.parseInt(s);
	}
	/**
	 * 
	 * @param s
	 * @param strategy
	 * @return
	 */
	public String[] split(String s, String strategy) {
		return s.split(strategy);
	}
	/**
	 * 
	 * @param s
	 * @return
	 */
	public String decode(String s) {
		return	new String(Base64.getDecoder().decode(s.getBytes()));
	}
	/**
	 * 
	 * @param s
	 * @return
	 */
	public String encode(String s) {
		return	new String(Base64.getEncoder().encode(s.getBytes()));
	}
	/**
	 * 
	 * @return
	 */
	public String getCurrentDateTime() {
		SimpleDateFormat sdf=new SimpleDateFormat("dd_MM_yyyy_HH_mm_sss");
		return	sdf.format(new Date());
	}
	/**
	 * 
	 * @param pattern
	 * @return
	 */
	public String getCurrentDateTime(String pattern) {
		SimpleDateFormat sdf=new SimpleDateFormat(pattern);
		return	sdf.format(new Date());
	}
	/**
	 * 
	 * @param days
	 * @return
	 */
	public String addOrSubstractDate(int days) {
		SimpleDateFormat sdf=new SimpleDateFormat("dd_MM_yyyy");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, days);
		return	sdf.format(cal.getTime());
	}
	/**
	 * 
	 * @param date
	 * @param days
	 * @return
	 * @throws ParseException
	 */
	public String addOrSubstractDate(String date,int days) throws ParseException {
		SimpleDateFormat sdf=new SimpleDateFormat("dd_MM_yyyy");
		Calendar cal = Calendar.getInstance();
		cal.setTime(sdf.parse(date));
		cal.add(Calendar.DAY_OF_MONTH, days);
		return	sdf.format(cal.getTime());
	}

	
	public String encoderString(String stringData) {
	return	URLEncoder.encode(stringData, StandardCharsets.UTF_8);
	}

}
