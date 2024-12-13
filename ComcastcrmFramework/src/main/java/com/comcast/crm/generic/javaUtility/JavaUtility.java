package com.comcast.crm.generic.javaUtility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import org.testng.annotations.Test;

public class JavaUtility {
	@Test
public  int getRandomno()
{
	Random r=new Random();
	int randomnum = r.nextInt(5000);//within the given boundary it will pick one number and return
	 return randomnum;//As it returns int type of data
}

public String getSystemDateYYYYDDMM()
{
     
    Date dateobj = new Date();//import from java.util not sql
	SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
	String actualsystemdate = sim.format(dateobj);
	return actualsystemdate;
}

public String getRequiredDateyyyMMdd(int days)
{
	Date dateobj= new Date();
	SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
	sim.format(dateobj);

	Calendar cal = sim.getCalendar();
	cal.add(Calendar.DAY_OF_MONTH, days);// after one month from current date
	String reqdate = sim.format(cal.getTime());//calendar is in object type in order to convert it to dateobject we use getTime
	System.out.println(reqdate);
	return reqdate;
}
}
