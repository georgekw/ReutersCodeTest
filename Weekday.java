package codeTest;

import java.util.*;

public class Weekday {
  
	public ArrayList<Date> getWeekdays(GregorianCalendar startDate, GregorianCalendar endDate) {
		ArrayList<Date> weekdays = new ArrayList<Date>();

	    if ((startDate == null) || (endDate == null))
	    	return weekdays;

	    if (startDate.equals(endDate)) {
	    	if (isWeekday(startDate)) {
	    		weekdays.add(startDate.getTime());
	        }
	    }
	    else if (startDate.after(endDate)) {
	    	weekdays = getWeekdays(endDate, startDate);
	    }
	    else {
	    	GregorianCalendar d = startDate;
	        while (d.before(endDate) || d.equals(endDate)) {
	        	if (isWeekday(d)) {
	        		weekdays.add(d.getTime());
	            }  
	            d.add(Calendar.DATE, 1);
	        }	       
	   }
	   return weekdays;
	}
	
	public boolean isWeekday(GregorianCalendar d) {
		if (d == null)
			return false;

	    int dayOfWeek = d.get(Calendar.DAY_OF_WEEK);
	    
	    return ((dayOfWeek >= Calendar.MONDAY) && (dayOfWeek <= Calendar.FRIDAY));
	}

	public static void main(String[] args) {
		/*Weekday wd = new Weekday();
		GregorianCalendar startDate = new GregorianCalendar(2013, Calendar.MAY, 24);
		GregorianCalendar endDate = new GregorianCalendar(2013, Calendar.JUNE, 24);

		ArrayList<Date> weekdays = wd.getWeekdays(startDate, endDate);
		for (Date d : weekdays) {
				System.out.println(d.toString());
		}*/
	}
}
