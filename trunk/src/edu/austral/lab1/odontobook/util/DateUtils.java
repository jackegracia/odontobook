package edu.austral.lab1.odontobook.util;

import java.util.Calendar;
import java.util.Date;

public class DateUtils {
	


	public static Date getDate(final int date, final int month, final int year)
	{
		Calendar myCalendar = Calendar.getInstance();
		myCalendar.clear();
		myCalendar.set(year, month, date);

		return myCalendar.getTime();
	}
	
	public static Date getDate(final Date theDate)
	{
		Calendar myCalendar = Calendar.getInstance();
		myCalendar.setTime(theDate);
		
		final int date = myCalendar.get(Calendar.DATE);
		final int month = myCalendar.get(Calendar.MONTH);
		final int year = myCalendar.get(Calendar.YEAR);
		
		myCalendar.clear();
		myCalendar.set(year, month, date);
		
		return myCalendar.getTime();
	}


}
