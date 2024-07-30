package com.comcast.crm.generic.webdriverutility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	
	public int getRandomNumber() {
		Random random = new Random();
		int rannum=random.nextInt(5000);
		return rannum;
	}
	
	public String getSystemDateDDMMYYYY() {
		
		Date dateobj = new Date();
		
		SimpleDateFormat sdf = new SimpleDateFormat();
		String date = sdf.format(dateobj);
		return date;
	}
	
	public String getRequiredDateDDMMYYYY(int days) {
		SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
		
		Calendar cal= sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH,days);
		String reqdate = sim.format(cal.getTime());
		return reqdate;
	}
}
